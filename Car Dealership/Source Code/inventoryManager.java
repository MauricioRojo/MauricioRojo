/**
 * Will help the admin manage the car inventory and the user database
 */
public interface inventoryManager {
	/**
	 * Will help the Admin add a new car to the inventory
	 * 
	 * @param  number An int that represent the amount of rows in a CSV file.
	 */
	void addCar(int number);
	/**
	 * Will help the Admin remove a car from the inventory
	 * 
	 * @param  inventory The list of cars in the inventory
	 */
	void remCar(Vehicle[] inventory);
	/**
	 * Will help the Admin add a new user to the inventory
	 * 
	 * @param  number An int that represent the amount of rows in a CSV file.
	 */
	void addNewUser(int number);
	/**
	 * Will help the Admin get profits depending on the filter given.
	 * 
	 * @param  index An int that where an item is found in a text file.
	 * @param filter A string which represents what the Admin wants profits of.
	 */
	void getProfits(int index, String filter);

}
