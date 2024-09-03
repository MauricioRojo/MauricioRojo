import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.text.DecimalFormat;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.*;
import java.util.*;
/**
 * Eduardo Ceballos Faour, Mauricio Rojo, Omar Martinez, 4/7/2024, Adv. Object Oriented Programming, 
 * Dr Bhanukiran Gurijala, Programming Assignment 1.
 * 
 * This class represents a program for managing a car dealership system. It starts off by 
 * obtaining all information from a from the provided CSV files and inserts them into a 2D 
 * string array. Once the information is collected every row of the CSV file its working with
 * will be turned into the appropriate class. 
 * Afterward it will ask the user to sign in using their credentials or they can type "EXIT" in 
 * order to leave the page. Depending on the credentials given, the user will be provided the customer 
 * page or the admin page which do different tasks. 
 * Customers can see the whole car inventory and other small details. They can filter the cars they
 * see by choosing new cars or old cars. They can make a purchase which will update the inventory. 
 * the customers money count and create a ticket for that user. The admin is able to get all of the
 * logs, tickets and edit the car inventory. 
 * Honesty statement: We affirm that this project was solely completed by us,
 * without any external sources such as peers, experts, online materials, or similar aids. 
 * Our only assistance came from the instructor, TA, and IA. All contents in this document
 * is our original creation.
 */



public class RunShop{
	/**
	 * Will create a instance of RunShop
	 */
	public RunShop() {}
	Car cars = new Car();
    static String file = "src\\Logs.txt";
    static RunShop obj = new RunShop();
	static User[] users;
	static Vehicle[] carInventory;
    static User loggedIn;
    
	 /**
     * The main method to run the car dealership program.
     *
     * @param args Command line arguments
     * @throws java.io.IOException if there is any issue reading any files
     */

