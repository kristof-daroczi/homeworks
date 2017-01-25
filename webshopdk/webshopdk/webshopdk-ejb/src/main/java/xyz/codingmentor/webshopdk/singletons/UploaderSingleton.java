package xyz.codingmentor.webshopdk.singletons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.webshopdk.dbs.DeviceDB;
import xyz.codingmentor.webshopdk.dbs.UserDB;
import xyz.codingmentor.webshopdk.entities.DeviceEntity;
import xyz.codingmentor.webshopdk.entities.UserEntity;

/**
 *
 * @author Krisz
 */
@Singleton
@Startup
public class UploaderSingleton {

    private static final Logger LOGGER = Logger.getLogger(UploaderSingleton.class.getName());
    @Inject
    private DeviceDB deviceDB;
    @Inject
    private UserDB userDB;

    @PostConstruct
    private void fillUpDBs() {
        ClassLoader classLoader = getClass().getClassLoader();
        ObjectMapper mapper = new ObjectMapper();
        File userFile = new File(classLoader.getResource("users.json").getFile());
        File deviceFile = new File(classLoader.getResource("devices.json").getFile());
        try {
            List<DeviceEntity> myDevices = mapper.readValue(deviceFile, TypeFactory.defaultInstance().constructCollectionType(List.class, DeviceEntity.class));
            List<UserEntity> myUsers = mapper.readValue(userFile, TypeFactory.defaultInstance().constructCollectionType(List.class, UserEntity.class));
            for (DeviceEntity device : myDevices) {
                deviceDB.addDevice(device);
            }
            LOGGER.log(Level.INFO, "Devices are uploaded.");

            for (UserEntity user : myUsers) {
                userDB.addUser(user);
            }
            LOGGER.log(Level.INFO, "Users are uploaded.");

        } catch (IOException ex) {
            Logger.getLogger(UploaderSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
