package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.Privilege;

/**
 * A data access object (DAO) providing persistence and search support for
 * Privilege entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.mycove.vo.Privilege
 * @author MyEclipse Persistence Tools
 */

public class PrivilegeDAO extends BaseDAO<Privilege> {

	private final static Logger log = Logger.getLogger(PrivilegeDAO.class);
	
	// property constants
	public static final String NAME = "name";
	public static final String CODE = "code";

	/**
	 * Delete a persistent Privilege entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Privilege entity to delete
	 * @throws Exception when the operation fails
	 */
	public void delete(Privilege entity) throws Exception {
		log.info("deleting Privilege instance");
		try {
			entity = getEntityManager().getReference(Privilege.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed",  e);
			throw e;
		}
	}

	public Privilege findById(Long id) {
		log.info("finding Privilege instance with id: "
				+ id);
		try {
			Privilege instance = getEntityManager().find(Privilege.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all Privilege entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Privilege property to query
	 * @param value
	 *            the property value to match
	 * @return List<Privilege> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Privilege> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding Privilege instance with property: "
						+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Privilege model where model."
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
	 * Find all Privilege entities.
	 * 
	 * @return List<Privilege> all Privilege entities
	 */
	@SuppressWarnings("unchecked")
	public List<Privilege> findAll() {
		log.info("finding all Privilege instances");
		try {
			final String queryString = "select model from Privilege model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}