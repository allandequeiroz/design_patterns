package java4.fun.dataLayer.hibernate;

import java4.fun.dataLayer.config.DefaultAnnotationConfiguration;
import java4.fun.dataLayer.derby.DerbyServerManager;
import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.hibernate.common.DatalayerConstants;
import java4.fun.dataLayer.model.Initialized;
import java4.fun.dataLayer.model.User;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 * Factory class that manages the sessions to Hibernate.
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 */
public class HibernateSessionFactory {

	/*
	 * The logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(HibernateSessionFactory.class);
	/*
	 * The Session Factory.
	 */
	private static SessionFactory sessionFactory = null;
	/*
	 * The server manager
	 */
	private static DerbyServerManager serverManager = new DerbyServerManager();
	/*
	 * The configuration
	 */
	private static AnnotationConfiguration annotationConfiguration;
	
	/** 
	 * Non-instantiable class. 
	 * */
	private HibernateSessionFactory() {
		// empty
	}

	/**
	 * Create a session factory for the hibernate.
	 * 
	 * @return A <code>SessionFactory</code> object for hibernate
	 * @see HibernateSessionFactory
	 */
	private static synchronized SessionFactory createSessionFactory() throws DataLayerFault {
		LOGGER.debug("Creating Hibernate Session Factory...");
		SessionFactory result = null;
		int numTries = 0;
		
		try {
			serverManager.testForConnection();
		} catch (Exception e) {
			LOGGER.info("Database isn´t started.");
			try{
				serverManager.start();
			}catch (DataLayerFault d) {
				return null;
			}
		}
		
		while (numTries++ < DatalayerConstants.MAX_NUMBER_TRIES) {
			
			if(annotationConfiguration == null){
				try{
					annotationConfiguration = new DefaultAnnotationConfiguration();
					annotationConfiguration.addAnnotatedClass(Initialized.class);
					annotationConfiguration.addAnnotatedClass(User.class);
				}catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
					throw new DataLayerFault(e.getMessage(), e);
				}
			}
			
			try {
				
				LOGGER.debug("Building session factory...");
				result = annotationConfiguration.buildSessionFactory();
				
				LOGGER.debug("Session factory created successfully.");
				numTries = DatalayerConstants.MAX_NUMBER_TRIES;
				
			} catch (Throwable ex) {
				if (numTries == DatalayerConstants.MAX_NUMBER_TRIES) {
					LOGGER.error("Initial Hibernate SessionFactory creation failed." + ex.getMessage());
					if (ex.getCause() != null) {
						LOGGER.error("More details: " + ex.getCause().getClass());
						LOGGER.error("More details: " + ex.getCause().getMessage());
					}
					throw new DataLayerFault("Initial Hibernate SessionFactory creation failed.", ex);
				} else {
					LOGGER.debug("Error while trying to create the SessionFactory.", ex);
					LOGGER.debug("Trying again...(" + (numTries + 1) + "/" + DatalayerConstants.MAX_NUMBER_TRIES + ").");
				}
			}
		}
		return result;
	}

	/**
	 * Give a session factory to the hibernate
	 * 
	 * @return A <code>SessionFactory</code> object for hibernate
	 * @throws DataLayerFault 
	 * @see HibernateSessionFactory
	 */
	public static SessionFactory getInstance() throws DataLayerFault {
		if (sessionFactory == null) {
			sessionFactory = createSessionFactory();
		}
		return sessionFactory;
	}

	public static void shutdownSessionFactory(){
		if(sessionFactory!=null){
			synchronized(sessionFactory){
				sessionFactory.close();
				sessionFactory=null;
			}
		}
	}

	public static void setAnnotationConfiguration(
			AnnotationConfiguration annotationConfiguration) {
		HibernateSessionFactory.annotationConfiguration = annotationConfiguration;
	}
	
}
