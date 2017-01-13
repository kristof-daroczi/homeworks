package xyz.codingmentor.firsteehomework.dbs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import xyz.codingmentor.firsteehomework.entities.DeviceEntity;

/**
 *
 * @author Krisz
 */
public class DeviceDB {

    private final Map<String, DeviceEntity> devices = new HashMap<>();

    public Map<String, DeviceEntity> getDevicesMap() {
        return devices;
    }

    public DeviceEntity addDevice(DeviceEntity newDevice) {
        String randomUUID = UUID.randomUUID().toString();
        newDevice.setCount(0);
        newDevice.setId(randomUUID);
        devices.put(newDevice.getId(), newDevice);
        return devices.get(newDevice.getId());
    }

    public DeviceEntity getDevice(String id) {
        return devices.get(id);
    }

    public DeviceEntity editDevice(DeviceEntity device) {
        devices.put(device.getId(), device);
        return devices.get(device.getId());
    }

    public DeviceEntity deleteDevice(DeviceEntity device) {
        return devices.remove(device.getId());
    }

    public List<DeviceEntity> getAllDevice() {
        List<DeviceEntity> allDevices = new LinkedList<>();
        allDevices.addAll(devices.values());
        return allDevices;
    }

}
