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