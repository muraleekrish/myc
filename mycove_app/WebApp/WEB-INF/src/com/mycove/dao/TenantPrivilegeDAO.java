package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.TenantPrivilege;

/**
 * A data access object (DAO) providing persistence and search support for
 * TenantPrivilege entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.mycove.vo.TenantPrivilege
 */

public class TenantPrivilegeDAO extends BaseDAO<TenantPrivilege> {

	private final static Logger log = Logger.getLogger(TenantPrivilegeDAO.class);

	/**
	 * Delete a persistent TenantPrivilege entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity TenantPrivilege entity to delete
	 * @throws Exception when the operation fails
	 */
	public void delete(TenantPrivilege entity) throws Exception {
		log.info("deleting TenantPrivilege instance");
		try {
			entity = getEntityManager().getReference(TenantPrivilege.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	public TenantPrivilege findById(Long id) {
		log.info("finding TenantPrivilege instance with id: " + id);
		try {
			TenantPrivilege instance = getEntityManager().find(
					TenantPrivilege.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed",  e);
			throw e;
		}
	}

	/**
	 * Find all TenantPrivilege entities with a specific property value.
	 * 
	 * @param propertyName the name of the TenantPrivilege property to query
	 * @param value the property value to match
	 * @return List<TenantPrivilege> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<TenantPrivilege> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding TenantPrivilege instance with property: "
						+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from TenantPrivilege model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed",e);
			throw e;
		}
	}

	/**
	 * Find all TenantPrivilege entities.
	 * 
	 * @return List<TenantPrivilege> all TenantPrivilege entities
	 */
	@SuppressWarnings("unchecked")
	public List<TenantPrivilege> findAll() {
		log.info("finding all TenantPrivilege instances");
		try {
			final String queryString = "select model from TenantPrivilege model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}