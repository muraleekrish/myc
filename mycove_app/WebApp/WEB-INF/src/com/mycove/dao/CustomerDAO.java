package com.mycove.dao;
// default package

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.Customer;

	/**
 	 * A data access object (DAO) providing persistence and search support for Customer entities.
	 * Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
	   or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
	 * @see .Customer
	 */

public class CustomerDAO extends BaseDAO<Customer> {

	private final static Logger log = Logger.getLogger(CustomerDAO.class);

	// property constants
	public static final String CLIENT_NAME = "clientName";
	public static final String STREET_ADDRESS = "streetAddress";
	public static final String ADDRESS2 = "address2";
	public static final String CITY = "city";
	public static final String STATE = "state";
	public static final String ZIP_CODE = "zipCode";
	public static final String CUSTOMER_ADMIN_USERNAME = "customerAdminUsername";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ACTIVE_FLAG = "activeFlag";
	public static final String PRIMARY_CONTACT_FIRST_NAME = "primaryContactFirstName";
	public static final String PRIMARY_CONTACT_LAST_NAME = "primaryContactLastName";
	public static final String PRIMARY_CONTACT_EMAIL_ADDRESS = "primaryContactEmailAddress";
	public static final String PRIMARY_CONTACT_PHONE_NUMBER = "primaryContactPhoneNumber";
	public static final String PRIMARY_CONTACT_MIDDLE_NAME = "primaryContactMiddleName";
	public static final String PRIMARY_CONTACT_SECONDARY_PHONE = "primaryContactSecondaryPhone";

	/**
	 * Delete a persistent Customer entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity
	 *            Customer entity to delete
	 * @throws Exception
	 *             when the operation fails
	 */
	public void delete(Customer entity) throws Exception {
		log.info("deleting Customer instance");
		try {
			entity = getEntityManager().getReference(Customer.class,
					entity.getId());
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

	/**
	 * Find all Customer entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Customer property to query
	 * @param value
	 *            the property value to match
	 * @return List<Customer> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findByProperty(String propertyName, final Object value) {
		log.info("finding Customer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from Customer model where model."
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
	 * 
	 * @param id
	 * @return
	 */
	public Customer findById(Long id) {
		log.info("finding Apartment instance with id: " + id);
		try {
			Customer instance = getEntityManager().find(Customer.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}
	
	/**
	 * Find all Customer entities.
	 * 
	 * @return List<Customer> all Customer entities
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		log.info("finding all Customer instances");
		try {
			final String queryString = "select model from Customer model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}