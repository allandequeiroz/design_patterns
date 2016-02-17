package co.mutt.dob.repository.user;

import co.mutt.dob.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();
    void saveUser(User user) throws Exception;
    void removeUser(User user) throws Exception;
}