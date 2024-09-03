/**
 * Represents a Pickup, which is a type of car extending the Car class.
 */
public class Pickup extends Vehicle {
    /**
     * Constructs a new SUV object with the specified properties.
     *
     * @param id The unique ID of the Pickup.
     * @param type The type of car which corresponds to this subclass "Pickup".
     * @param model The model of the Pickup.
     * @param condition The condition of the Pickup (e.g., new, used).
     * @param color The color of the Pickup.
     * @param capacity The seating capacity of the Pickup.
     * @param year The year of the Pickup.
     * @param fuelType The fuel type of the Pickup.
     * @param transmission The transmission type of the Pickup.
     * @param VIN The Vehicle Identification Number (VIN) of the Pickup.
     * @param price The price of the Pickup.
     * @param availability The availability status of the Pickup.
     * @param hasTurbo If the Pickup has a turbo mode.
     */
    public Pickup(int id, String type, String model, String condition, String color, int capacity, int year, String fuelType,String transmission,String VIN, double price, int availability, String hasTurbo) {
    	super(id,type,model,condition,color,capacity,year,fuelType,transmission,VIN,price,availability,hasTurbo);
    }
    /**
     * Makes a sound specific to Pickup engines.
     */
    public void makeSound() {
        System.out.println("Pickup engine sound");
    }
}