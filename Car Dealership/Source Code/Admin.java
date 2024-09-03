import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents an administrator in the system.
 * 
 */
public class Admin implements inventoryManager{
	Scanner scanner = new Scanner(System.in);
	Car neededCar = new Car();
	/**
     * Default constructor for Admin.
     */

	public Admin() {}
	
	
    /**
     * Checks if the input from the scanner is a double.
     *
     * @param scanner The Scanner object used for input.
     * @return The double input by the user.
     */

	public static double getDouble(Scanner scanner) {
	    double doubleValue = 0.0; 
	    while (true) {
	        try {
	            String userInput = scanner.nextLine();
	            doubleValue = Double.parseDouble(userInput);
	            break; 
	        } catch (NumberFormatException e) {
	            System.out.println("Please enter a valid double value.");
	        }
	    }
	    return doubleValue;
	}
    
	
    /**
     * Checks if the input from the scanner as a yes or no.
     *
     * @param scanner The Scanner object used for input.
     * @return The integer input by the user.
     */

    public int checkInputInt(Scanner scanner) {
        System.out.print("Enter an integer: ");
        while (!scanner.hasNextInt()) {
            // If the input is not an integer, consume it and prompt again
            String input = scanner.nextLine();
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print("Enter an integer: ");
            
        }

        int number = scanner.nextInt();
        return number;
    }

    /**
     * Checks if the input from the scanner is an integer.
     *
     * @param scanner The Scanner object used for input.
     * @return A yes or no string by the user.
     */

    public static String getYesNo(Scanner scanner) {
        String userInput;
        while (true) {
            userInput = scanner.nextLine().trim().toLowerCase(); 
            if (userInput.equalsIgnoreCase("yes")) {
                return userInput;
            } else if (userInput.equalsIgnoreCase("no")) {
                return userInput;
            } else {
                System.out.println("Please enter 'yes' or 'no': ");
            }
        }
    }
    
