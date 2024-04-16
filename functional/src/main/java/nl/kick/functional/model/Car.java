package nl.kick.functional.model;

import java.util.List;
import java.util.UUID;

public class Car {

    private final UUID id;
    private final Brand brand;
    private final int cilinders;
    private final boolean electric;
    private final String licence_plate;
    private final List<String> owners;

    public Car(UUID id, Brand brand, int cilinders, boolean electric, String licence_plate, List<String> owners) {
        this.id = id;
        this.brand = brand;
        this.cilinders = cilinders;
        this.electric = electric;
        this.licence_plate = licence_plate;
        this.owners = owners;
    }

    public UUID getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getCilinders() {
        return cilinders;
    }

    public boolean isElectric() {
        return electric;
    }

    public String getLicence_plate() {
        return licence_plate;
    }

    public List<String> getOwners() {
        return owners;
    }
}
