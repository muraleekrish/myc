package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.Role;

/**
 * A data access object (DAO) providing persistence and search support for Role
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.mycove.vo.Role
 */

public class RoleDAO extends BaseDAO<Role> {

	private final static Logger log = Logger.getLogger(RoleDAO.class);

	// property constants
	public static final String NAME = "name";

	/**
	 * Delete a persistent Role entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity
	 *            Role entity to delete
	 * @throws Exception 
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Role entity) throws Exception {
		log.info("deleting Role instance");
		try {
			entity = getEntityManager().getReference(Role.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	public Role findById(Long id) {
		log.info("finding Role instance with id: " + id);
		try {
			Role instance = getEntityManager().find(Role.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all Role entities with a specific property value.
	 * 
	 * @param propertyName the name of the Role property to query
	 * @param value the property value to match
	 * @return List<Role> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Role> findByProperty(String propertyName, final Object value) {
		log.info("finding Role instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from Role model where model."
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
	 * Find all Role entities.
	 * 
	 * @return List<Role> all Role entities
	 */
	@SuppressWarnings("unchecked")
	public List<Role> findAll() {
		log.info("finding all Role instances");
		try {
			final String queryString = "select model from Role model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
}