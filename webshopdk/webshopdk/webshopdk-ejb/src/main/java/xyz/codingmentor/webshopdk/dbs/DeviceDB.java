package xyz.codingmentor.webshopdk.dbs;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Singleton;
import xyz.codingmentor.webshopdk.interceptors.BeanValidation;
import xyz.codingmentor.webshopdk.entities.DeviceEntity;

/**
 *
 * @author Krisz
 */
@Singleton
public class DeviceDB implements Serializable {

    private final Map<String, DeviceEntity> devices = new HashMap<>();

    public DeviceEntity addDevice(DeviceEntity newDevice) {
        String randomUUID = UUID.randomUUID().toString();
        newDevice.setCount(10);
        newDevice.setId(randomUUID);
        devices.put(newDevice.getId(), newDevice);
        return devices.get(newDevice.getId());
    }
    @BeanValidation
    public DeviceEntity getDevice(String id) {
        return devices.get(id);
    }
    @BeanValidation
    public DeviceEntity editDevice(DeviceEntity device) {
        devices.put(device.getId(), device);
        return devices.get(device.getId());
    }
    @BeanValidation
    public DeviceEntity deleteDevice(DeviceEntity device) {
        return devices.remove(device.getId());
    }
    @BeanValidation
    public List<DeviceEntity> getAllDevice() {
        List<DeviceEntity> allDevices = new LinkedList<>();
        allDevices.addAll(devices.values());
        return allDevices;
    }

}
