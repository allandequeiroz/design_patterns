/**
 * 
 */
package java4.fun.dataLayer.hibernate.common.dao.delete;

import java.io.Serializable;
import java4.fun.dataLayer.exceptions.DataLayerFault;


/**
 * Provides all basics database access methods.
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 *
 */
public interface IDAODeleteHelper{
	
	public <T> void delete(T persistentInstance) throws DataLayerFault;
	
	public <T> void deleteById(String fullQualifiedName, Serializable id) throws DataLayerFault;
	
	public <T> void deleteByField(String fullQualifiedName, String propertyName, Object value) throws DataLayerFault;

}
