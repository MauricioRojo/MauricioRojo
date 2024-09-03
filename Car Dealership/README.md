Description
This was a project done among three people, myself included. Its meant to be a basic replication of how a car dealership can keep track of sales, customers, update inventory, provide refunds,
display all cars in the invetory and other details. 

Features
For inventory, after providing the right credentials, an admin can update the inventory of cars. This includes changing car prices, adding or removing from the inventory, and get sales
demographics depending on new or old cars, or by car type. 
A customer can request for a refund. If there is evidence the user purchased in the Ticket.txt file, then it will allow for a refund. The user will get all their money back and the 
inventory will be updated.
New customers can be added to the system by an admin, where basic information will be needed. 
There is also a memebership in which the user can apply for which will apply a discount to their purchase, If the user doesnt have it it isnt applied.
The user can filter through cars, it can display available new or used cars, depending on the user's choice. 
User information and car inventory is stored inside of CSV files. If a CSV is in a different order or out of order, it will sort the columns for easier access to that information instead
of having to search each column name every time. 

Technical Overview
Admin.java
  This is the Admin class allowed to edit the CSV files with all information in it as well as check Tickets to get total profits. 
AdminTest.java
  A file used to testing that the right values are given depending on what is required.
Car.java
  Is a parent class with all the variables a car will have. It will choose what type of car to create depending on what the parameter type is.
car_data.csv
  Contains the car inventory along with all information about them. The variables are: ID, VIN, price, model, capacity, color, year, fuel type, car availability, condition, transmission,
  car type, hasTurbo
Hatchback.java
  This is a subclass for the Car parent class. This creates an object of type Hatchback.
inventoryManager.java
  This is an interface that will give the Admin the ability to add cars to the inventory, remove cars from inventory, get profits and add new customers. 
Log.java
  This writes every activity going on in the system, from customers and admins logging in, if a purchase was made or a car was returned, if someone logs out, or inventory is changed among others.
  The logs are then written in the the Logs.txt file.
Logs.txt
  Contains the logs of all activites that happen inside of the system that were written by Log.java
Pickup.java
  This is a subclass for the Car parent class. This creates an object of type Pickup.
RunShop.java
  This is the main where everything runs. It asks for a password from a user or an admin. Depending on what is given different menu's will be displayed and different things can be done. 
  
Sedan.java
  This is a subclass for the Car parent class. This creates an object of type Sedan.
SUV.java
  This is a subclass for the Car parent class. This creates an object of type SUV.
Ticket.java
  This will create tickets for all purchased cars, it gets the VIN number, type of car, id of customer, owner first name, owner last name, car id, car model, car color and price.
  Once the string is created it is then written into the Ticket.txt file to be stored.
Ticket.txt
  This stores all written tickets of purchases that were written onto it by Ticket.java
User.java
  This is a class for creating customers, the customers that are only able to look at the inventory, purchase cars and make returns. 
user_data.csv
  Contains every customers information. It contains ID, first name, last name, username, password, MinerCars Membership, money average, cars purchased.
Vehicle.java
  The Vehicle class possess all details about the car that is inside of the csv and create an object with it. 
  It is an abstract class that is used inside of the Car class to create a vehicle of a certain type. 
  
