/**
 * Represents a SUV, which is a type of car extending the Car class.
 */
public class SUV extends Vehicle {
    /**
     * Constructs a new SUV object with the specified properties.
     *
     * @param id The unique ID of the SUV.
     * @param type The type of car which corresponds to this subclass "SUV".
     * @param model The model of the SUV.
     * @param condition The condition of the SUV (e.g., new, used).
     * @param color The color of the SUV.
     * @param capacity The seating capacity of the SUV.
     * @param year The year of the SUV.
     * @param fuelType The fuel type of the SUV.
     * @param transmission The transmission type of the SUV.
     * @param VIN The Vehicle Identification Number (VIN) of the SUV.
     * @param price The price of the SUV.
     * @param availability The availability status of the SUV.
     * @param hasTurbo If the SUV has a turbo mode.
     */
    public SUV(int id, String type, String model, String condition, String color, int capacity, int year, String fuelType,String transmission,String VIN, double price, int availability, String hasTurbo) {
    	super(id,type,model,condition,color,capacity,year,fuelType,transmission,VIN,price,availability,hasTurbo);
    }
    /**
     * Makes a sound specific to SUV engines.
     */
    public void makeSound() {
        System.out.println("SUV engine sound");
    }
}