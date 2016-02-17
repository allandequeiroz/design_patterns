package java4.fun.dataLayer;


import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.hibernate.HibernateSessionFactory;
import java4.fun.dataLayer.model.Initialized;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.junit.Before;
import org.junit.Test;

public class HibernateSessionFactoryUnitTest extends TestCase{
	
	private Initialized initialized;
	
	private static final Logger LOGGER = Logger.getLogger(HibernateSessionFactoryUnitTest.class);

	@Before
	public void setUp() throws Exception {
		initialized = new Initialized();
	}

	@Test
	public void testGetSessionFactoryInstance(){
		Session session = null;
		Transaction transaction = null;
		
		try {
			SessionFactory factory = HibernateSessionFactory.getInstance();
			session = factory.openSession();
			initialized.setInitialized(true);
			transaction = session.beginTransaction();
			session.save(initialized);
			transaction.commit();
		} catch (DataLayerFault e) {
			LOGGER.warn("Test fail in save moment, detauls : " + e.getMessage(), e);
		}finally{
			try{
				session.close();
			}catch (HibernateException e) {
				LOGGER.error("Error when closing connection : " + e.getMessage(), e);
			}
		}
		
		try {
			session = HibernateSessionFactory.getInstance().openSession();
			Criteria criteria = session.createCriteria(Initialized.class);
			criteria.add(Expression.idEq(Integer.valueOf(1)));
			initialized = (Initialized) criteria.list().get(0);
			if((initialized != null)){
				LOGGER.debug("The INITIALIZED´s table value is : " + initialized.isInitialized());
				assertTrue(initialized.isInitialized());
			}
		} catch (DataLayerFault e) {
			LOGGER.warn("Test fail in save moment, detauls : " + e.getMessage(), e);
		}finally{
			try{
				session.close();
			}catch (HibernateException e) {
				LOGGER.error("Error when closing connection : " + e.getMessage(), e);
			}
		}
	}
}
