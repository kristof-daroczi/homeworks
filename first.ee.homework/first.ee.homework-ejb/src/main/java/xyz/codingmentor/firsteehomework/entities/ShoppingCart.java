package xyz.codingmentor.firsteehomework.entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.firsteehomework.dbs.DeviceDB;
import xyz.codingmentor.firsteehomework.exceptions.NotEnoughQuantityException;
import xyz.codingmentor.firsteehomework.exceptions.TooMuchQuantityException;

/**
 *
 * @author Krisz
 */
public class ShoppingCart {

    private static final Logger LOGGER = Logger.getLogger(ShoppingCart.class.getName());

    private int cost;
    private final Map<String, Integer> devicesInCart;
    private final DeviceDB deviceDB;

    public ShoppingCart() {
        devicesInCart = new HashMap();
        deviceDB = new DeviceDB();
        cost = 0;
    }

    public ShoppingCart(DeviceDB deviceDB) {
        devicesInCart = new HashMap();
        this.deviceDB = deviceDB;
        cost = 0;
    }

    public void addDeviceToCart(String id, int amount) {
        DeviceEntity device = deviceDB.getDevice(id);
        if (device.getCount() >= amount) {
            int beforeCountDB = device.getCount();
            if (!devicesInCart.containsKey(id)) {
                devicesInCart.put(id, amount);
                device.setCount(beforeCountDB - amount);
                cost = device.getPrice() * amount;
            } else {
                int beforeCount = devicesInCart.get(id);
                devicesInCart.replace(id, beforeCount + amount);
                device.setCount(beforeCountDB - amount);
                cost += device.getPrice() * amount;
            }
        } else {
            throw new NotEnoughQuantityException();
        }

    }

    public void removeDeviceFromCart(String id, int amount) {
        DeviceEntity device = deviceDB.getDevice(id);
        int removeCost = device.getPrice() * amount;
        int beforeCount = devicesInCart.get(id);
        int beforeCountDB = device.getCount();
        if (beforeCount == amount) {
            devicesInCart.remove(id);
            device.setCount(beforeCountDB + amount);
            cost -= removeCost;
        } else if (beforeCount > amount) {
            devicesInCart.replace(id, beforeCount - amount);
            device.setCount(beforeCountDB + amount);
            cost -= removeCost;
        } else {
            throw new TooMuchQuantityException();
        }
    }

    public void removeAllCart() {
        for (Iterator<Map.Entry<String, Integer>> it = devicesInCart.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            removeDeviceFromCart(entry.getKey(), entry.getValue());
        }
    }

    public int getCost() {
        return cost;
    }

    public void buyCart() {
        for (Map.Entry<String, Integer> entry : devicesInCart.entrySet()) {
            LOGGER.log(Level.INFO, "Device id :{0} Count: {1}", new Object[]{entry.getKey(), entry.getValue()});
        }
        LOGGER.log(Level.INFO, "Final cost: " + cost);
    }

}
