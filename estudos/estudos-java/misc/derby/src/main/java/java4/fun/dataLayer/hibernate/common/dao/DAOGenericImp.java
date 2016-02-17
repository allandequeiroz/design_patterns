package java4.fun.dataLayer.hibernate.common.dao;

import java.io.Serializable;
import java.util.List;
import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.hibernate.common.dao.delete.DAODeleteHelperImp;
import java4.fun.dataLayer.hibernate.common.dao.delete.IDAODeleteHelper;
import java4.fun.dataLayer.hibernate.common.dao.find.DAOFindHelperImp;
import java4.fun.dataLayer.hibernate.common.dao.find.IDAOFindHelper;
import java4.fun.dataLayer.hibernate.common.dao.persist.DAOPersistAttachMergeHelperImp;
import java4.fun.dataLayer.hibernate.common.dao.persist.IDAOPersistAttachMergeHelper;

public class DAOGenericImp<T> implements IDAOGeneric{
	
	private IDAODeleteHelper deleter = new DAODeleteHelperImp();
	
	private IDAOPersistAttachMergeHelper persister = new DAOPersistAttachMergeHelperImp();
	
	private IDAOFindHelper finder = new DAOFindHelperImp();

	public <T> void delete(T persistentInstance) throws DataLayerFault {
		deleter.delete(persistentInstance);
	}

	public <T> void deleteByField(String fullQualifiedName,
			String propertyName, Object value) throws DataLayerFault {
		deleter.deleteByField(fullQualifiedName, propertyName, value);
	}

	public <T> void deleteById(String fullQualifiedName, Serializable id)
			throws DataLayerFault {
		deleter.deleteById(fullQualifiedName, id);
	}

	public <T> T findById(String fullQualifiedName, Serializable id)
			throws DataLayerFault {
		return finder.findById(fullQualifiedName, id);
	}

	public <T> List<T> getAscendentList(String fullQualifiedName,
			String... columnNames) throws DataLayerFault {
		return finder.getAscendentList(fullQualifiedName, columnNames);
	}

	public <T> List<T> getDescendentList(String fullQualifiedName,
			String... columnNames) throws DataLayerFault {
		return finder.getDescendentList(fullQualifiedName, columnNames);
	}

	public <T> List<T> getList(String fullQualifiedName) throws DataLayerFault {
		return finder.getList(fullQualifiedName);
	}

	public <T> List<T> getListByProperty(String fullQualifiedName,
			String propertyName, String propertyValue) throws DataLayerFault {
		return finder.getListByProperty(fullQualifiedName, propertyName, propertyValue);
	}

	public <T> List<T> getSizedAndAscListByProperty(String fullQualifiedName,
			String propertyName, Object propertyValue, int startPoint,
			int listSize, String... columnNames) throws DataLayerFault {
		return finder.getSizedAndAscListByProperty(fullQualifiedName, propertyName, propertyValue, startPoint, listSize, columnNames);
	}

	public <T> List<T> getSizedAndDescListByProperty(String fullQualifiedName,
			String propertyName, Object propertyValue, int startPoint,
			int listSize, String... columnNames) throws DataLayerFault {
		return finder.getSizedAndDescListByProperty(fullQualifiedName, propertyName, propertyValue, startPoint, listSize, columnNames);
	}

	public <T> void attachDirty(T transientInstance) throws DataLayerFault {
		persister.attachDirty(transientInstance);
	}

	public <T> T merge(T detachedInstance) throws DataLayerFault {
		return persister.merge(detachedInstance);
	}

	public <T> void persist(T transientInstance) throws DataLayerFault {
		persister.persist(transientInstance);
	}
}
