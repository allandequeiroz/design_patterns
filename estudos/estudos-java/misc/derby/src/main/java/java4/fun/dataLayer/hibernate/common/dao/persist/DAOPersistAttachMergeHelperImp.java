package java4.fun.dataLayer.hibernate.common.dao.persist;

import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.hibernate.HibernateSessionFactory;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class perform the basic persistence operations
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 * */
public class DAOPersistAttachMergeHelperImp implements IDAOPersistAttachMergeHelper{
	
	/*
	 * The logger
	 * */
	private static final Logger LOGGER = Logger.getLogger(DAOPersistAttachMergeHelperImp.class);

	/**
	 * Persist transient object
	 * 
	 * @param transientInstance The object to persist
	 * */
	public <T> void persist(T transientInstance) throws DataLayerFault {
		Session session = HibernateSessionFactory.getInstance().openSession();

		try{
			Transaction transaction = session.beginTransaction();
			try{
				session.persist(transientInstance);
				transaction.commit();
			}catch (Throwable t) {
				LOGGER.error("An error ocurring during persist operation : " + t.getMessage(), t);
				LOGGER.error("Rolling back...");
				try{
					transaction.rollback();
					throw t;
				}catch (HibernateException e) {
					LOGGER.error("Can´t be possible rolling back : " + e.getMessage(), e);
					throw e;
				}
			}
		}catch (Throwable t) {
			throw new DataLayerFault("Could not execute operation. Message: " + t.getMessage(), t);
		}finally{
			try{
				session.close();
			}catch (HibernateException e) {
				LOGGER.error("The connection with database can´t be closed : " + e.getMessage(), e);
			}
		}
	}

	/**
	 * Persist a new object or update an existing
	 * 
	 * @param transientInstance The object to save or update
	 * */
	public <T> void attachDirty(T transientInstance) throws DataLayerFault {
		Session session = HibernateSessionFactory.getInstance().openSession();

		try{
			Transaction transaction = session.beginTransaction();
			try{
				session.saveOrUpdate(transientInstance);
				transaction.commit();
			}catch (Throwable t) {
				LOGGER.error("An error ocurring during persist operation : " + t.getMessage(), t);
				LOGGER.error("Rolling back...");
				try{
					transaction.rollback();
					throw t;
				}catch (HibernateException e) {
					LOGGER.error("Can´t be possible rolling back : " + e.getMessage(), e);
					throw e;
				}
			}
		}catch (Throwable t) {
			throw new DataLayerFault("Could not execute operation. Message: " + t.getMessage(), t);
		}finally{
			try{
				session.close();
			}catch (HibernateException e) {
				LOGGER.error("The connection with database can´t be closed : " + e.getMessage(), e);
			}
		}
	}

	/**
	 * Merge the value of transient intance and the registry persisted in db
	 * 
	 * @param transientInstance The object to merge
	 * */
	@SuppressWarnings("unchecked")
	public <T> T merge(T detachedInstance) throws DataLayerFault {
		Session session = HibernateSessionFactory.getInstance().openSession();
		T merged = null;
		
		try{
			Transaction transaction = session.beginTransaction();
			try{
				merged = (T) session.merge(detachedInstance);
				session.lock(detachedInstance, LockMode.NONE);
				transaction.commit();
				return merged;
			}catch (Throwable t) {
				LOGGER.error("An error ocurring during persist operation : " + t.getMessage(), t);
				LOGGER.error("Rolling back...");
				try{
					transaction.rollback();
					throw t;
				}catch (HibernateException e) {
					LOGGER.error("Can´t be possible rolling back : " + e.getMessage(), e);
					throw e;
				}
			}
		}catch (Throwable t) {
			throw new DataLayerFault("Could not execute operation. Message: " + t.getMessage(), t);
		}finally{
			try{
				session.close();
			}catch (HibernateException e) {
				LOGGER.error("The connection with database can´t be closed : " + e.getMessage(), e);
			}
		}
	}

}
