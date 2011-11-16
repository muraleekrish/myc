package com.mycove.dao;

// default package

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.CodeDetail;

/**
 * A data access object (DAO) providing persistence and search support for
 * CodeDetail entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see .CodeDetail
 * @author MyEclipse Persistence Tools
 */

public class CodeDetailDAO extends BaseDAO<CodeDetail> {
	private final static Logger log = Logger.getLogger(CodeDetailDAO.class);
	
	// property constants
	public static final String CODE_1 = "code_1";
	public static final String DESCRIPTION = "description";

	/**
	 * Delete a persistent CodeDetail entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity CodeDetail entity to delete
	 * @throws Exception when the operation fails
	 */
	public void delete(CodeDetail entity) throws Exception {
		log.info("deleting CodeDetail instance");
		try {
			entity = getEntityManager().getReference(CodeDetail.class, entity.getId());
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

	public CodeDetail findById(Long id) {
		log.info("finding CodeDetail instance with id: " + id);
		try {
			CodeDetail instance = getEntityManager().find(CodeDetail.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all CodeDetail entities with a specific property value.
	 * 
	 * @param propertyName the name of the CodeDetail property to query
	 * @param value the property value to match
	 * @return List<CodeDetail> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<CodeDetail> findByProperty(String propertyName,
			final Object value) {
		log.info("finding CodeDetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from CodeDetail model where model."
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
	 * Find all CodeDetail entities.
	 * @return List<CodeDetail> all CodeDetail entities
	 */
	@SuppressWarnings("unchecked")
	public List<CodeDetail> findAll() {
		log.info("finding all CodeDetail instances");
		try {
			final String queryString = "select model from CodeDetail model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
}