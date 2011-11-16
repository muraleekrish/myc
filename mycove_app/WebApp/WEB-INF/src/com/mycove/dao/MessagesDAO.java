package com.mycove.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.Messages;

/**
 * A data access object (DAO) providing persistence and search support for
 * Messages entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 */

public class MessagesDAO extends BaseDAO<Messages> {
	
	private final static Logger log = Logger.getLogger(MessagesDAO.class);
	// property constants
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String SUBJECT = "subject";
	public static final String MESSAGE_TEXT = "messageText";
	public static final String FOLDER_NAME = "folderName";
	public static final String FROM_USER = "fromUser";

	/**
	 * Delete a persistent Messages entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Messages entity to delete
	 * @throws Exception 
	 */
	public void delete(Messages entity) throws Exception {
		log.info("deleting Messages instance");
		entity = getEntityManager().getReference(Messages.class, entity.getId());
		super.delete(entity);
		log.info("Messages instance deleted successfully");
	}


	public Messages findById(Long id) {
		log.info("finding Messages instance with id: " + id);
		Messages instance = getEntityManager().find(Messages.class, id);
		return instance;
	}

	/**
	 * Find all Messages entities with a specific property value.
	 * 
	 * @param propertyName the name of the Messages property to query
	 * @param value the property value to match
	 * @return List<Messages> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Messages> findByProperty(String propertyName, final Object value) {
		log.info("finding Messages instance with property: " + propertyName + ", value: " + value);
		final String queryString = "select model from Messages model where model." + propertyName + "= :propertyValue";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("propertyValue", value);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Collection<Messages> getMessages(Long userId, String folderName)
	{
		List<Messages> messages = new ArrayList<Messages>();
		Query query = getEntityManager().createQuery("select model from Messages model where model.folderName= :folderName and model.user.id= :userId ORDER BY createdDate DESC");
		query.setParameter("folderName", folderName);
		query.setParameter("userId", userId);
		messages = query.getResultList();
		return messages;
	}

	/**
	 * Find all Messages entities.
	 * 
	 * @return List<Messages> all Messages entities
	 */
	@SuppressWarnings("unchecked")
	public List<Messages> findAll() {
		log.info("finding all Messages instances");
		final String queryString = "select model from Messages model";
		Query query = getEntityManager().createQuery(queryString);
		return query.getResultList();
	}
}