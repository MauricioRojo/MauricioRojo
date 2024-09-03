/**
 * Represents a Car object with various properties such as ID, VIN, price, model, etc.
 */
public class Car{

    int id = 0;
    String VIN = "";
    double price = 0;
    String model = "";
    int capacity = 0;
    String color = "";
    int year = 0;
    String fuelType = "";
    int availability = 0;
    String condition = "";
    String transmission = "";
    String type = "";
    String hasTurbo = "";

    
    /**
     * Will create an instance of a car object.
     */
    public Car() {}
    /**
     * Constructs a new Car object with the specified properties.
     *
     * @param id The unique ID of the car.
     * @param type The type of the car (e.g., sedan, SUV).
     * @param model The model of the car.
     * @param condition The condition of the car (e.g., new, used).
     * @param color The color of the car.
     * @param capacity The seating capacity of the car.
     * @param year The year of the car.
     * @param fuelType The fuel type of the car.
     * @param transmission The transmission type of the car.
     * @param VIN The Vehicle Identification Number (VIN) of the car.
     * @param price The price of the car.
     * @param availability The availability status of the car.
     * @param hasTurbo If the car has a turbo mode. 
     * @return A vehicle type with all the information about the car given.
     */
    public Vehicle makeCar(int id, String type, String model, String condition, String color, int capacity, int year,
               String fuelType, String transmission, String VIN, double price, int availability, String hasTurbo) {
    	
        if (type.equalsIgnoreCase("SUV")) {
        	return new SUV(id,type,model,condition,color,capacity,year,fuelType,transmission,VIN,price,availability,hasTurbo);
        }else if (type.equalsIgnoreCase("Sedan")) {
        	return new Sedan(id,type,model,condition,color,capacity,year,fuelType,transmission,VIN,price,availability,hasTurbo);
        }else if(type.equalsIgnoreCase("Pickup")) {
        	return new Pickup(id,type,model,condition,color,capacity,year,fuelType,transmission,VIN,price,availability,hasTurbo);
        }else if (type.equalsIgnoreCase("HatchBack")) {
        	return new Hatchback(id,type,model,condition,color,capacity,year,fuelType,transmission,VIN,price,availability,hasTurbo);
        }
        else {
        	throw new IllegalArgumentException("Invalid vechicle type.");
        }
        

    }
    
 
}