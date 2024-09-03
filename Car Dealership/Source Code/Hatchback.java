/**
 * Represents a Hatchback, which is a type of car extending the Car class.
 */
public class Hatchback extends Vehicle {
    /**
     * Constructs a new Hatchback object with the specified properties.
     *
     * @param id The unique ID of the Hatchback.
     * @param type The type of car which corresponds to this subclass "Hatchback".
     * @param model The model of the Hatchback.
     * @param condition The condition of the Hatchback (e.g., new, used).
     * @param color The color of the Hatchback.
     * @param capacity The seating capacity of the Hatchback.
     * @param year The year of the Hatchback.
     * @param fuelType The fuel type of the Hatchback.
     * @param transmission The transmission type of the Hatchback.
     * @param VIN The Vehicle Identification Number (VIN) of the Hatchback.
     * @param price The price of the Hatchback.
     * @param availability The availability status of the Hatchback.
     * @param hasTurbo If the Hatchback has a turbo mode.
     */
    public Hatchback(int id, String type, String model, String condition, String color, int capacity, int year, String fuelType,String transmission,String VIN, double price, int availability, String hasTurbo) {
    	super(id,type,model,condition,color,capacity,year,fuelType,transmission,VIN,price,availability,hasTurbo);
    }

    /**
     * Makes a sound specific to Pickup engines.
     */
    public void makeSound() {
        System.out.println("Hatchback engine sound");
    }
}