package com.mycove.dao;

// default package

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.dto.MessageTemplateDTO;
import com.mycove.vo.MessageTemplate;

/**
 * A data access object (DAO) providing persistence and search support for
 * MessageTemplate entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see .MessageTemplate
 */

public class MessageTemplateDAO extends BaseDAO<MessageTemplate> {
	

	private final static Logger log = Logger.getLogger(MessageTemplateDAO.class);
	
	// property constants
	public static final String TEMPLATE_NAME = "templateName";
	public static final String SUBJECT = "subject";
	public static final String MESSAGE_TEXT = "messageText";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";

	/**
	 * Delete a persistent MessageTemplate entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity MessageTemplate entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(MessageTemplate entity) throws Exception {
		log.info("deleting MessageTemplate instance");
		try {
			entity = getEntityManager().getReference(MessageTemplate.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	public MessageTemplate findById(Long id) {
		log.info("finding MessageTemplate instance with id: "
				+ id);
		try {
			MessageTemplate instance = getEntityManager().find(MessageTemplate.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all MessageTemplate entities with a specific property value.
	 * 
	 * @param propertyName the name of the MessageTemplate property to query
	 * @param value the property value to match
	 * @return List<MessageTemplate> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MessageTemplate> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding MessageTemplate instance with property: "
						+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from MessageTemplate model where model."
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
	 * Find all MessageTemplate entities.
	 * 
	 * @return List<MessageTemplate> all MessageTemplate entities
	 */
	@SuppressWarnings("unchecked")
	public List<MessageTemplate> findAll() {
		log.info("finding all MessageTemplate instances");
		try {
			final String queryString = "select model from MessageTemplate model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
	
	public List<MessageTemplateDTO> getAllTemplateByPropertyManagerId(Long propertyManagerId) {
		log.info("get All MessageTemplate instances By PropertyManagerId");
		try {
			final String queryString = "select message_template.id AS id, message_template.template_name AS templateName, subject, property_master.property_name AS propertyName FROM message_template JOIN user_property ON user_property.property_id = message_template.property_id JOIN property_master ON property_master.id = user_property.property_id WHERE user_property.user_id = :userId";
			Query query = getEntityManager().createNativeQuery(queryString, MessageTemplateDTO.class);
			query.setParameter("userId", propertyManagerId);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
}
