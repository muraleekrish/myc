package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.MessagesTo;

/**
 * A data access object (DAO) providing persistence and search support for
 * MessagesTo entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.mycove.vo.MessagesTo
 */

public class MessagesToDAO extends BaseDAO<MessagesTo> {

	private final static Logger log = Logger.getLogger(MessagesToDAO.class);
	
	// property constants

	/**
	 * Delete a persistent MessagesTo entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity MessagesTo entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(MessagesTo entity) throws Exception {
		log.info("deleting MessagesTo instance");
		try {
			entity = getEntityManager().getReference(MessagesTo.class, entity.getId());
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

	public MessagesTo findById(Long id) {
		log.info("finding MessagesTo instance with id: " + id);
		try {
			MessagesTo instance = getEntityManager().find(MessagesTo.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all MessagesTo entities with a specific property value.
	 * 
	 * @param propertyName the name of the MessagesTo property to query
	 * @param value the property value to match
	 * @return List<MessagesTo> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MessagesTo> findByProperty(String propertyName,
			final Object value) {
		log.info("finding MessagesTo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from MessagesTo model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed",  e);
			throw e;
		}
	}

	/**
	 * Find all MessagesTo entities.
	 * 
	 * @return List<MessagesTo> all MessagesTo entities
	 */
	@SuppressWarnings("unchecked")
	public List<MessagesTo> findAll() {
		log.info("finding all MessagesTo instances");
		try {
			final String queryString = "select model from MessagesTo model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}