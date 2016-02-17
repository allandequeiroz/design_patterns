package java4.fun.dataLayer.hibernate.common.dao.find;

import java.io.Serializable;
import java.util.List;
import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.hibernate.HibernateSessionFactory;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * This class perform the basic find persistence operations
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 * */
public class DAOFindHelperImp implements IDAOFindHelper{
	
	/*
	 * The logger
	 * */
	private static final Logger LOGGER = Logger.getLogger(DAOFindHelperImp.class);
	
	/**
	 * Return an detached instance from id
	 * 
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param id The id of persisted object
	 * @return Return the object based in class name and id
	 * */
	@SuppressWarnings("unchecked")
	public <T> T findById(String fullQualifiedName, Serializable id) throws DataLayerFault {
		Session session = HibernateSessionFactory.getInstance().openSession();

		try{
			T instance = (T) session.get(fullQualifiedName, id);
			return instance;
		}catch (Throwable t) {
			throw new DataLayerFault("Could not execute operation. Message: " + t.getMessage(), t);
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
	 * Generate a list based in class type
	 * 
	 * @param fullQualifiedName The complete class name "package.className"
	 * @return List with the objects type specified in the argument
	 * */
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(String fullQualifiedName) throws DataLayerFault {
		return getDescendentList(fullQualifiedName, null);
	}

	/**
	 * Return an Object populated with the registry values
	 * 
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param propertyName the field name to search
	 * @param propertyValue the field value to search
	 * @return Return the object based in class type and id
	 * */
	@SuppressWarnings("unchecked")
	public <T> List<T> getListByProperty(String fullQualifiedName, String propertyName, String propertyValue) throws DataLayerFault {
		return getSizedAndDescListByProperty(fullQualifiedName, propertyName, propertyValue, 0, 0, null);
	}

	/**
	 * Generate a list between a specific range ordered by ascendent mode
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param columnNames The column name(s) to order list
	 * @return List with the objects type specified in the first argument
	 * */
	public <T> List<T> getAscendentList(String fullQualifiedName, String... columnNames) throws DataLayerFault {
		return getSizedAndAscListByProperty(fullQualifiedName, null, null, 0, 0, columnNames);
	}
	
	/**
	 * Generate a list between a specific range ordered by ascendent mode
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param propertyName Name of column to apply between search
	 * @param propertyValue Value of the property
	 * @param startPoint The position whre start the generated list
	 * @param listSize The lenght of the generated list
	 * @param columnNames The column name(s) to order list
	 * @return List with the objects type specified in the first argument
	 * */
	public <T> List<T> getSizedAndAscListByProperty(String fullQualifiedName, String propertyName, 
			Object propertyValue, int startPoint, int listSize, String... columnNames) throws DataLayerFault {
		Order[] orders = new Order[columnNames.length];
		for(int i = 0 ; i < columnNames.length ; i++){
			orders[i] = Order.asc(columnNames[i]);
		}
		return getList(fullQualifiedName, propertyName, propertyValue, startPoint, listSize, orders);
	}
	
	/**
	 * Generate a list between a specific range ordered by descendent mode
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param columnNames The column name(s) to order list
	 * @return List with the objects type specified in the first argument
	 * */
	public <T> List<T> getDescendentList(String fullQualifiedName, String... columnNames) throws DataLayerFault {
		return getSizedAndDescListByProperty(fullQualifiedName, null, null, 0, 0, columnNames);
	}

	/**
	 * Generate a list between a specific range ordered by descendent mode
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param propertyName Name of column to apply between search
	 * @param propertyValue Value of the property
	 * @param startPoint The position whre start the generated list
	 * @param listSize The lenght of the generated list
	 * @param columnNames The column name(s) to order list
	 * @return List with the objects type specified in the first argument
	 * */
	public <T> List<T> getSizedAndDescListByProperty(String fullQualifiedName, String propertyName, 
			Object propertyValue, int startPoint, int listSize, String... columnNames) throws DataLayerFault {
		Order[] orders = null;
		if(columnNames != null){
			orders = new Order[columnNames.length];
			for(int i = 0 ; i < columnNames.length ; i++){
				orders[i] = Order.desc(columnNames[i]);
			}
		}
		return getList(fullQualifiedName, propertyName, propertyValue, startPoint, listSize, orders);
	}

	/*
	 * Generate a list between a specific range 
	 * @param fullQualifiedName The complete class name "package.className"
	 * @param propertyName Name of column to apply between search
	 * @param propertyValue Value of the property
	 * @param startPoint The position whre start the generated list
	 * @param listSize The lenght of the generated list
	 * @param orders The list of column(s) name(s) to order list
	 * @return List with the objects type specified in the first argument
	 * */
	@SuppressWarnings("unchecked")
	private <T> List<T> getList(String fullQualifiedName, String propertyName, 
			Object propertyValue, int startPoint, int listSize,	Order... orders) throws DataLayerFault {

		Session session = HibernateSessionFactory.getInstance().openSession();
		
		try{
			Criteria crit = session.createCriteria(fullQualifiedName);

			if(propertyName != null){
				crit.add(Restrictions.eq(propertyName, propertyValue));
			}

			if(listSize > startPoint){
				crit.setFirstResult(startPoint);
				crit.setMaxResults(listSize);
			}

			if((orders != null) && (orders.length > 0)){
				for(Order o : orders){
					crit.addOrder(o);
				}
			}

			return crit.list();
		}catch (Throwable t) {
			throw new DataLayerFault("Could not execute operation. Message: " + t.getMessage(), t);
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
