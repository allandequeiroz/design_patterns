package java4.fun.dataLayer.dao.user.impl;

import java.util.List;
import java4.fun.dataLayer.dao.user.IUserDao;
import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.hibernate.common.dao.DAOGenericImp;
import java4.fun.dataLayer.hibernate.common.dao.IDAOGeneric;
import java4.fun.dataLayer.model.User;

public class UserDaoHibernateImpl implements IUserDao {
	
	IDAOGeneric dao = new DAOGenericImp();

	public List<User> listUsers()  throws DataLayerFault{
		return dao.getList(User.class.getName());
	}

	public void merge(User user)  throws DataLayerFault{
		dao.merge(user);
	}

	public void remove(User user)  throws DataLayerFault{
		dao.delete(user);
	}

	public void save(User user)  throws DataLayerFault{
		dao.persist(user);
	}

	public User searchById(Integer id)  throws DataLayerFault{
		return dao.findById(User.class.getName(), id);
	}
	
	
}
