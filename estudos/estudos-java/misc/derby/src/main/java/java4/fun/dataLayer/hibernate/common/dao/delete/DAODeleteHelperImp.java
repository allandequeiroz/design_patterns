package java4.fun.dataLayer.hibernate.common.dao.delete;

import java.io.Serializable;
import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.hibernate.HibernateSessionFactory;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class perform the basic persistence operations
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 * */
public class DAODeleteHelperImp implements IDAODeleteHelper{
	
	/*
	 * The logger
	 * */
	private static final Logger LOGGER = Logger.getLogger(DAODeleteHelperImp.class);

	/**
	 * Remove registry from dadabase based in example instance
	 * 
	 * @param the object to remove
	 * */
	public <T> void delete(T persistentInstance) throws DataLayerFault {
		Session session = HibernateSessionFactory.getInstance().openSession();

		try{
			Transaction transaction = session.beginTransaction();
			try{
				session.delete(persistentInstance);
				transaction.commit();
			}catch (Throwable t) {
				LOGGER.error("An error ocurring during delete operation : " + t.getMessage(), t);
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
			throw new DataLayerFault("Could not execute operation. Message: " + 
				t.getMessage(), t);
		}finally{
			try{
				session.close();
			}catch (HibernateException e) {
				LOGGER.error("The connection with database can´t be closed : " + e.getMessage(), e);
				throw e;
			}
		}
	}
	
	/**
	 * Remove an persisted based in registry id
	 * 
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param id The id of persisted object
	 * */
	public <T> void deleteById(String fullQualifiedName, Serializable id) throws
		DataLayerFault {
		Session session = HibernateSessionFactory.getInstance().openSession();

		try{
			Transaction transaction = session.beginTransaction();
			try{
				
				StringBuilder hql = new StringBuilder();
				hql.append("delete from ");
				hql.append(fullQualifiedName);
				hql.append(" where ");
				hql.append(HibernateSessionFactory.getInstance().
					getClassMetadata(fullQualifiedName).
					getIdentifierPropertyName());
				hql.append(" = '");
				hql.append(id);
				hql.append("'");
				
				Query query = session.createQuery(hql.toString());
				query.executeUpdate();
				transaction.commit();
			}catch (Throwable t) {
				LOGGER.error("An error ocurring during delete operation : " + t.getMessage(), t);
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
			throw new DataLayerFault("Could not execute operation. Message: " + 
				t.getMessage(), t);
		}finally{
			try{
				session.close();
			}catch (HibernateException e) {
				LOGGER.error("The connection with database can´t be closed : " + e.getMessage(), e);
				throw e;
			}
		}
	}
	
	/**
	 * Remove an persisted based in field value
	 * 
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param propertyName name of the property "in the class" not in the table
	 * @param value value of the property
	 * */
	public <T> void deleteByField(String fullQualifiedName, String propertyName, 
		Object propertyValue) throws DataLayerFault {
		Session session = HibernateSessionFactory.getInstance().openSession();

		try{
			Transaction transaction = session.beginTransaction();
			try{
				
				StringBuilder hql = new StringBuilder();
				hql.append("delete from ");
				hql.append(fullQualifiedName);
				hql.append(" where ");
				hql.append(propertyName);
				hql.append(" = '");
				hql.append(propertyValue);
				hql.append("'");
				
				
				Query query = session.createQuery(hql.toString());
				query.executeUpdate();
				transaction.commit();
			}catch (Throwable t) {
				LOGGER.error("An error ocurring during delete operation : " + t.getMessage(), t);
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
			throw new DataLayerFault("Could not execute operation. Message: " + 
				t.getMessage(), t);
		}finally{
			try{
				session.close();
			}catch (HibernateException e) {
				LOGGER.error("The connection with database can´t be closed : " + e.getMessage(), e);
				throw e;
			}
		}
	}

}
