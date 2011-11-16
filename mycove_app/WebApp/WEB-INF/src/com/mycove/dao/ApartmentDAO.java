package com.mycove.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.vo.Apartment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Apartment entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 */

@SuppressWarnings("unchecked")
public class ApartmentDAO extends BaseDAO<Apartment> {
	
	private final static Logger log = Logger.getLogger(ApartmentDAO.class);
	
	// property constants
	public static final String APARTMENT_TYPE = "apartmentType";
	public static final String APARTMENT_NUMBER = "apartmentNumber";

	/**
	 * 
	 * @param entity
	 * @throws Exception 
	 */
	public void delete(Apartment entity) throws Exception {
		log.info("deleting Apartment instance");
		entity = getEntityManager().getReference(Apartment.class, entity.getId());
		super.delete(entity);
		log.info("delete successful");
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Apartment findById(Long id) {
		log.info("finding Apartment instance with id: " + id);
		try {
			Apartment instance = getEntityManager().find(Apartment.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<Apartment> findByProperty(String propertyName,
			final Object value) {
		log.info("finding Apartment instance with property: " + propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Apartment model where model."	+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed",e);
			throw e;
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<Apartment> findAll() {
		log.info("finding all Apartment instances");
		try {
			final String queryString = "select model from Apartment model";
			return this.executeQuery(queryString);
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
	
	public List<Apartment> getAllApartmentByPropertyManagerId(Long propertyManagerId) {
		log.info("finding all Apartment instances");
		try {
			final String queryString = "select apartment.* FROM Apartment_master apartment JOIN Building_master as Building on Building.id = apartment.Building_id JOIN user_property AS userProperty ON userProperty.property_id = building.property_id where user_id = :userId";
			Query query = getEntityManager().createNativeQuery(queryString, Apartment.class);
			query.setParameter("userId", propertyManagerId);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
}
