/**
 * Represents a Sedan, which is a type of car extending the Car class.
 */
public class Sedan extends Vehicle{
    /**
     * Constructs a new Sedan object with the specified properties.
     *
     * @param id The unique ID of the Sedan.
     * @param type The type of car which corresponds to this subclass "Sedan".
     * @param model The model of the Sedan.
     * @param condition The condition of the Sedan (e.g., new, used).
     * @param color The color of the Sedan.
     * @param capacity The seating capacity of the Sedan.
     * @param year The year of the Sedan.
     * @param fuelType The fuel type of the Sedan.
     * @param transmission The transmission type of the Sedan.
     * @param VIN The Vehicle Identification Number (VIN) of the Sedan.
     * @param price The price of the Sedan.
     * @param availability The availability status of the Sedan.
     * @param hasTurbo If the Sedan has a turbo mode.
     */
    public Sedan(int id, String type, String model, String condition, String color, int capacity, int year, String fuelType,String transmission,String VIN, double price, int availability, String hasTurbo) {
    	super(id,type,model,condition,color,capacity,year,fuelType,transmission,VIN,price,availability,hasTurbo);
    }

    /**
     * Makes a sound specific to Sedan engines.
     */
    public void makeSound() {
        System.out.println("Sedan engine sound");
    }
}