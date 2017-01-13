package xyz.codingmentor.firsteehomework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.firsteehomework.dbs.DeviceDB;
import xyz.codingmentor.firsteehomework.dbs.UserDB;
import xyz.codingmentor.firsteehomework.entities.DeviceEntity;
import xyz.codingmentor.firsteehomework.entities.UserEntity;

/**
 *
 * @author Krisz
 */
public class Main {

    private Main() {
        //empty on purpose
    }

    public static void getDevicesFromJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<DeviceEntity> myDevices = mapper.readValue(new File("devices.json"), new TypeReference<List<DeviceEntity>>() {
        });
        DeviceDB deviceDB = new DeviceDB();
        for (DeviceEntity act : myDevices) {
            deviceDB.addDevice(act);
        }
    }

    public static void getUsersFromJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> myUsers = mapper.readValue(new File("users.json"), new TypeReference<List<UserEntity>>() {
        });
        UserDB userDB = new UserDB();
        for (UserEntity act : myUsers) {
            userDB.addUser(act);
        }

    }

    public static void main(String[] args) {

        try {
            getDevicesFromJSON();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
