package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.MessageCC;

/**
 * A data access object (DAO) providing persistence and search support for
 * MessageCC entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see .MessageCC
 */

public class MessageCCDAO extends BaseDAO<MessageCC> {

	private final static Logger log = Logger.getLogger(MessageCCDAO.class);
	
	// property constants

	
	/**
	 * Delete a persistent MessageCC entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity MessageCC entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(MessageCC entity) throws Exception {
		log.info("deleting MessageCC instance");
		try {
			entity = getEntityManager().getReference(MessageCC.class, entity.getId());
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


	public MessageCC findById(Long id) {
		log.info("finding MessageCC instance with id: " + id);
		try {
			MessageCC instance = getEntityManager().find(MessageCC.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all MessageCC entities with a specific property value.
	 * 
	 * @param propertyName the name of the MessageCC property to query
	 * @param value the property value to match
	 * @return List<MessageCC> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MessageCC> findByProperty(String propertyName,
			final Object value) {
		log.info("finding MessageCC instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from MessageCC model where model."
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
	 * Find all MessageCC entities.
	 * 
	 * @return List<MessageCC> all MessageCC entities
	 */
	@SuppressWarnings("unchecked")
	public List<MessageCC> findAll() {
		log.info("finding all MessageCC instances");
		try {
			final String queryString = "select model from MessageCC model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}