    public static void main(String[] args) throws IOException {
    	users = obj.readCSVUser();
    	carInventory = obj.readCSVCar();
    	obj.organizeCSVs(carInventory, users);
        //The previous two 'for' loops read from the excel sheets, They obtain all of the information in the cells of the sheet and using the constructors
        //build an object and place it inside the corresponding array. 
        //The first array contains User Objects and the second Car Objects

        Scanner scanner = new Scanner(System.in);

        //The do while is started once the objects from the excel sheets are created. The first step will be asking for a username and a password.
        //It will search through User array and find a matching user name and a password. If both match it will proceed to show the user the menu 
        //Otherwise they will be denied access.
        do {
            System.out.print("Please print your username or write EXIT to leave:");
            String inputusername = scanner.next();
            if (inputusername.equalsIgnoreCase("EXIT")) {
            	System.out.println("Pleasure doing business with you.");
            	System.exit(0);
            }
            System.out.print("Password:");
            String inputpassword = scanner.next();

        	if(inputusername.equals("Admin1") && inputpassword.equals("Dealership")) {
        		obj.adminMenu(scanner);
        	}else if(authenticate(inputusername, inputpassword,users)) {
            	System.out.println("Customer " + loggedIn.get_firstName() + " has logged in.");
	            Log log = new Log("Customer: " + loggedIn.get_firstName() + " has logged in.");
	            writeToLogs(file, log.get_log());
	                
	            int input2;        
	            do{
	                UserMenu();
	                input2 = obj.checkInputInt(scanner);
	                Log logs;
	                switch(input2){
	                    case 1:
	                    //For loops with objects in it require to start at 1, row 0 of the array is full of null values
	                    	logs = new Log("User: " + inputusername +" has chosen to see all cars.");
	                    writeToLogs(file, logs.get_log());
	                    for(int i = 1; i < carInventory.length-1; i++){
	                    	carInventory[i].print_details();
	                        }
	                        break;
	                    case 2:
	                    	logs = new Log("User: " + inputusername + "wants to filter cars to see.");
	                        writeToLogs(file, logs.get_log());
	                        System.out.println("Filter cars by: 1) New or 2) Used");
	                        int input3 = obj.checkInputInt(scanner);
	                            if (input3 == 1){
	                            	logs = new Log("User: " + inputusername + "wants to see new cars only.");
	                                writeToLogs(file, logs.get_log());
	                                for(int i = 1; i < carInventory.length-1; i++){
	                                    if (carInventory[i].get_Condition().equals("New")){
	                                    	carInventory[i].print_details();
	                                    }
	                                }
	                            }else if (input3 == 2){
	                            	logs = new Log("User: " + inputusername + "wants to see used cars only.");
	                                writeToLogs(file, logs.get_log());
	                                for(int i = 1; i < carInventory.length-1; i++){
	                                    if (carInventory[i].get_Condition().equals("Used")){
	                                    	carInventory[i].print_details();
	                                    }
	                                }
	                            }else{
	                                System.out.println("No such input recognized.");
	                            }
	                        break;
	                    case 3:
	                    	logs = new Log("User " + inputusername + " wants to purchase a car");
	                        writeToLogs(file, logs.get_log());
	                        System.out.println("Please input the VIN number of the vehicle you want to purchase.");
	                        String carSelection = scanner.next();
	                        Vehicle car = carSearch(carSelection, carInventory);
	                        if (car == null) {
	                        	System.out.println("Car not found. Either the car is not in the inventory or the VIN number was written wrong.");
	                        	break;
	                        }else {
	                        	if (car.get_Available() > 0) {
	                        		if (loggedIn.get_moneyAvailable() >= car.get_Price()) {
	                        			System.out.println("Vehicle found and user has enough funds. Proceed with purchase? Yes/No");
	                        			String answer = getYesNo(scanner);
	                        			if (answer.equalsIgnoreCase("yes")) {
	                        				obj.makePurchase(car, loggedIn ,car.get_Price());
	                        				try {
	                        				    System.out.println("Purchase complete. Current balance:" + loggedIn.get_moneyAvailable() + " cars: " + car.get_Available());
	                        				    Ticket ticket = new Ticket(car);
	                        				    ticket.printTicket();
	                        				    obj.save_Ticket(car, loggedIn);
	                        				} catch (Exception e) {
	                        				    // Handle the IOException
	                        				    System.err.println("An error occurred while accessing the files:");
	                        				    e.printStackTrace();
	                        				} finally {
	                        				    // Close any resources if needed (e.g., BufferedWriters, etc.)
	                        				    // Note: If your methods handle closing resources internally, you may not need to close them here
	                        				}
	                        			}else{
	                        				System.out.println("Canceling purchase, returning to the menu.");
	                        			}
	                        		}else {
	                        			System.out.println("Not enough funds to purchase the car.");
	                        			break;
	                        		}
	                        	}else{
	                        		System.out.println("Car is not available.");
	                        	}
	                        }
	                        break;
	                    case 4:
	                    	logs = new Log("User " + inputusername + " wants to view tickets.");	
	                    	writeToLogs(file, logs.get_log());
	                    	obj.get_CustomerTickets(loggedIn.get_ID());
	                        break;
                        case 5:
                            logs = new Log("User " + inputusername + " wants to return a car");
                            writeToLogs(file, logs.get_log());
                            if(loggedIn.get_carsPurchased()==0){
                                System.out.println("You have no purchased cars");
                                System.out.println(" ");
                                break;
                            }
                            obj.get_CustomerTickets(loggedIn.get_ID());

                            System.out.println("Please input the VIN number of the vehicle you want to return:");
                            String VINreturn = scanner.next();
                            Vehicle carR = carSearch(VINreturn, carInventory);
                            if (carR == null) {
                                System.out.println("Car not found. Either the car is not in the inventory or the VIN number was written wrong.");
                                break;
                            }
                            obj.PurchasedReturn(carR, loggedIn,carR.get_Price());
                            try {
                                System.out.println("Return complete. Current balance:" + loggedIn.get_moneyAvailable());
                                String temp1 =obj.get_CustomerTickets_Specific(loggedIn.get_ID(),VINreturn);
                                deleteTicket(temp1);
                            } catch (Exception e) {
                                System.err.println("An error occurred while accessing the files:");
                                e.printStackTrace();
                            } finally {

                            }

                            break;
                        case 6:
                            logs = new Log("User " + inputusername + " has signed out.");
                            writeToLogs(file, logs.get_log());
                            break;
	                }
	
	            }while(input2 != 6);
		            
            } else {
                System.out.println("wrong username or password. Try again");  
            }

        }while(true);

    }
    
    
	/**
	 * Handles the return of a purchased car by updating user data and car availability.
	 *
	 * @param car The car being returned
	 * @param customer The customer returning the car
	 * @param price The price of the returned car
	 * @throws java.io.IOException if there is any issue reading any files.
	 */
    private void PurchasedReturn(Vehicle car, User customer, double price) throws IOException{
        Reader read = new FileReader("src\\user_data.csv");
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        CSVParser parse = format.parse(read);
        for(CSVRecord record : parse) {
            String userID = record.get("ID");
            if (userID.equals(String.valueOf(customer.get_ID()))) {
                //System.out.println(record);
                double userMoney = Double.parseDouble(record.get("Money Available"));
                if (customer.has_Membership()) {
                    price *= 0.90;
                }
                price += (price * 0.0825);
                userMoney += price;
                double roundedMoney = Math.round(userMoney*100.0)/100.0;
                customer.update_UserMoney(roundedMoney);
                customer.update_CarsReturned();
                //System.out.println(customer.infoToCSV());
            }
        }
        parse.close();
        Reader readcar = new FileReader("src\\car_data.csv");
        CSVFormat formatcar = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        CSVParser parsecar = formatcar.parse(readcar);
        for(CSVRecord record : parsecar) {
            String carID = record.get("ID");
            if (carID.equals(String.valueOf(car.get_ID()))) {
                car.setAvailability(car.get_Available() + 1);
            }
        }
        organizeCSVs(carInventory, users);
    }

