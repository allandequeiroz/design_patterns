package java4.fun.dataLayer;


import java.util.List;
import java4.fun.dataLayer.dao.user.IUserDao;
import java4.fun.dataLayer.exceptions.DataLayerFault;
import java4.fun.dataLayer.model.User;

import junit.framework.TestCase;

import org.junit.Test;

public class UserDaoHibernateUnitTest extends TestCase{
	
	@Test
	public void testSaveUser(){
		
		IUserDao dao = HibernateDAOFactory.getUserDao();
		User user = new User("admin", "admin");
		
		try {
			dao.save(user);
		} catch (DataLayerFault e) {
			fail();
			e.printStackTrace();
		}
		
		try {
			List<User> users = dao.listUsers();
			if(users.size() > 0){
				for(User u : users)
					System.out.println(u.getLogin() + " " + u.getPassword());
			}
			
			assertTrue(true);
		} catch (DataLayerFault e) {
			fail();
			e.printStackTrace();
		}
	}
}
