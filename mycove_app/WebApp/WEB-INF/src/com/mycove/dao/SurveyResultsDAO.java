package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.SurveyResults;

/**
 * A data access object (DAO) providing persistence and search support for
 * SurveyResults entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.mycove.vo.SurveyResults
 * @author MyEclipse Persistence Tools
 */

public class SurveyResultsDAO extends BaseDAO<SurveyResults> {

	private final static Logger log = Logger.getLogger(SurveyResultsDAO.class);
	
	// property constants
	public static final String OPTED_FLAG = "optedFlag";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";

	

	/**
	 * Delete a persistent SurveyResults entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity SurveyResults entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(SurveyResults entity) throws Exception {
		log.info("deleting SurveyResults instance");
		try {
			entity = getEntityManager().getReference(SurveyResults.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}


	public SurveyResults findById(Long id) {
		log.info("finding SurveyResults instance with id: " + id);
		try {
			SurveyResults instance = getEntityManager().find(SurveyResults.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all SurveyResults entities with a specific property value.
	 * 
	 * @param propertyName the name of the SurveyResults property to query
	 * @param value the property value to match
	 * @return List<SurveyResults> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<SurveyResults> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding SurveyResults instance with property: " + propertyName
						+ ", value: " + value);
		try {
			final String queryString = "select model from SurveyResults model where model."
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
	 * Find all SurveyResults entities.
	 * 
	 * @return List<SurveyResults> all SurveyResults entities
	 */
	@SuppressWarnings("unchecked")
	public List<SurveyResults> findAll() {
		log.info("finding all SurveyResults instances");
		try {
			final String queryString = "select model from SurveyResults model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}