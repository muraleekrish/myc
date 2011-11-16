package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.dto.PackageDTO;
import com.mycove.vo.Package;

/**
 * A data access object (DAO) providing persistence and search support for
 * Package entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.mycove.vo.Package
 * @author MyEclipse Persistence Tools
 */

public class PackageDAO extends BaseDAO<Package> {
	

	private final static Logger log = Logger.getLogger(PackageDAO.class);
	
	
	// property constants
	public static final String NOTES = "notes";
	public static final String CARRIER = "carrier";
	public static final String PACKAGE_DESCRIPTION = "packageDescription";
	public static final String SUBJECT = "subject";
	public static final String PACKAGE_LOCATION = "packageLocation";
	public static final String RESIDENT_NAME = "residentName";
	public static final String MESSAGE = "message";
	public static final String PIECES = "pieces";
	public static final String PACKAGE_YEAR = "packageYear";
	public static final String PACKAGE_MONTH = "packageMonth";
	public static final String PACKAGE_DAY = "packageDay";
	public static final String PICKUP_FLAG = "pickupFlag";
	public static final String PICKUP_YEAR = "pickupYear";
	public static final String PICKUP_MONTH = "pickupMonth";
	public static final String PICKUP_DAY = "pickupDay";
	public static final String PICKUP_BY = "pickupBy";
	public static final String SIGN = "sign";

	/**
	 * Delete a persistent Package entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Package entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Package entity) throws Exception {
		log.info("deleting Package instance");
		try {
			entity = getEntityManager().getReference(Package.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}

	

	public Package findById(Long id) {
		log.info("finding Package instance with id: " + id);
		try {
			Package instance = getEntityManager().find(Package.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * Find all Package entities with a specific property value.
	 * 
	 * @param propertyName the name of the Package property to query
	 * @param value the property value to match
	 * @return List<Package> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Package> findByProperty(String propertyName, final Object value) {
		log.info("finding Package instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Package model where model."
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
	 * Find all Package entities.
	 * 
	 * @return List<Package> all Package entities
	 */
	@SuppressWarnings("unchecked")
	public List<Package> findAll() {
		log.info("finding all Package instances");
		try {
			final String queryString = "select model from Package model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
	
	/**
	 * Find all Package entities.
	 * @param pickupStatus 
	 * 
	 * @return List<Package> all Package entities
	 */
	@SuppressWarnings("unchecked")
	public List<PackageDTO> getPackagesByPropertyManagerId(Long propertyManagerId, boolean pickupStatus) {
		log.info("finding all Package instances");
		try {
			String queryString = "select package.id As id,package.pickup_day AS pickupDay,package.pickup_month AS pickupMonth,package.pickup_year AS pickupYear, package.package_month AS packageMonth, package.package_day AS packageDay, " +
					"package.package_year AS packageYear,package.pickup_by AS pickupBy,package.carrier AS carrier, package.pieces AS pieces, " +
					"package.package_location packageLocation, apartment.apartment_number AS apartmentNumber, " +
					"tenantUser.first_name AS firstName, tenantUser.last_name AS lastName from package  " +
					"JOIN user_property AS usrProperty on usrProperty.property_id = package.property_id " +
					"JOIN mycove_user AS u ON u.id = usrProperty.user_id JOIN apartment_master AS apartment " +
					"on apartment.id = package.apartment_id LEFT JOIN tenant ON tenant.apartment_id = apartment.id " +
					" LEFT JOIN mycove_user AS tenantUser ON tenantUser.id = tenant.id where u.id= :userId ";
			if(pickupStatus)
				queryString += " and pickup_flag = true";
			else
				queryString += " and (pickup_flag = false or pickup_flag is null)";
			
			Query query = getEntityManager().createNativeQuery(queryString, PackageDTO.class);
			query.setParameter("userId", propertyManagerId);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

}