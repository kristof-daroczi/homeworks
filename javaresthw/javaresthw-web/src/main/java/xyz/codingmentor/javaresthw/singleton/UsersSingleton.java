package xyz.codingmentor.javaresthw.singleton;

import xyz.codingmentor.javaresthw.dto.UserEntity;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Krisz
 */
public enum UsersSingleton implements Serializable {

    INSTANCE;

    private final Map<String, UserEntity> users = new HashMap<>();

    public Collection<UserEntity> getUsers() {
        return users.values();
    }

    public UserEntity findUserbyID(String id) {
        return users.get(id);
    }

    public UserEntity addUUIDandAddtoMap(UserEntity user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setId(randomUUID);
        users.put(user.getId(), user);
        return user;
    }

    public UserEntity deleteUser(String id) {
        return users.remove(id);
    }

    public UserEntity addUser(UserEntity user) {
        return users.put(user.getId(), user);
    }

    public UserEntity updateUser(UserEntity user) {
        return addUser(user);
    }

}
