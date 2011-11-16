package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.UserProperty;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserProperty entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.mycove.vo.UserProperty
 * @author MyEclipse Persistence Tools
 */

public class UserPropertyDAO extends BaseDAO<UserProperty> {

	private final static Logger log = Logger.getLogger(UserPropertyDAO.class);
	
	

	/**
	 * Delete a persistent UserProperty entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity UserProperty entity to delete
	 * @throws Exception 
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(UserProperty entity) throws Exception {
		log.info("deleting UserProperty instance");
		try {
			entity = getEntityManager().getReference(UserProperty.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	public UserProperty findById(Long id) {
		log.info("finding UserProperty instance with id: " + id);
		try {
			UserProperty instance = getEntityManager().find(UserProperty.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all UserProperty entities with a specific property value.
	 * 
	 * @param propertyName the name of the UserProperty property to query
	 * @param value the property value to match
	 * @return List<UserProperty> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<UserProperty> findByProperty(String propertyName,
			final Object value) {
		log.info("finding UserProperty instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from UserProperty model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed",e);
			throw e;
		}
	}

	/**
	 * Find all UserProperty entities.
	 * 
	 * @return List<UserProperty> all UserProperty entities
	 */
	@SuppressWarnings("unchecked")
	public List<UserProperty> findAll() {
		log.info("finding all UserProperty instances");
		try {
			final String queryString = "select model from UserProperty model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}