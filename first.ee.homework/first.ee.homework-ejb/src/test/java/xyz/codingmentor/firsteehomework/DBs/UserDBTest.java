package xyz.codingmentor.firsteehomework.DBs;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import xyz.codingmentor.firsteehomework.entities.SexEnum;
import xyz.codingmentor.firsteehomework.entities.UserEntity;

/**
 *
 * @author Krisz
 */
public class UserDBTest {

    public UserDBTest() {
    }

    UserDB userDB;
    UserEntity user1;

    @Before
    public void setUp() {
        userDB = new UserDB();
        GregorianCalendar date = new GregorianCalendar(1979, 6, 5);
        Date birthdate = date.getTime();
        Date testdate = new Date();

        user1 = new UserEntity.Builder()
                .firstname("John")
                .lastname("Doe")
                .SexEnum(SexEnum.MALE)
                .address("01234example")
                .password("Password3")
                .email("kiskutya@gmail.com")
                .username("paksi")
                .phone("+36305556677")
                .dateOfBirth(birthdate)
                .build();

    }

    @Test
    public void addUserTest() {
        userDB.addUser(user1);
        assertEquals(user1, userDB.getUser("paksi"));
    }

    @Test
    public void getUserTest() {
        userDB.addUser(user1);
        UserEntity returnedUser = userDB.getUser(user1.getUsername());
        assertEquals(returnedUser.getUsername(), "paksi");
    }

    @Test
    public void authenticationTest() {
        userDB.addUser(user1);
        boolean isAuthenticated = userDB.authenticate("paksi", "Password3");
        assertEquals(isAuthenticated, true);
    }

    @Test
    public void modifyUserTest() {
        userDB.addUser(user1);
        user1.setEmail("urlele@gmail.com");
        UserEntity modifiedUser = userDB.modifyUser(user1);
        assertEquals(modifiedUser.getEmail(), "urlele@gmail.com");
    }

    @Test
    public void deleteUserTest() {
        userDB.addUser(user1);
        UserEntity deletedUser = userDB.deleteUser(user1);
        assertEquals(deletedUser, user1);
    }

    @Test
    public void getAllUsersTest() {
        GregorianCalendar date = new GregorianCalendar(1982, 7, 5);
        Date birthdate = date.getTime();
        UserEntity user2 = new UserEntity.Builder()
                .firstname("Virág")
                .lastname("Kiss")
                .SexEnum(SexEnum.FEMALE)
                .address("01234example")
                .password("Password3")
                .email("kiskutya34@gmail.com")
                .username("ossian")
                .phone("+36308886677")
                .registrationDate(new Date())
                .lastModifiedDate(new Date())
                .dateOfBirth(birthdate)
                .build();

        userDB.addUser(user1);
        userDB.addUser(user2);
        List<UserEntity> userList = userDB.getAllUsers();
        int expectedsize = userDB.getUsersMap().size();
        assertEquals(expectedsize, userList.size());
    }

}
