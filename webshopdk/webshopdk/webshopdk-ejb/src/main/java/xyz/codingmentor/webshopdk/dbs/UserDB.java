package xyz.codingmentor.webshopdk.dbs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import xyz.codingmentor.webshopdk.interceptors.BeanValidation;
import xyz.codingmentor.webshopdk.entities.UserEntity;

/**
 *
 * @author Krisz
 */
@Singleton
public class UserDB implements Serializable {

    private final transient Map<String, UserEntity> users= new HashMap<>();
 
    public UserEntity addUser(UserEntity newuser) {
        Date now = new Date();
        newuser.setRegistrationDate(now);
        newuser.setLastModifiedDate(now);
        users.put(newuser.getUsername(), newuser);
        return users.get(newuser.getUsername());
    }

    @BeanValidation
    public UserEntity getUser(String username) {
        return users.get(username);
    }

    @BeanValidation
    public boolean authenticate(String username, String password) {
        UserEntity user = users.get(username);
        return user != null && (user.getPassword().equals(password));
    }

    @BeanValidation
    public UserEntity modifyUser(UserEntity user) {
        user.setLastModifiedDate(new Date());
        users.put(user.getUsername(), user);
        return users.get(user.getUsername());
    }

    @BeanValidation
    public UserEntity deleteUser(UserEntity user) {
        return users.remove(user.getUsername());
    }

    @BeanValidation
    public List<UserEntity> getAllUsers() {
        List<UserEntity> allUsers = new ArrayList<>();
        allUsers.addAll(users.values());
        return allUsers;
    }
}
