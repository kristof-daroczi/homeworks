package xyz.codingmentor.webshopdk.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.inject.Inject;
import xyz.codingmentor.webshopdk.dbs.DeviceDB;
import xyz.codingmentor.webshopdk.exceptions.NotEnoughQuantityException;
import xyz.codingmentor.webshopdk.exceptions.TooMuchQuantityException;

/**
 *
 * @author Krisz
 */
@Stateful
public class ShoppingCart implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(ShoppingCart.class.getName());

    private int cost;
    private final Map<String, Integer> devicesInCart;
    @Inject
    private DeviceDB deviceDB;

    public ShoppingCart() {
        devicesInCart = new HashMap();
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
