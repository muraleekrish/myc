package com.mycove.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.dto.PropertyDTO;
import com.mycove.vo.Property;

/**
 * A data access object (DAO) providing persistence and search support for
 * Property entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.mycove.vo.Property
 * @author MyEclipse Persistence Tools
 */

public class PropertyDAO extends BaseDAO<Property> {

	private final static Logger log = Logger.getLogger(PropertyDAO.class);
	
	// property constants
	public static final String STATUS_ID = "statusId";
	public static final String PROPERTY_NAME = "propertyName";
	public static final String MAILING_ADDRESS_LINE1 = "mailingAddressLine1";
	public static final String MAILING_ADDRESS_LINE2 = "mailingAddressLine2";
	public static final String MAILING_ADDRESS_CITY = "mailingAddressCity";
	public static final String MAILING_ADDRESS_STATE = "mailingAddressState";
	public static final String MAILING_ADDRESS_ZIPCODE = "mailingAddressZipcode";
	public static final String BILLING_ADDRESS_LINE1 = "billingAddressLine1";
	public static final String BILLING_ADDRESS_LINE2 = "billingAddressLine2";
	public static final String BILLING_ADDRESS_CITY = "billingAddressCity";
	public static final String BILLING_ADDRESS_STATE = "billingAddressState";
	public static final String BILLING_ADDRESS_ZIPCODE = "billingAddressZipcode";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String PROPERTY_ADMIN_USERNAME = "propertyAdminUsername";
	public static final String ACTIVE_FLAG = "activeFlag";
	public static final String PRIMARY_CONTACT_FIRST_NAME = "primaryContactFirstName";
	public static final String PRIMARY_CONTACT_LAST_NAME = "primaryContactLastName";
	public static final String PRIMARY_CONTACT_EMAIL_ADDRESS = "primaryContactEmailAddress";
	public static final String PRIMARY_CONTACT_PHONE_NUMBER = "primaryContactPhoneNumber";
	public static final String PRIMARY_CONTACT_MIDDLE_NAME = "primaryContactMiddleName";
	public static final String PRIMARY_CONTACT_SECONDARY_PHONE = "primaryContactSecondaryPhone";

	/**
	 * Delete a persistent Property entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity Property entity to delete
	 * @throws Exception when the operation fails
	 */
	public void delete(Property entity) throws Exception {
		log.info("deleting Property instance");
		try {
			entity = getEntityManager().getReference(Property.class, entity.getId());
			super.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed",  e);
			throw e;
		}
	}

	/**
	 * Find all Property entities with a specific property value.
	 * 
	 * @param propertyName the name of the Property property to query
	 * @param value the property value to match
	 * @return List<Property> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Property> findByProperty(String propertyName,
			final Object value) {
		log.info(
				"finding Property instance with property: "
						+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Property model where model."
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
	 * Find all Property entities.
	 * @return List<Property> all Property entities
	 */
	@SuppressWarnings("unchecked")
	public List<Property> findAll() {
		log.info("finding all Property instances" );
		try {
			final String queryString = "select model from Property model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
	
	/**
	 * Find all Property entities.
	 * @return List<Property> all Property entities
	 */
	@SuppressWarnings("unchecked")
	public List<PropertyDTO> getAllProperties() {
		log.info("finding all Property instances" );
		try {
			final String queryString = "SELECT id, property_name,  primary_contact_first_name, primary_contact_last_name FROM public.property_master;";
			Query query = getEntityManager().createNativeQuery(queryString, PropertyDTO.class);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Property findById(Long id) {
		log.info("finding Property instance with id: " + id);
		try {
			Property instance = getEntityManager().getReference(Property.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
	}

	/**
	 * @param parseLong
	 * @return
	 */
	public Collection<PropertyDTO> getPropertiesByUserId(Long userId) {
		log.info("finding Properties By UserId "+userId );
		Collection<PropertyDTO> resultList = null;
		try {
			final String queryString = "SELECT p.id, property_name,  primary_contact_first_name, primary_contact_last_name FROM property_master p join User_Property up on up.Property_id = p.id where up.user_id = :userId";
			Query query = getEntityManager().createNativeQuery(queryString, PropertyDTO.class);
			query.setParameter("userId", userId);
			resultList = query.getResultList();
			
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
		return resultList;
	}
}
