package java4.fun.dataLayer.dao.user;

import java.util.List;
import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.model.User;

public interface IUserDao {
	
	public void save(User user) throws DataLayerFault;
	public void remove(User user) throws DataLayerFault;
	public void merge(User user) throws DataLayerFault;
	public List<User> listUsers() throws DataLayerFault;
	public User searchById(Integer id) throws DataLayerFault;
}
