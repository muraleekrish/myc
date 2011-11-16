package com.mycove.dao;

// default package

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.dto.EmployeeDTO;
import com.mycove.util.dbutil.EntityManagerHelper;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Employee;

/**
 * A data access object (DAO) providing persistence and search support for
 * Employee entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see .Employee
 */

public class EmployeeDAO extends UserDAO<Employee> {
	
	private final static Logger log = Logger.getLogger(EmployeeDAO.class);
	
	// property constants
	public static final String ADDRESS1 = "address1";
	public static final String ADDRESS2 = "address2";
	public static final String EMPLOYEE_TYPE = "employeeType";

	/**
	 * Delete a persistent Employee entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Employee entity to delete
	 * @throws Exception when the operation fails
	 */
	public void delete(Employee entity) throws Exception {

		log.info("deleting Employee instance");
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.getReference(Employee.class, entity.getId());
			em.remove(entity);
			em.getTransaction().commit();
			log.info("deleted successfully");
		} catch (Exception e) {
			log.error("deletion failed", e);
			if (FormUtil.isNotNull(em)) {
				em.getTransaction().rollback();
				EntityManagerHelper.closeEntityManager();
			}
			throw e;
		}
	}

	public Employee findById(Long id) {
		log.info("finding Employee instance with id: " + id);
		try {
			Employee instance = getEntityManager().find(Employee.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all Employee entities with a specific property value.
	 * 
	 * @param propertyName the name of the Employee property to query
	 * @param value the property value to match
	 * @return List<Employee> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> findEmployeeByField(String propertyName, final Object value) {
		log.info("finding Employee instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Employee model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return (List<Employee>)query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed", e);
			throw e;
		}
	}

	public List<Employee> findByEmployeeType(Object employeeType) {
		return findEmployeeByField(EMPLOYEE_TYPE, employeeType);
	}

	/**
	 * Find all Employee entities.
	 * 
	 * @return List<Employee> all Employee entities
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployee() {
		log.info("finding all Employee instances");
		try {
			final String queryString = "select model from Employee model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeDTO> getEmployeeByUserName(Long userId)
	{
		StringBuffer queryString = new StringBuffer();
		queryString.append("SELECT employee.id, mycoveUser.first_name AS firstName, mycoveUser.middle_name AS middleName, ")
				.append("mycoveUser.last_name AS lastName, property_master.property_name AS propertyName, employee.employee_type AS employeeType, ")
				.append("mycoveUser.email AS email, mycoveUser.cell_phone AS cellPhone, CASE WHEN mycoveUser.active_flag THEN 'Yes' ELSE 'No' END AS active ")
				.append("FROM user_property AS up ")
				.append("JOIN employee ON up.user_id = employee.id ")
				.append("JOIN mycove_user AS mycoveUser ON mycoveUser.id = employee.id ")
				.append("JOIN property_master ON property_master.id = up.property_id ")
				.append("JOIN (SELECT user_property.property_id FROM public.user_property ")
				.append("JOIN public.mycove_user ON user_property.user_id = mycove_user.id ")
				.append("WHERE mycove_user.id = :userId) a  ")
				.append("ON a.property_id = up.property_id ")
				.append("GROUP BY employee.id, mycoveUser.first_name, mycoveUser.middle_name, ")
				.append("mycoveUser.last_name, property_master.property_name, employee.employee_type, ")
				.append("mycoveUser.email, mycoveUser.cell_phone, mycoveUser.active_flag ")
				.append("ORDER BY mycoveUser.first_name, ")
				.append("property_master.property_name, employee.employee_type;");

		Query query = getEntityManager().createNativeQuery(queryString.toString(), EmployeeDTO.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}
