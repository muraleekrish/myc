package com.mycove.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mycove.util.dbutil.EntityManagerHelper;
import com.mycove.util.util.FormUtil;

public class BaseDAO<T> {
	
	private final static Logger log = Logger.getLogger(BaseDAO.class);
	
	/**
	 * 
	 * @return
	 */
	public EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	
	/**
	 * 
	 * @param entity
	 * @throws Exception 
	 */
	public void save(T entity) throws Exception {
		log.info("saving instance");
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			log.info("saved successfully");
		} catch (Exception e) {
			log.error("save failed", e);
			if (FormUtil.isNotNull(em))
			{
				em.getTransaction().rollback();
				EntityManagerHelper.closeEntityManager();
			}
			throw e;
		}
	}
	
	/**
	 * 
	 * @param entity
	 * @throws Exception 
	 */
	public void delete(T entity) throws Exception {
		log.info("deleting instance");
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			getEntityManager().clear();
			log.info("deleted successfully");
		} catch (Exception e) {
			log.error("deletion failed", e);
			if (FormUtil.isNotNull(em))
			{
				em.getTransaction().rollback();
				EntityManagerHelper.closeEntityManager();
			}
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
	
	/**
	 * 
	 * @param queryString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> executeQuery(final String queryString) {
		log.info("executing Query: "+ queryString);
		try {
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException e) {
			log.error("executing Query:  failed", e);
			throw e;
		}
	}
	
	/**
	 * 
	 */
	public void checkDatabaseConnection() {
		Query query = getEntityManager().createNativeQuery("select 1", Integer.class);
		query.getSingleResult();
	}
}
