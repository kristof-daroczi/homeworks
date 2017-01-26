package xyz.codingmentor.webshopdk.entities;

import java.io.Serializable;
import java.util.Objects;
import xyz.codingmentor.webshopdk.constraints.ManufacturerExaminer;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.webshopdk.annotations.BeanConnector;

/**
 *
 * @author Krisz
 */
@ManufacturerExaminer
@BeanConnector
public class DeviceEntity implements Serializable {

    @NotNull
    @Size(min = 36, max = 36)
    private String id;

    @NotNull
    private ManufacturerEnum manufacturer;

    @NotNull
    @Size(min = 3)
    private String type;

    @NotNull
    @Min(value = 1)
    private int price;

    @NotNull
    private MyColorEnum color;

    @NotNull
    @Min(value = 0)
    private Integer count;

    public DeviceEntity(String id, ManufacturerEnum manufacturer, String type, int price, MyColorEnum color, Integer count) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.color = color;
        this.count = count;
    }

    public DeviceEntity() {
        //empty on purpose
    }

    public MyColorEnum getColor() {
        return color;
    }

    public void setColor(MyColorEnum color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ManufacturerEnum getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerEnum manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeviceEntity other = (DeviceEntity) obj;   
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
