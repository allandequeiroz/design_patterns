package java4.fun.dataLayer.hibernate.common.dao;

import java4.fun.dataLayer.hibernate.common.dao.delete.IDAODeleteHelper;
import java4.fun.dataLayer.hibernate.common.dao.find.IDAOFindHelper;
import java4.fun.dataLayer.hibernate.common.dao.persist.IDAOPersistAttachMergeHelper;


public interface IDAOGeneric<T> extends IDAODeleteHelper, IDAOFindHelper, IDAOPersistAttachMergeHelper{

}
