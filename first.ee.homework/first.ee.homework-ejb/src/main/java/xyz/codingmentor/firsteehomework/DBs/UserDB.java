package xyz.codingmentor.firsteehomework.DBs;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import xyz.codingmentor.firsteehomework.entities.UserEntity;

/**
 *
 * @author Krisz
 */
public class UserDB {

    private final Map<String, UserEntity> users = new HashMap<>();

    public Map<String, UserEntity> getUsersMap() {
        return users;
    }

    public UserEntity addUser(UserEntity newuser) {
        Date now = new Date();
        newuser.setRegistrationDate(now);
        newuser.setLastModifiedDate(now);
        users.put(newuser.getUsername(), newuser);
        return users.get(newuser.getUsername());
    }

    public UserEntity getUser(String username) {
        return users.get(username);
    }

    public boolean authenticate(String username, String password) {
        UserEntity user = users.get(username);
        return user != null && (user.getPassword().equals(password));
    }

    public UserEntity modifyUser(UserEntity user) {
        user.setLastModifiedDate(new Date());
        users.put(user.getUsername(), user);
        return users.get(user.getUsername());
    }

    public UserEntity deleteUser(UserEntity user) {
        return users.remove(user.getUsername());
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> allUsers = new LinkedList<>();
        allUsers.addAll(users.values());
        return allUsers;
    }
}
