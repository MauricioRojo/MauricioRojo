/**
 * Represents a User with various properties such as ID, username, password, etc.
 */
public class User {

    /** The unique ID of the user. */
    int id = 0;

    /** The first name of the user. */
    String firstName = "";

    /** The last name of the user. */
    String lastName = "";

    /** The username of the user. */
    String userName = "";

    /** The password of the user. */
    String password = "";

    /** Indicates whether the user is a member of MinerCars or not. */
    Boolean minerCarsMem = false;

    /** The amount of money available to the user. */
    double moneyAvailable = 0.0;

    /** The number of cars purchased by the user. */
    int carsPurchased = 0;


    /**
     * Constructs a new User object with the specified properties.
     *
     * @param id The unique ID of the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param money The amount of money available to the user.
     * @param purchases The number of cars purchased by the user.
     * @param membership Indicates whether the user is a member of MinerCars.
     * @param user The username of the user.
     * @param pass The password of the user.
     */
    public User(int id, String firstName, String lastName, double money, int purchases, boolean membership, String user, String pass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        moneyAvailable = money;
        carsPurchased = purchases;
        minerCarsMem = membership;
        userName = user;
        password = pass;
    }

    /**
     * Gets the ID of the user.
     *
     * @return The ID of the user.
     */
    public int get_ID() {
        return id;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
    public String get_Username() {
        return userName;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String get_password() {
        return password;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name of the user.
     */
    public String get_firstName() {
        return firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name of the user.
     */
    public String get_lastName() {
        return lastName;
    }

    /**
     * Gets the amount of money available to the user.
     *
     * @return The amount of money available.
     */
    public double get_moneyAvailable() {
        return moneyAvailable;
    }

    /**
     * Checks if the user is a member of MinerCars.
     *
     * @return True if the user is a member, false otherwise.
     */
    public boolean has_Membership() {
        return minerCarsMem;
    }

    /**
     * Gets the number of cars purchased by the user.
     *
     * @return The number of cars purchased.
     */
    public int get_carsPurchased() {
        return carsPurchased;
    }

    /**
     * Updates the amount of money available to the user.
     *
     * @param money The new amount of money available.
     */
    public void update_UserMoney(double money) {
        moneyAvailable = money;
    }

    /**
     * Updates the number of cars purchased by the user.
     */
    public void update_CarsPurchased() {
        carsPurchased++;
    }
    /**
     * Updates the number of cars purchased by the user if a car is returned.
     */
    public void update_CarsReturned() {
    	carsPurchased--;
    }
    /**
     * Will make a CSV like string.
     * @return Will return a CSV like string to write into the actual CSV.
     */
    public String infoToCSV() {
    	String csv = String.valueOf(id)+","+firstName+","+lastName+","+userName+","+password+","+String.valueOf(minerCarsMem).toUpperCase()+","+String.valueOf(moneyAvailable)+","+String.valueOf(carsPurchased);
    	return csv;
    }
}
