package com.mycove.dao;

// default package

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.EmployeePrivilege;

/**
 * A data access object (DAO) providing persistence and search support for
 * EpmloyeePrivilege entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see .EpmloyeePrivilege
 */

public class EmployeePrivilegeDAO extends BaseDAO<EmployeePrivilege>{
	
	private final static Logger log = Logger.getLogger(EmployeePrivilegeDAO.class);
	
	// property constants

	/**
	 * Delete a persistent EpmloyeePrivilege entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity EpmloyeePrivilege entity to delete
	 * @throws Exception when the operation fails
	 */
	public void delete(EmployeePrivilege entity) throws Exception {
		log.info("deleting EpmloyeePrivilege instance");
		try {
			entity = getEntityManager().getReference(EmployeePrivilege.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		} catch (Exception e) {
			log.error("delete failed", e);
			throw e;
		}
	}


	public EmployeePrivilege findById(Long id) {
		log.info("finding EpmloyeePrivilege instance with id: " + id);
		try {
			EmployeePrivilege instance = getEntityManager().find(EmployeePrivilege.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all EpmloyeePrivilege entities with a specific property value.
	 * 
	 * @param propertyName the name of the EpmloyeePrivilege property to query
	 * @param value the property value to match
	 * @return List<EpmloyeePrivilege> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeePrivilege> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding EpmloyeePrivilege instance with property: "
						+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from EpmloyeePrivilege model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed", e);
			throw e;
		}
	}

	/**
	 * Find all EpmloyeePrivilege entities.
	 * 
	 * @return List<EpmloyeePrivilege> all EpmloyeePrivilege entities
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeePrivilege> findAll() {
		log.info("finding all EpmloyeePrivilege instances");
		try {
			final String queryString = "select model from EpmloyeePrivilege model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}