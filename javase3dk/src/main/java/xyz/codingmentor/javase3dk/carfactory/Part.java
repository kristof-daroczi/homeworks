package xyz.codingmentor.javase3dk.carfactory;

/**
 *
 * @author Krisz
 */
 public abstract class Part {

    protected String brand;

    public Part(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Part{" + "brand=" + brand + '}';
    }
    
}
