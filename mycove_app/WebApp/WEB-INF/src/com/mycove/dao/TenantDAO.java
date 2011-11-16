package com.mycove.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.dto.ResidentDTO;
import com.mycove.util.dbutil.EntityManagerHelper;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Tenant;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tenant entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.mycove.vo.Tenant
 * @author MyEclipse Persistence Tools
 */

public class TenantDAO extends UserDAO<Tenant> {

	private final static Logger log = Logger.getLogger(TenantDAO.class);
	
	// property constants
	public static final String TAGNUMBER = "tagnumber";
	public static final String PARKING = "parking";
	public static final String LEASE_START_YEAR = "leaseStartYear";
	public static final String LEASE_START_MONTH = "leaseStartMonth";
	public static final String LEASE_START_DAY = "leaseStartDay";
	public static final String LEASE_END_YEAR = "leaseEndYear";
	public static final String LEASE_END_MONTH = "leaseEndMonth";
	public static final String LEASE_END_DAY = "leaseEndDay";
	public static final String APARTMENT_ID = "apartment.id";

	/**
	 * Delete a persistent Tenant entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Tenant entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Tenant entity) {
		log.info("deleting Tenant instance");
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			entity = em.getReference(Tenant.class, entity.getId());
			em.remove(entity);
			em.getTransaction().commit();
			log.info("delete successful");
		} catch (RuntimeException e) {
			if (FormUtil.isNotNull(em)) {
				em.getTransaction().rollback();
				EntityManagerHelper.closeEntityManager();
			}
			log.error("delete failed", e);
			throw e;
		}
	}

	public Tenant findById(Long id) {
		log.info("finding Tenant instance with id: " + id);
		try {
			Tenant instance = getEntityManager().find(Tenant.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed",  e);
			throw e;
		}
	}
	
	public List<Tenant> findByPropertyName(String propertyName, Object value) {
		log.info("finding User instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Tenant model where model."
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
	 * Find all Tenant entities with a specific property value.
	 * 
	 * @param propertyName the name of the Tenant property to query
	 * @param value the property value to match
	 * @return List<Tenant> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Tenant> findTenantByProperty(String propertyName, final Object value) {
		log.info("finding Tenant instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Tenant model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed", e);
			throw e;
		}
	}


	public Tenant findByUserId(String userId) {
		List<Tenant> tenantList = findTenantByProperty(USER_ID, userId);
		if(tenantList.size() > 0)
			return (Tenant) tenantList.get(0);
		else
			return null;
	}
	
	/**
	 * Find all Tenant entities.
	 * 
	 * @return List<Tenant> all Tenant entities
	 */
	@SuppressWarnings("unchecked")
	public List<Tenant> findAllTenants() {
		log.info("finding all Tenant instances");
		try {
			final String queryString = "select model from Tenant model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed",  e);
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	public List<ResidentDTO> getResidentByUserName(Long userId)
	{
		StringBuffer queryString = new StringBuffer();
		queryString.append("");

		Query query = getEntityManager().createNativeQuery(queryString.toString(), ResidentDTO.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
	
	/**
	 * 
	 */
	public List<ResidentDTO> getAllTenantsByPropertyManager(Long propertyManagerId) {
		log.info("finding all Tenant instances");
		try {
			final String queryString = "select tenant.id AS id, tenantUser.first_name AS firstName, " +
					"tenantUser.last_name AS lastName,  " +
					"tenantUser.email AS email, Building.Building_name AS buildingName, " +
					"apartment.apartment_number as apartmentNumber FROM mycove_user u  " +
					"JOIN user_property usrProperty on u.id = usrProperty.user_id " +
					"JOIN Building_master building on building.property_id = usrProperty.Property_id " +
					"JOIN Apartment_master apartment on apartment.Building_id = Building.id " +
					"JOIN tenant on tenant.apartment_id = apartment.id JOIN mycove_user tenantUser " +
					"on tenantUser.id = tenant.id where u.id = :userId";
			Query query = getEntityManager().createNativeQuery(queryString, ResidentDTO.class);
			query.setParameter("userId", propertyManagerId);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed",  e);
			throw e;
		}

	}
	public List<ResidentDTO> getAllTenantsIDByPropertyManager(Long propertyManagerId) {
		log.info("finding all Tenant instances");
		try {
			final String queryString = "select tenant.id AS id FROM mycove_user u  " +
					"JOIN user_property usrProperty on u.id = usrProperty.user_id " +
					"JOIN Building_master building on building.property_id = usrProperty.Property_id " +
					"JOIN Apartment_master apartment on apartment.Building_id = Building.id " +
					"JOIN tenant on tenant.apartment_id = apartment.id JOIN mycove_user tenantUser " +
					"on tenantUser.id = tenant.id where u.id = :userId";
			Query query = getEntityManager().createNativeQuery(queryString, ResidentDTO.class);
			query.setParameter("userId", propertyManagerId);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed",  e);
			throw e;
		}

	}

	public Tenant update(Tenant tenant) throws Exception {
		return super.update(tenant);
	}
}