    /**
     * Will check the users input to make sure it is one of the car types in the inventory. 
     *
     * @param scanner The Scanner object used for input.
     * @return A string with one of the four car types in the inventory.
     */
    public String checkCarType(Scanner scanner){
        while (true){
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equalsIgnoreCase("hatchback") || input.equalsIgnoreCase("sedan") || input.equalsIgnoreCase("suv") || input.equalsIgnoreCase("pickup")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter one of the following options: hatchback, sedan, SUV, or pickup.");
            }
        }
   }
    
    /**
     * Will check the users input to make sure it is either new or used to fit with the 
     * car's condition.
     *
     * @param scanner The Scanner object used for input.
     * @return A string with the value either being new or used.
     */
    public String checkCondition(Scanner scanner){
        while(true){
            String input = scanner.nextLine().trim().toLowerCase();
            if(input.equalsIgnoreCase("new")||input.equalsIgnoreCase("used")){
                return input;
            }else{
                System.out.println("Invalid Input. Please enter on of the following options: New, Used");
            }
        }
    }
    
    /**
     * Will check the users input to make sure it is either manual or automatic.
     *
     * @param scanner The Scanner object used for input.
     * @return A string with the value of either "manual" and "automatic".
     */
    public String checkTransmission(Scanner scanner){
        while(true){
            String input = scanner.nextLine().trim().toLowerCase();
            if(input.equalsIgnoreCase("manual")||input.equalsIgnoreCase("automatic")){
                return input;
            }else{
                System.out.println("Invalid Input. Please enter on of the following options: Manual, Automatic");
            }
        }
    }
    
    /**
     * Will check the users input so it is one of the allowed fuel types.
     *
     * @param scanner The Scanner object used for input.
     * @return A string with the value of either "diesel", "gasoline", "electric".
     */
    public String checkFuelType(Scanner scanner){
        while(true){
            String input = scanner.nextLine().trim().toLowerCase();
            if(input.equalsIgnoreCase("hybrid")||input.equalsIgnoreCase("diesel")||input.equalsIgnoreCase("gasoline")||input.equalsIgnoreCase("electric")){
                return input;
            }else{
                System.out.println("Invalid Input. Please enter on of the following options: Hybrid, Diesel, Gasoline, Electric");
            }
        }
    }
    
    /**
     * Will check if the user has provided a color that the dealership has for the cars..
     *
     * @param scanner The Scanner object used for input.
     * @return A string with one of the colors in the inventory.
     */
    public String checkColor(Scanner scanner){
        while(true){
            String input = scanner.nextLine().trim().toLowerCase();
            if(input.equalsIgnoreCase("yellow")||input.equalsIgnoreCase("silver")||input.equalsIgnoreCase("green")||input.equalsIgnoreCase("blue")||input.equalsIgnoreCase("red")||input.equalsIgnoreCase("white")||input.equalsIgnoreCase("black")){
                return input;
            }else{
                System.out.println("Invalid Input. Please enter on of the following options: Yellow, Silver, Green, Blue, Red, White, Black");
            }
        }
    }
    
    
    /**
     * Adds a new car to the inventory.
     *
     * @param number The number of cars already in the inventory.
     */

    public void addCar(int number) {
        System.out.println("Provide the cars VIN: ");//??
        String vin = scanner.nextLine();

        System.out.println("Provide the cars model: ");//done
        String model = scanner.nextLine();

        System.out.println("Provide the cars condition: (New, Used) ");//done
        String condition = checkCondition(scanner);

        System.out.println("Provide the cars color: ");//done
        String color = checkColor(scanner);

        System.out.println("Provide the cars price: ");//done
        double price = getDouble(scanner);

        System.out.println("Provide the cars transmission: ");//done
        String transmission = checkTransmission(scanner);

        System.out.println("Provide the cars fuel type: ");//done
        String fuel = checkFuelType(scanner);

        System.out.println("Provide the cars type: (Hatchback, Sedan, SUV, Pickup)");//done
        String type = checkCarType(scanner);

        System.out.println("Provide if the car has Turbo mode: ");//done
        String hasTurbo = getYesNo(scanner);

        System.out.println("Provide the cars year: ");//done
        int year = checkInputInt(scanner);

        System.out.println("Provide the cars capacity: ");//done
        int capacity = checkInputInt(scanner);

        int id = number + 1;
        System.out.println("Provide how many cars will be available: ");
        int available = checkInputInt(scanner);

        Vehicle newCar = neededCar.makeCar(id, type, model, condition, color, capacity, year, fuel, transmission, vin, price, available, hasTurbo);
        try {
            FileWriter writer = new FileWriter("src\\car_data.csv",true);
            writer.write(newCar.infoToCSV()+ "\n");
            writer.close();
        }catch (IOException e) {
            System.err.println("Can't write to CSV. " + e.getMessage());
        }
        System.out.println("Car successfully added to inventory.");

    }

	/**
     * Adds a new user to the system.
     *
     * @param number The number of users already in the system.
     */

	public void addNewUser(int number) {
    	System.out.println("Provide the first name: ");
    	String firstName = scanner.next();
    	System.out.println("Provide the last name: ");
    	String lastName = scanner.next();
    	System.out.println("Provide the customers username: ");
    	String username = scanner.next();
    	System.out.println("Provide the customers password: ");
    	String password = scanner.next();
    	System.out.println("Will they have a membership [Yes/No]: ");
    	String mem = getYesNo(scanner);
    	Boolean membership = false;
    	if(mem.equalsIgnoreCase("yes")) {
    		membership = true;
    	}
    	System.out.println("How much money does the user have: ");
    	double money = getDouble(scanner);
    	int carsPurchased = 0; 
    	int newid = number;
    	User newUser = new User(newid, firstName, lastName, money, carsPurchased, membership, username, password);
    	try {
    		FileWriter writer = new FileWriter("src\\user_data.csv",true);
    		writer.write(newUser.infoToCSV()+ "\n");
    		writer.close();
    	}catch (IOException e) {
    		System.err.println("Can't write to CSV. " + e.getMessage());
    	}
    	System.out.println("User successfully added to user database.");
		
	}

	/**
     * Calculates and displays profits based on a filter.
     *
     * @param index  The index of the filter.
     * @param filter The filter to apply for calculating profits.
     */

	public void getProfits(int index, String filter) {
		   try (BufferedReader buffread = new BufferedReader(new FileReader("src\\Ticket.txt"))) {
			   String line; 
			   double totalprofit = 0;
			   while((line = buffread.readLine()) != null) {
				   String[] profits = line.split(",");	
				   if (profits[index].equalsIgnoreCase(filter)) {
					   totalprofit = totalprofit + Double.parseDouble(profits[8]);
				   }
			   }
			   System.out.println("Total profits by Car " + filter + ": " + totalprofit);
		   }catch (IOException e) {
			   System.err.println("Could not read file.");
		   }
	}


	@Override
	
	/**
     * Removes a car from the inventory managing the CSV file.
     *
     * @param inventory The array of cars in the inventory.
     */
	public void remCar(Vehicle[] inventory) {
    	System.out.println("Please provide the car that you want to remove: ");
    	String vinDelete = scanner.next();
        try (BufferedWriter write = new BufferedWriter(new FileWriter("src\\car_data.csv"))){
           	String headers = "ID,VIN,Price,Model,Capacity,Color,Year,Fuel Type,Cars Available,Condition,Transmission,Car Type,hasTurbo";
           	write.write(headers);
           	write.newLine();
       		for(int i = 0; i < inventory.length-1; i++) {
       			if (!(vinDelete.equals(inventory[i].get_VIN()))) {
           			write.write(inventory[i].infoToCSV());
           			write.newLine();
       			}
       		}
       		write.close();
       		}catch (IOException e) {
       		System.out.println("Couldnt not update CSV files. Files are currently in use.");
       		System.out.println("Any purchases have become void.");
       		e.printStackTrace();
       		}
		
	}


}