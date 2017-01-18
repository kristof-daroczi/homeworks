package xyz.codingmentor.firsteehomework;

import xyz.codingmentor.firsteehomework.exceptions.ValidationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.firsteehomework.dbs.DeviceDB;
import xyz.codingmentor.firsteehomework.dbs.UserDB;
import xyz.codingmentor.firsteehomework.entities.DeviceEntity;
import xyz.codingmentor.firsteehomework.entities.ManufacturerEnum;
import xyz.codingmentor.firsteehomework.entities.MyColorEnum;
import xyz.codingmentor.firsteehomework.entities.ShoppingCart;
import xyz.codingmentor.firsteehomework.entities.UserEntity;

/**
 *
 * @author Krisz
 */
public class Main {

    private static Weld weld;
    private static WeldContainer container;
    private static DeviceDB deviceDB;
    private static UserDB userDB;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private Main() {
        //empty on purpose
    }

    public static void getDevicesFromJSON(String file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<DeviceEntity> myDevices = mapper.readValue(new File(file), new TypeReference<List<DeviceEntity>>() {
        });
        deviceDB = container.instance().select(DeviceDB.class).get();
        for (DeviceEntity act : myDevices) {
            deviceDB.addDevice(act);
        }
    }

    public static void getUsersFromJSON(String file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> myUsers = mapper.readValue(new File(file), new TypeReference<List<UserEntity>>() {
        });
        userDB = container.instance().select(UserDB.class).get();
        for (UserEntity act : myUsers) {
            userDB.addUser(act);
        }

    }

    public static void main(String[] args) {

        weld = new Weld();
        container = weld.initialize();

        try {
            getDevicesFromJSON("devices.json");
            getUsersFromJSON("users.json");
            LOGGER.log(Level.INFO, "Upload ok");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        badDeviceTest();
        goodDeviceTest();
        badUserTest();
        goodUserTest();
        shoppingCartTest();

        weld.shutdown();
    }

    private static void goodDeviceTest() {
        List<DeviceEntity> devices = deviceDB.getAllDevice();
        DeviceEntity device = new DeviceEntity();
        for (DeviceEntity act : devices) {
            if (act.getManufacturer() == ManufacturerEnum.SAMSUNG) {
                device = act;
                break;
            }
        }
        device.setColor(MyColorEnum.PURPLE);
        deviceDB.editDevice(device);
        LOGGER.log(Level.INFO, "Device has been edited!");
    }

    private static void badDeviceTest() {
        List<DeviceEntity> devices = deviceDB.getAllDevice();
        DeviceEntity device = new DeviceEntity();
        for (DeviceEntity act : devices) {
            if (act.getManufacturer() == ManufacturerEnum.SAMSUNG) {
                device = act;
                break;
            }
        }
        device.setColor(MyColorEnum.GREEN);
        try {
            deviceDB.editDevice(device);
        } catch (ValidationException vex) {
            LOGGER.log(Level.SEVERE, "Cannot edit the device this way!");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, vex); //Need this line because of sonar
        }
    }

    private static void goodUserTest() {
        UserEntity user = userDB.getUser("troller");
        user.setPhone("06301234567");
        userDB.modifyUser(user);
        LOGGER.log(Level.INFO, "User has been modified!");
    }

    private static void badUserTest() {
        UserEntity user = userDB.getUser("troller");
        user.setPhone("0630123456789140");
        try {
            userDB.modifyUser(user);
        } catch (ValidationException vex) {
            LOGGER.log(Level.INFO, "User can not be modified this way!");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, vex); //Need this line because of sonar
        }
    }

    private static void shoppingCartTest() {
        List<DeviceEntity> devices = deviceDB.getAllDevice();
        DeviceEntity device = new DeviceEntity();
        for (DeviceEntity act : devices) {
            if (act.getManufacturer() == ManufacturerEnum.APPLE) {
                device = act;
                break;
            }
        }
        ShoppingCart cart = new ShoppingCart(deviceDB);
        device.setCount(10);
        cart.addDeviceToCart(device.getId(), 5);
        cart.removeDeviceFromCart(device.getId(), 3);
        cart.buyCart();
        cart.addDeviceToCart(device.getId(), 5);
        cart.addDeviceToCart(device.getId(), 2);
        cart.removeAllCart();
        LOGGER.log(Level.INFO, "User can not be modified this way!");
    }
}
