package com.mycove.dao;

// default package

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.Code;

/**
 * A data access object (DAO) providing persistence and search support for Code
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see .Code
 */

public class CodeDAO extends BaseDAO<Code> {
	
	private final static Logger log = Logger.getLogger(BuildingDAO.class);
	
	// property constants
	public static final String CODE = "code";
	public static final String DESCRIPTION = "description";

	/**
	 * Delete a persistent Code entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Code entity to delete
	 * @throws Exception  when the operation fails
	 */
	public void delete(Code entity) throws Exception {
		log.info("deleting Code instance");
		try {
			entity = getEntityManager().getReference(Code.class, entity.getId());
			super.delete(entity);
			log.info("deleted successfully");
		} catch (RuntimeException e) {
			log.error("deletion failed", e);
			throw e;
		} catch (Exception e) {
			log.error("deletion failed", e);
			throw e;
		}
	}

	public Code findById(Long id) {
		log.info("finding Code instance with id: " + id);
		try {
			Code instance = getEntityManager().find(Code.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all Code entities with a specific property value.
	 * 
	 * @param propertyName the name of the Code property to query
	 * @param value the property value to match
	 * @return List<Code> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Code> findByProperty(String propertyName, final Object value) {
		log.info("finding Code instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Code model where model."
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
	 * Find all Code entities.
	 * @return List<Code> all Code entities
	 */
	@SuppressWarnings("unchecked")
	public List<Code> findAll() {
		log.info("finding all Code instances");
		try {
			final String queryString = "select model from Code model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}