package java4.fun.dataLayer;

import java4.fun.dataLayer.dao.user.IUserDao;
import java4.fun.dataLayer.dao.user.impl.UserDaoHibernateImpl;

/**
 * Provides the DAO interface implementation.
 * 
 * ---------------------------------------------
 * DAO must be used just by the Services layer.
 * Do not use DAO from GUI layer.
 * ---------------------------------------------
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 */
public class HibernateDAOFactory {

    /** Non-instantiable class. */
    private HibernateDAOFactory() {
	// empty
    }

    /**
     * Gets the DAO implementation.
     * @return The IUserDao interface implementation.
     */
    public static final IUserDao getUserDao() {
    	return new UserDaoHibernateImpl();
    }
    
   
}
