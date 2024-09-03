/**
 * Represents a customer in the system.
 */
public class Customer {
    int customerID = 0;
    String firstName = "";
    String lastName = "";
    String address = "";
    String email = "";
    String phonenumber = "";

    /**
     * Constructs an empty Customer object.
     */
    public Customer() {}

    /**
     * Constructs a Customer object with the specified parameters.
     *
     * @param ID       The unique identifier of the customer.
     * @param first    The first name of the customer.
     * @param last     The last name of the customer.
     * @param a        The address of the customer.
     * @param e        The email of the customer.
     * @param p        The phone number of the customer.
     */
    public Customer(int ID, String first, String last, String a, String e, String p) {
        customerID = ID;
        firstName = first;
        lastName = last;
        address = a;
        email = e;
        phonenumber = p;
    }

    /**
     * Retrieves the ID of the customer.
     *
     * @return The ID of the customer.
     */
    public int get_id() {
        return customerID;
    }

    /**
     * Retrieves the first name of the customer.
     *
     * @return The first name of the customer.
     */
    public String get_firstName() {
        return firstName;
    }

    /**
     * Retrieves the last name of the customer.
     *
     * @return The last name of the customer.
     */
    public String get_lastName() {
        return lastName;
    }

    /**
     * Retrieves the address of the customer.
     *
     * @return The address of the customer.
     */
    public String get_address() {
        return address;
    }

    /**
     * Retrieves the email of the customer.
     *
     * @return The email of the customer.
     */
    public String get_email() {
        return email;
    }

    /**
     * Retrieves the phone number of the customer.
     *
     * @return The phone number of the customer.
     */
    public String get_phonenumber() {
        return phonenumber;
    }
}