	/**
	 * Method to delete ticket for returned car.
	 *
	 * @param ticket0 Ticket that will be deleted.
	 */

    private static void deleteTicket(String ticket0) {
        List<String> ticketLines = new ArrayList<>();
        String header = "";

        try (BufferedReader reader = new BufferedReader(new FileReader("src\\Ticket.txt"))) {
            header = reader.readLine();
            if (header == null) {
                System.err.println("File is empty");
                return;
            }
            String line;
            while ((line = reader.readLine()) != null) {
                ticketLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        boolean matchFound = false;
        Iterator<String> iterator = ticketLines.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.equals(ticket0) && !matchFound) {
                matchFound = true;
                iterator.remove();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Ticket_temp.txt"))) {
            writer.write(header);
            writer.newLine();
            for (String line : ticketLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        File originalFile = new File("src\\Ticket.txt");
        File tempFile = new File("src\\Ticket_temp.txt");
        if (!originalFile.delete()) {
            System.out.println("Could not delete original file");
            return;
        }
        if (!tempFile.renameTo(originalFile)) {
            System.out.println("Could not rename temporary file");
        }
    }
    
    
    
	/**
	 * Displays the user menu options.
	 */

    public static void UserMenu(){
        System.out.println("MENU");
        System.out.println("1. Display all cars.");
        System.out.println("2. Filter Cars (used / new) ");
        System.out.println("3. Purchase a car");
        System.out.println("4. View Tickets ");
        System.out.println("5. Return Car");
        System.out.println("6. Sign out");
    }
    
    
    
    /**
	 * Displays the admin menu options.
	 */

    public static void adminMenuDisplay() {
        System.out.println("MENU");
        System.out.println("1. Check Logs");
        System.out.println("2. Check Purchased cars");
        System.out.println("3. Add Car To Inventory");
        System.out.println("4. Delete Car From Inventory");
        System.out.println("5. Add Customer");
        System.out.println("6. Get Profits");
        System.out.println("7. Sign Out");
    }
    
    
	/**
	 * Displays and manages the admin menu options.
	 *
	 * @param scanner The Scanner object for user input
	 * @throws java.io.IOException if there is any issue reading any files
	 */

    private void adminMenu(Scanner scanner) throws IOException{
    	Log logs;
    	Admin inCharge = new Admin();
    	int rows;
    	int input;
        do {
        	adminMenuDisplay();
            input = obj.checkInputInt(scanner);
            switch(input) {
            case 1:
    			logs = new Log("Admin wants to view the logs.");	
            	writeToLogs(file, logs.get_log());
            	obj.get_Logs();
            	break;
            case 2:
    			logs = new Log("Admin wants to view all tickets.");	
            	writeToLogs(file, logs.get_log());
            	obj.get_AllPurchases();
    			break;
            case 3:
            	logs = new Log("Admin is adding a new car into the inventory.");	
            	writeToLogs(file, logs.get_log());
            	rows = getRowCount("src\\car_data.csv");
            	inCharge.addCar(rows);
            	carInventory = obj.readCSVCar();
            	break;
            	
            case 4:
            	logs = new Log("Admin deleting a car from the inventory.");	
            	writeToLogs(file, logs.get_log());
            	inCharge.remCar(carInventory);
       			carInventory = obj.readCSVCar();            	
            	break;
            	
            case 5:
            	logs = new Log("Admin is adding a new customer into the system.");	
            	writeToLogs(file, logs.get_log());
            	rows = obj.getRowCount("src\\user_data.csv");
            	inCharge.addNewUser(rows);
       			users = obj.readCSVUser();
            	break;
            case 6:
            	logs = new Log("Admin is checking profits.");	
            	writeToLogs(file, logs.get_log());
            	System.out.println("Please type ID of the car or the type of car: ");
            	String filter = scanner.next();
            	int index;
     		   	if (filter.equalsIgnoreCase("id")) {
     		   		System.out.print("Please provide the ID of the car: ");
     		   		index = 3;
     		   		int searchID = obj.checkInputInt(scanner);
     		   		inCharge.getProfits(index,String.valueOf(searchID));
     		   		
     		   	}else if(filter.equalsIgnoreCase("SUV") || filter.equalsIgnoreCase("Pickup") || filter.equalsIgnoreCase("Hatchback") || filter.equalsIgnoreCase("Sedan")) {
                	logs = new Log("Admin is checking profits from a specific car type.");	
                	writeToLogs(file, logs.get_log());
     		   		index = 4;
     		   		inCharge.getProfits(index, filter);
     		   		
     		   	}else {
     		   		System.out.println("Invalid filter value.");
     		   	}
            	break;
            case 7: 
            	logs = new Log("Admin is signing out.");	
            	writeToLogs(file, logs.get_log());
            	break;
            }
        }while(input != 7);
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
	 * Start of all methods that are being used.
	 * @param scanner The Scanner object for user input.
	 * @return number An integer value from the user. 
	 */

    public int checkInputInt(Scanner scanner) {
        System.out.print("Enter an integer: ");
        while (!scanner.hasNextInt()) {
            // If the input is not an integer, consume it and prompt again
            String input = scanner.next();
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print("Enter an integer: ");
            
        }

        int number = scanner.nextInt();
        return number;
    }
    
    /**
     * This method is what checks for the right credentials of the user. 
     * @param user1 The username of the user.
     * @param pass1 The password of the user.
     * @param us The lists of users it will check from.
     * @return If the user gave the right credentials.
     */
    private static boolean authenticate(String user1, String pass1,User[] us){

        for(int i=0; i<us.length-1; i++){
            if(us[i].get_Username().equals(user1) && us[i].get_password().equals(pass1)){
                loggedIn = us[i]; 
                return true;
            }
        }
        return false;

    }
    
    /**
     * This method when prompted will aid the user search for the car they want to purchase depending on the VIN they
     * provide. 
     * @param VIN The VIN of the car needed to be found.
     * @param cr The inventory of all cars.
     * @return The car that is being searched for.
     */
    private static Vehicle carSearch(String VIN, Vehicle[] cr){
    	for(int i= 0; i < cr.length-1; i++) {
    		if ((cr[i].get_VIN()).equals(VIN)) {
        		return cr[i];
    		}
    	}
    	return null;
    }


    /**
     * This method is what is turning all of the users inside the CSV into User objects and placing them inside of a list.
     * It handles the headers even when they are out of order.
     * @return users The list of user objects read from the CSV.
     * @throws java.io.IOException if there is any issue reading any files
     */
    public User[] readCSVUser() throws IOException{
    	User[] users = new User[getRowCount("src\\user_data.csv")];
    	int i = 0;
    	try (Reader read = new FileReader("src\\user_data.csv");
    		CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(read)){
    		
    		for (CSVRecord record : parser) { // Debug statement to print the CSV record
                if (parser.getHeaderMap() == null) {
                    System.out.println("CSV file has no headers.");
                    return null;  // Or handle this case accordingly
             }
    				
    			String ID = record.get("ID");
    			String firstName = record.get(parser.getHeaderMap().get("First Name"));
    			String lastName = record.get(parser.getHeaderMap().get("Last Name"));
    			String money = record.get(parser.getHeaderMap().get("Money Available"));
    			String carsPurchased = record.get(parser.getHeaderMap().get("Cars Purchased"));
    			String membership = record.get(parser.getHeaderMap().get("MinerCars Membership"));
    			String username = record.get(parser.getHeaderMap().get("Username"));
    			String password = record.get(parser.getHeaderMap().get("Password"));
    		    User x = new User(Integer.parseInt(ID),firstName,lastName,Double.parseDouble(money),Integer.parseInt(carsPurchased),Boolean.parseBoolean(membership), username, password);
    			users[i++] = x;
    		}
    	} catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    	return users;
    }
    
    
    /**
    * This method is what is turning all of the cars inside the CSV into Car objects and placing them inside of a list.
    * It handles the headers even when they are out of order. 
    * @return carInventory The list of all car objects read from the CSV.
    * @throws java.io.IOException if there is any issue reading any files
    */
    public Vehicle[] readCSVCar() throws IOException{
    	Vehicle[] carInventory = new Vehicle[getRowCount("src\\car_data.csv")];
    	int i = 0;
    	try (Reader read = new FileReader("src\\car_data.csv");
    		CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(read)){
    		
    		for (CSVRecord record : parser) {
                if (parser.getHeaderMap() == null) {
                    System.out.println("CSV file has no headers.");
                    return null; 
             }
    			String ID = record.get("ID");
    			String carType = record.get(parser.getHeaderMap().get("Car Type"));
    			String model = record.get(parser.getHeaderMap().get("Model"));
    			String condition = record.get(parser.getHeaderMap().get("Condition"));
    			String color = record.get(parser.getHeaderMap().get("Color"));
    			String capacity = record.get(parser.getHeaderMap().get("Capacity"));
    			String year = record.get(parser.getHeaderMap().get("Year"));
    			String fuelType = record.get(parser.getHeaderMap().get("Fuel Type"));
    			String transmission = record.get(parser.getHeaderMap().get("Transmission"));
    			String vin = record.get(parser.getHeaderMap().get("VIN"));
    			String price = record.get(parser.getHeaderMap().get("Price"));
    			String carsAvailable = record.get(parser.getHeaderMap().get("Cars Available"));
    			String hasTurbo = record.get(parser.getHeaderMap().get("hasTurbo"));
    		    Vehicle x = cars.makeCar(Integer.parseInt(ID),carType, model, condition,color,Integer.parseInt(capacity),Integer.parseInt(year), fuelType, transmission, vin, Double.parseDouble(price), Integer.parseInt(carsAvailable), hasTurbo);
    			carInventory[i++] = x;
    		}
    	} catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    	return carInventory;
    }
    
    /**
     * This method helps identify how many rows there are in the CSV to then creates lists for the objects needed.
     * @param fileName The name of the files where it will get how many rows there are in it. 
     * @return count The integer with the row count. 
     * @throws java.io.IOException if there is any issue reading any files
     */
    int getRowCount(String fileName) throws IOException {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * This method is the one responsible for writing all of the logs into the logs.txt
     * @param fileName The name of the file in which to write the logs to.
     * @param content What needs to be written into the corresponding file. 
     */
    public static void writeToLogs(String fileName, String content) {
    	try {
    		FileWriter write = new FileWriter(fileName, true);
    		write.write(content + "\n");
    		write.close();
    	} catch (IOException e) {
    		System.err.println("Error writing to the file given: " + e.getMessage());
    	}
    }
    
    /**
    * This method will allow the user to make a purchase. They will be given a discount if they have a membership. 
    * The price of the car will be taxed and the total is subtracted from the users money. The availability of the 
    * car is also updated. 
    * @param car The car that will be purchased
    * @param customer The customer that will be purchasing the car. 
    * @param price The price of the car.
    * @throws java.io.IOException if there is any issue reading any files
    */
    private void makePurchase(Vehicle car, User customer, double price) throws IOException{
    	Reader read = new FileReader("src\\user_data.csv");
    	CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
    	CSVParser parse = format.parse(read);
    		for(CSVRecord record : parse) {
    			String userID = record.get("ID");
    			if (userID.equals(String.valueOf(customer.get_ID()))) {
    				 double userMoney = Double.parseDouble(record.get("Money Available"));
                     if (customer.has_Membership()) {
                         price *= 0.90;
                     }
                     price += (price * 0.0825);
                     userMoney -= price;
                     double roundedMoney = Math.round(userMoney*100.0)/100.0;
                     customer.update_UserMoney(roundedMoney);
                     customer.update_CarsPurchased();
    			}
    		}
    	parse.close();
    	Reader readcar = new FileReader("src\\car_data.csv");
    	CSVFormat formatcar = CSVFormat.DEFAULT.withFirstRecordAsHeader();
    	CSVParser parsecar = formatcar.parse(readcar);
    		for(CSVRecord record : parsecar) {
    			String carID = record.get("ID");
    			if (carID.equals(String.valueOf(car.get_ID()))) {
    				car.setAvailability(car.get_Available() - 1);
    			}
    		}
    	organizeCSVs(carInventory, users);
    }
    

/**
 * The following method will create a ticket after a car is purchased and save it inside of the Tickets.txt
 * @param car The car that has been purchased and we will get information from.
 * @param user The user that has purchased the car and we will get information from.
 */
    private void save_Ticket(Vehicle car, User user){
    	try (BufferedWriter write = new BufferedWriter(new FileWriter("src\\Ticket.txt",true))){
    		write.write(user.get_ID() + ",");
    		write.write(user.get_firstName()+","+user.get_lastName()+",");
    		write.write(car.get_ID() + ","+car.get_Type()+","+car.get_Model()+","
    		+car.get_VIN()+","+car.get_Color()+","+car.get_Price());
    		write.newLine();
    		write.close();
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * This will search through the ticket.txt file and search for the users purchases and display them for the user.
     * @param id The id of the user needed to be found
     * @throws java.io.IOException if there is any issue reading any files
     */
    private void get_CustomerTickets(int id) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("src\\Ticket.txt"))) {
        	String line;
        	while((line = br.readLine()) != null) {
        		String[] textID = line.split(",");
        		if (textID[0].equals(String.valueOf(id))) {
        			System.out.println(line);
        		}
        	}
        	br.close();
        }catch (IOException e) {
        	System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    
    /**
     * This method will allow an admin to get all of the logs that correspond to activities happening to the dealership.
     * 
     */
   private void get_Logs() {
	   try (BufferedReader br = new BufferedReader(new FileReader("src\\Logs.txt"))) {
		   String line;
		   while((line = br.readLine()) != null) {
			   System.out.println(line);
       		}
		   br.close();
       }catch (IOException e) {
       	System.err.println("Error reading the file: " + e.getMessage());
       }
   }
   

   /**
    * This method will print all of the purchases done by the dealership. It will display information about the car and the owner.
    */
   private void get_AllPurchases() {
	   try (BufferedReader br = new BufferedReader(new FileReader("src\\Ticket.txt"))) {
		   String line;
		   while((line = br.readLine()) != null) {
			   System.out.println(line);
       		}
		   br.close();
       }catch (IOException e) {
       	System.err.println("Error reading the file: " + e.getMessage());
       }
   }
   
   
   /**
    * Once the Car and User lists are created it will organize the CSV in a more manageable way. 
    * This method is used at the very beginning of the program to make the rest of the functions easier to manage.
    * @param car The inventory of all the cars in the dealership.
    * @param user The list of all users managed by the dealership.
    */ 
   private void organizeCSVs(Vehicle[] car, User[] user) {
       try (BufferedWriter write = new BufferedWriter(new FileWriter("src\\user_data.csv"))){
       	String headers = "ID,First Name,Last Name,Username,Password,MinerCars Membership,Money Available,Cars Purchased";
       	write.write(headers);
       	write.newLine();
   		for(int i = 0; i < user.length-1; i++) {
   			write.write(user[i].infoToCSV());
   			write.newLine();
   		}
   		write.close();
   		}catch (IOException e) {
   		System.out.println("Couldnt not update CSV files. Files are currently in use.");
   		System.out.println("Any purchases have become void.");
   		e.printStackTrace();
   		}
       try (BufferedWriter write = new BufferedWriter(new FileWriter("src\\car_data.csv"))){
       	String headers = "ID,VIN,Price,Model,Capacity,Color,Year,Fuel Type,Cars Available,Condition,Transmission,Car Type,hasTurbo";
       	write.write(headers);
       	write.newLine();
   		for(int i = 0; i < car.length-1; i++) {
   			write.write(car[i].infoToCSV());
   			write.newLine();
   		}
   		write.close();
   		}catch (IOException e) {
   		System.out.println("Couldnt not update CSV files. Files are currently in use.");
   		System.out.println("Any purchases have become void.");
   		e.printStackTrace();
   		}
   }
   
   
   
	/**
    * Searches through the Tickets.txt file for purchases made by a specific user and displays them.
    *
    * @param id The user ID to search for.
    * @return The tickets of the user.
    * @throws java.io.IOException if there is any issue reading any files
    */

   private String get_CustomerTickets_Specific(int id, String VIN) throws IOException {
       List<String[]> ticketList = new ArrayList<>();

       try (BufferedReader br = new BufferedReader(new FileReader("src\\Ticket.txt"))) {
           String line;
           while ((line = br.readLine()) != null) {
               String[] textID = line.split(",");
               ticketList.add(textID);
           }
       } catch (IOException e) {
           System.err.println("Error reading the file: " + e.getMessage());
           return null;
       }

       for (String[] ticket : ticketList) {
           if (ticket.length >= 7 && ticket[0].equals(String.valueOf(id)) && ticket[6].equals(VIN)) {
               // Found matching ID and VIN, return the line
               return String.join(",", ticket);
           }
       }
       return null;
   }
}
   



	
