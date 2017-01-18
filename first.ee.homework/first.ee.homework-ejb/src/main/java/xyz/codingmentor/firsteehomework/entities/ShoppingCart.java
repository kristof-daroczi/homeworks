package xyz.codingmentor.firsteehomework.entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.firsteehomework.dbs.DeviceDB;
import xyz.codingmentor.firsteehomework.exceptions.NoSuchDeviceException;
import xyz.codingmentor.firsteehomework.exceptions.NotEnoughQuantityException;
import xyz.codingmentor.firsteehomework.exceptions.TooMuchQuantityException;

/**
 *
 * @author Krisz
 */
public class ShoppingCart {
    
    private static final Logger LOGGER = Logger.getLogger(ShoppingCart.class.getName());
    
    private int cost;
    private final Map<String, DeviceEntity> devicesInCart;
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
            int beforeCount = deviceDB.getDevice(id).getCount();
            device.setCount(amount);
            devicesInCart.put(id, device);
            deviceDB.getDevice(id).setCount(beforeCount - amount);
            cost = amount * device.getPrice();
            
        } else {
            throw new NotEnoughQuantityException();
        }
    }
    
    public void removeDeviceFromCart(String id, int amount) {
        if (devicesInCart.containsKey(id)) {
            DeviceEntity device = devicesInCart.get(id);
            int removeCost = amount * device.getPrice();
            int beforeCount = deviceDB.getDevice(id).getCount();
            if (device.getCount() == amount) {
                devicesInCart.remove(id);
                deviceDB.getDevice(id).setCount(beforeCount + amount);
                cost -= removeCost;
            } else if (device.getCount() > amount) {
                device.setCount(beforeCount - amount);
                devicesInCart.replace(id, device);               
                DeviceEntity device2 = new DeviceEntity();
                device2.setId(id);
                device2.setColor(device.getColor());
                device2.setManufacturer(device.getManufacturer());
                device2.setPrice(device.getPrice());
                device2.setType(device.getType());
                device2.setCount(beforeCount + amount);
                deviceDB.editDevice(device2);
                cost -= removeCost;
            } else {
                throw new TooMuchQuantityException();
            }
        } else {
            throw new NoSuchDeviceException();
        }
    }
    
    public void removeAllCart() {
        for (Iterator<Map.Entry<String, DeviceEntity>> it = devicesInCart.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, DeviceEntity> entry = it.next();
            removeDeviceFromCart(entry.getKey(), entry.getValue().getCount());
        }
    }
    
    public int getCost() {
        return cost;
    }
    
    public void buyCart() {
        for (Map.Entry<String, DeviceEntity> entry : devicesInCart.entrySet()) {
            LOGGER.log(Level.INFO, "Device id :{0} Count: {1} Cost: {2}", new Object[]{entry.getValue().getId(), entry.getValue().getCount(), entry.getValue().getCount() * entry.getValue().getPrice()});
        }
        LOGGER.log(Level.INFO, "Final cost: {0}", getCost());
    }
    
}
