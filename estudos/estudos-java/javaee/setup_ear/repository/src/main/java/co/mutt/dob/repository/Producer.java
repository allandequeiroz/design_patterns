package co.mutt.dob.repository;

import co.mutt.dob.repository.impl.UserRepositoryImpl;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Producer {

    @PersistenceContext(unitName = "main")
    private EntityManager main;

    @Produces
    public UserRepository userRepository() {
        return new UserRepositoryImpl(main);
    }

}
