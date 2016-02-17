package com.mutt.dob.ejb.user;

import co.mutt.dob.model.User;
import co.mutt.dob.repository.UserRepository;
import co.mutt.dob.repository.user.UserServiceLocal;
import co.mutt.dob.repository.user.UserServiceRemote;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean implements UserServiceLocal, UserServiceRemote {

    protected Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.listUsers();
    }

    @Override
    public void saveUser(User user) throws Exception{
         userRepository.saveUser(user);
    }

    @Override
    public void removeUser(User user) throws Exception{
        userRepository.removeUser(user);
    }



}
