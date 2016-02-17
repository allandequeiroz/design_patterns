package co.mutt.dob.repository.impl;

import br.com.obvio.dao.RelationalContent;
import co.mutt.dob.model.User;
import co.mutt.dob.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepositoryImpl implements UserRepository {

    protected Logger logger = Logger.getLogger(this.getClass().getName());

    private RelationalContent<User> relacional;
    private EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        relacional = new RelationalContent<>(em);
        this.em = em;
    }

    @Override
    public List<User> listUsers() {
        try {
            return relacional.list(User.class);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        return null;
    }

    @Override
    public void saveUser(User user) throws Exception {
        relacional.save(user);
    }

    @Override
    public void removeUser(User user) throws Exception {
        relacional.delete(User.class, user.getId());
    }

}
