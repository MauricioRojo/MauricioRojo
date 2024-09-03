/**
 * Represents a ticket for a car purchase.
 */
public class Ticket {
    private Vehicle car;

    /**
     * Constructs a Ticket object for the specified car.
     *
     * @param car2 The car for which the ticket is created.
     */
    public Ticket(Vehicle car2) {
        this.car = car2;
    }

    /**
     * Prints the details of the ticket.
     */
    public void printTicket() {
        System.out.println("--------- Ticket ---------");
        System.out.println("Car: " + car.get_Model());
        System.out.println("VIN: " + car.get_VIN());
        System.out.println("Price: $" + car.get_Price());
        System.out.println("--------- End Ticket ---------");
    }
}
