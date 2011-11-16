package com.mycove.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.util.dbutil.EntityManagerHelper;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Filter;
import com.mycove.vo.Tenant;
import com.mycove.vo.User;

public class UserDAO<T>  {

	private final static Logger log = Logger.getLogger(UserDAO.class);
	
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_PASSWORD = "userPassword";
	public static final String EMAIL = "email";
	public static final String GENDER = "gender";
	public static final String FIRST_NAME = "firstName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String LAST_NAME = "lastName";
	public static final String HOME_PHONE = "homePhone";
	public static final String WORK_PHONE = "workPhone";
	public static final String CELL_PHONE = "cellPhone";
	public static final String SEND_EMAIL_SMS = "sendEmailSms";
	public static final String CELLULAR_PROVIDER = "cellularProvider";
	public static final String ACTIVE_FLAG = "activeFlag";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ROLE_ID = "roleId";
	public static final String TEMPPWD_CHANGED = "temppwdChanged";

	/**
	 * 
	 * @return
	 */
	public EntityManager getEntityManager() {
		return new BaseDAO<UserDAO>().getEntityManager();
	}
	
	/**
	 * Delete a persistent User entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * @param entity User entity to delete
	 * @throws Exception 
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(User entity) throws Exception {
		log.info("deleting User instance");
		try {
			entity = getEntityManager().getReference(User.class, entity.getId());
			BaseDAO<User> baseDAO = new BaseDAO<User>();
			baseDAO.delete(entity);
			log.info("delete successful");
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			throw e;
		}
	}


	public User findById(Long id) {
		log.info("finding User instance with id: " + id);
		try {
			User instance = getEntityManager().find(User.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("find failed", e);
			throw e;
		}
		
		
	}

	/**
	 * Find all User entities with a specific property value.
	 * 
	 * @param propertyName the name of the User property to query
	 * @param value the property value to match
	 * @return List<User> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<User> findByProperty(String propertyName, final Object value) {
		log.info("finding User instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from User model where model."
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
	 * 
	 */
	@SuppressWarnings("unchecked")
	public User checkAuthentication(String userId, String userPassword) {
		String queryString = "select model from User model where model.userId = :userId and model.userPassword = :userPassword";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("userId", userId);
		query.setParameter("userPassword", userPassword);
		List<User> result = query.getResultList();
		if(result.size() > 0)
			return result.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findByProperties(List<Filter> filters) {
		
		try {
			StringBuffer queryString = new StringBuffer("select model from User model")  ;
			if(FormUtil.isNotNull(filters)&& filters.size() > 0)
			{
				queryString.append(" where ");
				for (Filter filter : filters) {
					if(!queryString.toString().endsWith("where "))
						queryString.append(" and ");
					queryString.append("model.")
						.append(filter.getFieldName())
						.append("= :")
						.append(filter.getFieldName());
				}
			}
			
			Query query = getEntityManager().createQuery(queryString.toString());
			for (Filter filter : filters) {
				query.setParameter(filter.getFieldName(), filter.getValue());
			}
			
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find by property name failed", e);
			throw e;
		}
	}
	/**
	 * Find all User entities.
	 * 
	 * @return List<User> all User entities
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		log.info("finding all User instances");
		try {
			final String queryString = "select model from User model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("find all failed", e);
			throw e;
		}
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	public T update(T entity) throws Exception {
		EntityManager em = null;
		try {
			log.info("updating instance");
			em = getEntityManager();
			em.getTransaction().begin();
			T result = em.merge(entity);
			em.getTransaction().commit();
			getEntityManager().clear();
			log.info("update successful");
			return result;
		} catch (Exception e) {
			if (FormUtil.isNotNull(em))
			{
				em.getTransaction().rollback();
				EntityManagerHelper.closeEntityManager();
			}
			throw e;
		}
	}
}