# Programming-exercise-Vehicle
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class VehicleManagement {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Scanner key = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = key.nextInt();
            key.nextLine(); 

            switch (choice) {
                case 1:
                    addVehicle(vehicleList, key);
                    break;
                case 2:
                    displayVehicleList(vehicleList);
                    break;
                case 3:
                    deleteVehicle(vehicleList, key);
                    break;
                case 4:
                    sortVehicleListByAge(vehicleList);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        key.close();
    }

    private static void addVehicle(ArrayList<Vehicle> vehicleList, Scanner key) {
        System.out.println("Enter vehicle details:");
        System.out.print("Enter Registration Number: ");
        String regNo = key.nextLine();
        System.out.print("Enter Make: ");
        String make = key.nextLine();
        System.out.print("Enter Year of Manufacture: ");
        int yearOfManufacture = key.nextInt();
        System.out.print("Enter Value: ");
        double value = key.nextDouble();
        key.nextLine(); 
        Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
        vehicleList.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private static void displayVehicleList(ArrayList<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to display.");
        } else {
            System.out.println("List of vehicles:");
            for (Vehicle vehicle : vehicleList) {
                System.out.println(vehicle);
            }
        }
    }

    private static void deleteVehicle(ArrayList<Vehicle> vehicleList, Scanner key) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to delete.");
            return;
        }
        System.out.print("Enter the index of the vehicle to delete: ");
        int index = key.nextInt();
        key.nextLine(); 
        if (index < 0 || index >= vehicleList.size()) {
            System.out.println("Invalid index.");
        } else {
            vehicleList.remove(index);
            System.out.println("Vehicle deleted successfully.");
        }
    }

    private static void sortVehicleListByAge(ArrayList<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to sort.");
        } else {
            Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture));
            System.out.println("Vehicle list sorted by age.");
        }
    }
}


class Vehicle {
    private String regNo;
    private String model;
    private int yearOfManufacture;
    private double value;

    public Vehicle(String regNo, String model, int yearOfManufacture, double value) {
        this.regNo = regNo;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.value = value;
    }
    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public int calculateAge(int currentYear) {
        return currentYear - yearOfManufacture;
    }
    
    @Override
    public String toString() {
        return "Registration Number: " + regNo + ", Model: " + model + ", Year of Manufacture: " + yearOfManufacture + ", Value: Php" + value;
    }
}
