package xyz.codingmentor.firsteehomework.dbs;

import xyz.codingmentor.firsteehomework.dbs.DeviceDB;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import xyz.codingmentor.firsteehomework.entities.DeviceEntity;
import xyz.codingmentor.firsteehomework.entities.ManufacturerEnum;
import xyz.codingmentor.firsteehomework.entities.MyColorEnum;

/**
 *
 * @author Krisz
 */
public class DeviceDBTest {

    public DeviceDBTest() {
    }

    DeviceDB deviceDB;
    DeviceEntity device1;

    @Before
    public void init() {
        deviceDB = new DeviceDB();
        device1 = new DeviceEntity();
        device1.setManufacturer(ManufacturerEnum.HTC);
        device1.setColor(MyColorEnum.BLUE);
        device1.setPrice(50000);
        device1.setType("Desire One");
    }

    @Test
    public void addDeviceTest() {
        deviceDB.addDevice(device1);
        assertEquals(device1, deviceDB.getDevice(device1.getId()));
    }

    @Test
    public void getDeviceTest() {
        deviceDB.addDevice(device1);
        DeviceEntity returned = deviceDB.getDevice(device1.getId());
        assertEquals(device1, returned);
    }

    @Test
    public void modifyDeviceTest() {
        deviceDB.addDevice(device1);
        device1.setType("Ascend");
        DeviceEntity modifiedDevice = deviceDB.editDevice(device1);
        assertEquals(modifiedDevice.getType(), "Ascend");
    }

    @Test
    public void deleteDeviceTest() {
        deviceDB.addDevice(device1);
        DeviceEntity deletedDevice = deviceDB.deleteDevice(device1);
        assertEquals(deletedDevice, device1);
    }

    @Test
    public void getAllDevicesTest() {
        DeviceEntity device2 = new DeviceEntity();
        device2.setManufacturer(ManufacturerEnum.SAMSUNG);
        device2.setColor(MyColorEnum.BLUE);
        device2.setPrice(150000);
        device2.setType("Galaxy");

        deviceDB.addDevice(device1);
        deviceDB.addDevice(device2);
        List<DeviceEntity> allDevices=deviceDB.getAllDevice();
        assertEquals(allDevices.size(),deviceDB.getDevicesMap().size());
    }
}
