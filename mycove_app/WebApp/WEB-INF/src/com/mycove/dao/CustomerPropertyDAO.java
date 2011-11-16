package com.mycove.dao;

// default package

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.CustomerProperty;

/**
 * A data access object (DAO) providing persistence and search support for
 * CustomerProperty entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see .CustomerProperty
 */

public class CustomerPropertyDAO extends BaseDAO<CustomerProperty> {
	
	private final static Logger log = Logger.getLogger(CustomerPropertyDAO.class);
	
	// property constants

	/**
	 * Delete a persistent CustomerProperty entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity CustomerProperty entity to delete
	 * @throws Exception when the operation fails
	 */
	public void delete(CustomerProperty entity) throws Exception {
		log.info("deleting CustomerProperty instance");
		try {
			entity = getEntityManager().getReference(CustomerProperty.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed",  e);
			throw e;
		} catch (Exception e) {
			log.error("delete failed",  e);
			throw e;
		}
	}

	public CustomerProperty findById(Long id) {
		log.info("finding CustomerProperty instance with id: " + id);
		try {
			CustomerProperty instance = getEntityManager().find( CustomerProperty.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed",  e);
			throw e;
		}
	}

	/**
	 * Find all CustomerProperty entities with a specific property value.
	 * 
	 * @param propertyName the name of the CustomerProperty property to query
	 * @param value the property value to match
	 * @return List<CustomerProperty> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerProperty> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding CustomerProperty instance with property: "
						+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from CustomerProperty model where model."
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
	 * Find all CustomerProperty entities.
	 * 
	 * @return List<CustomerProperty> all CustomerProperty entities
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerProperty> findAll() {
		log.info("finding all CustomerProperty instances");
		try {
			final String queryString = "select model from CustomerProperty model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed",  e);
			throw e;
		}
	}

}