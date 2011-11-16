package com.mycove.dao;

// default package

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.dto.BuildingDTO;
import com.mycove.vo.Building;

/**
 * A data access object (DAO) providing persistence and search support for
 * Building entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see .Building
 */

public class BuildingDAO extends BaseDAO<Building> {
	
	private final static Logger log = Logger.getLogger(BuildingDAO.class);
	
	// property constants
	public static final String BUILDING_NAME = "buildingName";
	

	/**
	 * Delete a persistent Building entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Building entity to delete
	 * @throws Exception 
	 */
	public void delete(Building entity) throws Exception {
		log.info("deleting Building instance");
		try {
			entity = getEntityManager().getReference(Building.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	public Building findById(Long id) {
		log.info("finding Building instance with id: " + id);
		try {
			Building instance = getEntityManager().find(Building.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all Building entities with a specific property value.
	 * 
	 * @param propertyName the name of the Building property to query
	 * @param value the property value to match
	 * @return List<Building> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Building> findByProperty(String propertyName, final Object value) {
		log.info("finding Building instance with property: " + propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Building model where model."
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
	 * Find all Building entities.
	 * @return List<Building> all Building entities
	 */
	@SuppressWarnings("unchecked")
	public List<Building> findAll() {
		log.info("finding all Building instances");
		try {
			final String queryString = "select model from Building model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<BuildingDTO> getBuildingByPropertyId(Long propertyId) {
		log.info("finding all Building instances");
		try {
			getEntityManager().clear();
			final String queryString = "select b.id AS id, b.building_Name AS name, count(a.id) AS apartmentCount from apartment_master a join building_master b on b.id = a.building_id where property_id= :propertyId group by b.id, b.building_Name order by building_Name";
			Query query = getEntityManager().createNativeQuery(queryString, BuildingDTO.class);
			query.setParameter("propertyId", propertyId);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
}
