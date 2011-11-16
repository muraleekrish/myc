package com.mycove.dao;

// default package

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.dto.MaintenanceRequestDTO;
import com.mycove.vo.MaintenanceRequest;

/**
 * A data access object (DAO) providing persistence and search support for
 * MaintenanceRequest entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see .MaintenanceRequest
 */

public class MaintenanceRequestDAO extends BaseDAO<MaintenanceRequest> {
	
	private final static Logger log = Logger.getLogger(MaintenanceRequestDAO.class);
	
	
	// property constants
	public static final String MAINTENANCE_YEAR = "maintenanceYear";
	public static final String MAINTENANCE_MONTH = "maintenanceMonth";
	public static final String MAINTENANCE_DAY = "maintenanceDay";
	public static final String PROBLEM = "problem";
	public static final String MAINTENANCE_LOCATION = "maintenanceLocation";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String CLOSE_FLAG = "closeFlag";
	public static final String MAINTENANCE_REQUEST = "maintenanceRequest";
	public static final String ENTRY_PERMISSION = "entryPermission";
	public static final String DAY_TIME_CONTACT_NO = "dayTimeContactNo";

	/**
	 * Delete a persistent MaintenanceRequest entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity MaintenanceRequest entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(MaintenanceRequest entity) {
		log.info("deleting MaintenanceRequest instance");
		try {
			entity = getEntityManager().getReference(MaintenanceRequest.class,
					entity.getId());
			getEntityManager().remove(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	/**
	 * Find all MaintenanceRequest entities with a specific property value.
	 * 
	 * @param propertyName the name of the MaintenanceRequest property to query
	 * @param value the property value to match
	 * @return List<MaintenanceRequest> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MaintenanceRequest> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding MaintenanceRequest instance with property: "
						+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from MaintenanceRequest model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed", e);
			throw e;
		}
	}

	public MaintenanceRequest findById(Long id) {
		log.info("finding Maintenance instance with id: " + id);
		try {
			MaintenanceRequest instance = getEntityManager().find(MaintenanceRequest.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}
	/**
	 * Find all MaintenanceRequest entities.
	 * 
	 * @return List<MaintenanceRequest> all MaintenanceRequest entities
	 */
	@SuppressWarnings("unchecked")
	public List<MaintenanceRequest> findAll() {
		log.info("finding all MaintenanceRequest instances");
		try {
			final String queryString = "select model from MaintenanceRequest model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
	
	public List<MaintenanceRequestDTO> getMaintenanceByPropertyManagerId(Long PropertyManagerId) {
		log.info("get Maintenance instances by PropertyManagerId ");
		try {
			final String queryString = "SELECT maintenance_request.id AS id, maintenance_year AS maintenanceYear, maintenance_month AS maintenanceMonth, " +
					"maintenance_day AS maintenanceDay, problem, maintenance_location AS location,maintenance_request AS request, " +
					"apartment_number AS apartmentNumber FROM maintenance_request JOIN user_property ON " +
					"user_property.property_id = maintenance_request.property_id " +
					"JOIN Apartment_master Apartment ON Apartment.id = maintenance_request.Apartment_id " +
					"WHERE (close_flag IS NULL OR close_flag = false) AND user_property.user_id = :userId ORDER BY maintenance_year desc, " +
					"maintenance_month desc, maintenance_day desc";
			Query query = getEntityManager().createNativeQuery(queryString, MaintenanceRequestDTO.class);
			query.setParameter("userId", PropertyManagerId);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}