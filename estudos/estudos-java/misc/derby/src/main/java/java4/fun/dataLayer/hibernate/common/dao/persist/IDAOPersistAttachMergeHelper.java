/**
 * 
 */
package java4.fun.dataLayer.hibernate.common.dao.persist;

import java4.fun.dataLayer.exceptions.DataLayerFault;


/**
 * Provides all basics operations to persist, attach and merge data
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 *
 */
public interface IDAOPersistAttachMergeHelper{
			
	public <T> void persist(T transientInstance) throws DataLayerFault;
	
	public <T> void attachDirty(T transientInstance) throws DataLayerFault;
	
	public <T> T merge(T detachedInstance) throws DataLayerFault;

}
