package xyz.codingmentor.firsteehomework.entities;

import java.util.Objects;
import xyz.codingmentor.firsteehomework.constraints.ManufacturerExaminer;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Krisz
 */
@ManufacturerExaminer
public class DeviceEntity {

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
        hash = 97 * hash + Objects.hashCode(this.manufacturer);
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + this.price;
        hash = 97 * hash + Objects.hashCode(this.color);
        hash = 97 * hash + Objects.hashCode(this.count);
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
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.manufacturer != other.manufacturer) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.count, other.count)) {
            return false;
        }
        return true;
    }

}
