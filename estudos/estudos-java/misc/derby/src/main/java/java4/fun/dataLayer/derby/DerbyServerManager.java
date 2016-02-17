package java4.fun.dataLayer.derby;


import java.io.PrintWriter;
import java.net.InetAddress;
import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.hibernate.HibernateSessionFactory;
import java4.fun.dataLayer.hibernate.common.DatalayerConstants;

import org.apache.derby.drda.NetworkServerControl;
import org.apache.log4j.Logger;

/**
 * Manage Derby network server.
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 */
public class DerbyServerManager {

	private static final Logger LOGGER = Logger.getLogger(HibernateSessionFactory.class);

	
	
	private static int maxNumberTries = 5;
	
	private NetworkServerControl serverControl;

	public DerbyServerManager(){
		try {
			serverControl = new NetworkServerControl(InetAddress.getByName(
					DatalayerConstants.DEFAULT_HOST_ADDRESS), DatalayerConstants.DEFAULT_NETWORKSERVER_PORT);
			LOGGER.info("Derby Network Server created");
		} catch (Exception e) {
			LOGGER.error("Error while trying to create the Derby Network Server.", e);
		}
	}

	/**
	 * Start Derby Network server
	 * 
	 */
	public void start() throws DataLayerFault {
		
		boolean serverIsUp = false; 

		while(!serverIsUp && (maxNumberTries >0)) {
			
			try {
				serverControl.start(new PrintWriter(System.out,true));
			} catch (Exception e) {
				LOGGER.error("Error while trying to start the Derby Network Server.", e);
			}finally{
				try {
					maxNumberTries--;
					testForConnection();
					serverIsUp = true;
				}
				catch(Exception e) {
					LOGGER.error("Unable to obtain a connection to network server, trying again after 3000 ms.");
					try {
						Thread.currentThread().sleep(DatalayerConstants.DEFAULT_TIME_TO_WAIT);
					} catch (InterruptedException ie) {
						LOGGER.info(ie.getMessage());
					}
				}
			}

		}

		if(!serverIsUp) {
			LOGGER.error("Exiting, since unable to connect to Derby Network Server.");
			LOGGER.error("Please try to increase the amount of time to keep trying to connect to the Server.");
			throw new DataLayerFault("Exiting, since unable to connect to Derby Network Server.");
		}

		LOGGER.info("Derby Network Server started.");
	}

	/**
	 * trace utility of server
	 */
	public void trace(boolean onoff) {
		try {
			serverControl.trace(onoff);
		} catch (Exception e) {
			LOGGER.error("Error while trying to trace.", e);
		}
	}


	/**
	 * Try to test for a connection
	 * Throws exception if unable to get a connection
	 */
	public void testForConnection()	throws Exception {
		serverControl.ping();
	}


	/**
	 * Shutdown the NetworkServer
	 */
	public void shutdown() {
		try {
			serverControl.shutdown();
		} catch (Exception e) {
			LOGGER.error("Error while trying to shutdown the Derby Network Server.", e);
		}
	}

}