package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.RolePrivilege;

/**
 * A data access object (DAO) providing persistence and search support for
 * RolePrivilege entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.mycove.vo.RolePrivilege
 * @author MyEclipse Persistence Tools
 */

public class RolePrivilegeDAO extends BaseDAO<RolePrivilege> {

	private final static Logger log = Logger.getLogger(RolePrivilegeDAO.class);
	
	// property constants

	/**
	 * Delete a persistent RolePrivilege entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity RolePrivilege entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(RolePrivilege entity) {
		log.info("deleting RolePrivilege instance");
		try {
			entity = getEntityManager().getReference(RolePrivilege.class,
					entity.getId());
			getEntityManager().remove(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	public RolePrivilege findById(Long id) {
		log.info("finding RolePrivilege instance with id: " + id);
		try {
			RolePrivilege instance = getEntityManager().find(
					RolePrivilege.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all RolePrivilege entities with a specific property value.
	 * 
	 * @param propertyName the name of the RolePrivilege property to query
	 * @param value the property value to match
	 * @return List<RolePrivilege> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<RolePrivilege> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding RolePrivilege instance with property: " + propertyName
						+ ", value: " + value);
		try {
			final String queryString = "select model from RolePrivilege model where model."
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
	 * Find all RolePrivilege entities.
	 * 
	 * @return List<RolePrivilege> all RolePrivilege entities
	 */
	@SuppressWarnings("unchecked")
	public List<RolePrivilege> findAll() {
		log.info("finding all RolePrivilege instances");
		try {
			final String queryString = "select model from RolePrivilege model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed",   e);
			throw e;
		}
	}

}