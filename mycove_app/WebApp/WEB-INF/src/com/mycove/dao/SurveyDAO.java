package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.Survey;

/**
 * A data access object (DAO) providing persistence and search support for
 * Survey entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.mycove.vo.Survey
 * @author MyEclipse Persistence Tools
 */

public class SurveyDAO extends BaseDAO<Survey> {

	private final static Logger log = Logger.getLogger(SurveyDAO.class);
	
	
	// property constants
	public static final String QUESTION = "question";
	public static final String START_YEAR = "startYear";
	public static final String START_MONTH = "startMonth";
	public static final String START_DAY = "startDay";
	public static final String END_YEAR = "endYear";
	public static final String END_MONTH = "endMonth";
	public static final String END_DAY = "endDay";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String CLOSE_FLAG = "closeFlag";

	/**
	 * Delete a persistent Survey entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Survey entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Survey entity) throws Exception {
		log.info("deleting Survey instance");
		try {
			entity = getEntityManager().getReference(Survey.class,
					entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	public Survey findById(Long id) {
		log.info("finding Survey instance with id: " + id);
		try {
			Survey instance = getEntityManager().find(Survey.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all Survey entities with a specific property value.
	 * 
	 * @param propertyName the name of the Survey property to query
	 * @param value the property value to match
	 * @return List<Survey> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Survey> findByProperty(String propertyName, final Object value) {
		log.info("finding Survey instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Survey model where model."
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
	 * Find all Survey entities.
	 * 
	 * @return List<Survey> all Survey entities
	 */
	@SuppressWarnings("unchecked")
	public List<Survey> findAll() {
		log.info("finding all Survey instances");
		try {
			final String queryString = "select model from Survey model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
}