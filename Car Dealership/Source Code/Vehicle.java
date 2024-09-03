
abstract class Vehicle {

    int id;
    String VIN;
    double price;
    String model;
    int capacity;
    String color;
    int year;
    String fuelType;
    int availability;
    String condition;
    String transmission;
    String type;
    String hasTurbo;
    
    public Vehicle(int id, String type, String model, String condition, String color, int capacity, int year, String fuelType,String transmission,String VIN, double price, int availability, String hasTurbo) {
        this.id = id;
        this.VIN = VIN;
        this.price = price;
        this.model = model;
        this.year = year;
        this.availability = availability;
        this.fuelType = fuelType;
        this.color = color;
        this.capacity = capacity;
        this.condition = condition;
        this.transmission = transmission;
        this.type = type;
        if (hasTurbo.isEmpty()) {
        	hasTurbo ="No";
        }else {
            this.hasTurbo = hasTurbo;
        }
    }
    /**
     * Gets the unique ID of the car.
     *
     * @return The ID of the car.
     */
    public int get_ID() {
        return id;
    }

    /**
     * Gets the Vehicle Identification Number (VIN) of the car.
     *
     * @return The VIN of the car.
     */
    public String get_VIN() {
        return VIN;
    }

    /**
     * Gets the price of the car.
     *
     * @return The price of the car.
     */
    public double get_Price() {
        return price;
    }

    /**
     * Gets the model of the car.
     *
     * @return The model of the car.
     */
    public String get_Model() {
        return model;
    }

    /**
     * Gets the seating capacity of the car.
     *
     * @return The seating capacity of the car.
     */
    public int get_Capacity() {
        return capacity;
    }

    /**
     * Gets the color of the car.
     *
     * @return The color of the car.
     */
    public String get_Color() {
        return color;
    }

    /**
     * Gets the year of the car.
     *
     * @return The year of the car.
     */
    public int get_Year() {
        return year;
    }

    /**
     * Gets the fuel type of the car.
     *
     * @return The fuel type of the car.
     */
    public String get_FuelType() {
        return fuelType;
    }

    /**
     * Gets the availability status of the car.
     *
     * @return The availability status of the car.
     */
    public int get_Available() {
        return availability;
    }

    /**
     * Gets the condition of the car.
     *
     * @return The condition of the car.
     */
    public String get_Condition() {
        return condition;
    }

    /**
     * Gets the transmission type of the car.
     *
     * @return The transmission type of the car.
     */
    public String get_Transmission() {
        return transmission;
    }

    /**
     * Gets the type of the car.
     *
     * @return The type of the car.
     */
    public String get_Type() {
        return type;
    }
    /**
     * Gets if the car has Turbo.
     *
     * @return a yes or no String.
     */
    public String carHasTurbo() {
        return hasTurbo;
    }
    /**
     * Sets the availability status of the car.
     *
     * @param availability The availability status to set.
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * Prints the details of the car including its ID, VIN, price, model, etc.
     */
    public void print_details() {
        System.out.println("Car Information:");
        System.out.println("ID: " + id + ". VIN: " + VIN + ". Price: $" + price + ". Model: " + model +
                ". Capacity: " + capacity + " people" + ". Color: " + color + ". Year: " + year +
                " miles. Fuel Type: " + fuelType + ", Availability: " + availability + ". Condition: " +
                condition + ". Transmission: " + transmission + ". Type: " + type + ". hasTurbo: " + hasTurbo + "\n");
    }
    
    /**
     * Will create a CSV like string
     * @return Will return a CSV like string to write into the actual CSV.
     */
    public String infoToCSV() {
    	String info = id+","+VIN+","+price+","+model+","+capacity+","+color+","+year+","+fuelType+","+availability+","+condition+","+transmission+","+type+","+hasTurbo;
    	return info;
    }

}
