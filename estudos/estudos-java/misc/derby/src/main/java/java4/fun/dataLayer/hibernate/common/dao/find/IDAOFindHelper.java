/**
 * 
 */
package java4.fun.dataLayer.hibernate.common.dao.find;

import java.io.Serializable;
import java.util.List;
import java4.fun.dataLayer.exceptions.DataLayerFault;


/**
 * Provides all basics database access methods.
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 *
 */
public interface IDAOFindHelper{

	public <T> T findById(String fullQualifiedName, Serializable id) throws DataLayerFault;
	public <T> List<T> getList(String fullQualifiedName) throws DataLayerFault;
	public <T> List<T> getListByProperty(String fullQualifiedName, String propertyName, String propertyValue) throws DataLayerFault;
	public <T> List<T> getAscendentList(String fullQualifiedName, String... columnNames) throws DataLayerFault;
	public <T> List<T> getSizedAndAscListByProperty(String fullQualifiedName, String propertyName, 
			Object propertyValue, int startPoint, int listSize, String... columnNames) throws DataLayerFault;
	public <T> List<T> getDescendentList(String fullQualifiedName, String... columnNames) throws DataLayerFault;
	public <T> List<T> getSizedAndDescListByProperty(String fullQualifiedName, String propertyName, 
			Object propertyValue, int startPoint, int listSize, String... columnNames) throws DataLayerFault;


}
