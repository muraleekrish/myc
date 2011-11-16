package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.SurveyOptions;

/**
 * A data access object (DAO) providing persistence and search support for
 * SurveyOptions entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.mycove.vo.SurveyOptions
 * @author MyEclipse Persistence Tools
 */

public class SurveyOptionsDAO extends BaseDAO<SurveyOptions> {

	private final static Logger log = Logger.getLogger(SurveyOptionsDAO.class);
	
	// property constants
	public static final String OPTION_TEXT = "optionText";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";

	/**
	 * Delete a persistent SurveyOptions entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity SurveyOptions entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(SurveyOptions entity) throws Exception {
		log.info("deleting SurveyOptions instance");
		try {
			entity = getEntityManager().getReference(SurveyOptions.class,
					entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	public SurveyOptions findById(Long id) {
		log.info("finding SurveyOptions instance with id: " + id);
		try {
			SurveyOptions instance = getEntityManager().find(
					SurveyOptions.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all SurveyOptions entities with a specific property value.
	 * 
	 * @param propertyName the name of the SurveyOptions property to query
	 * @param value the property value to match
	 * @return List<SurveyOptions> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<SurveyOptions> findByProperty(String propertyName,
			final Object value) {
		log.info("finding SurveyOptions instance with property: " + propertyName + ", value: " + value);
		try {
			final String queryString = "select model from SurveyOptions model where model."
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
	 * Find all SurveyOptions entities.
	 * 
	 * @return List<SurveyOptions> all SurveyOptions entities
	 */
	@SuppressWarnings("unchecked")
	public List<SurveyOptions> findAll() {
		log.info("finding all SurveyOptions instances");
		try {
			final String queryString = "select model from SurveyOptions model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}