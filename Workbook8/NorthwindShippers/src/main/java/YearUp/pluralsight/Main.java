package YearUp.pluralsight;

import YearUp.pluralsight.db.DataManager;
import YearUp.pluralsight.models.Shipper;

import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DataManager dataManager = new DataManager();

        System.out.println("Enter new shipper details:");
        System.out.print("Company Name: ");
        String companyName = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        int newShipperId = dataManager.addShipper(companyName, phone);
        if (newShipperId != -1)
        {
            System.out.println("New shipper added with ID: " + newShipperId);
        }
        else
        {
            System.out.println("Failed to add new shipper.");
        }

        System.out.println("\nAll shippers:");
        List<Shipper> shippers = dataManager.getAllShippers();
        shippers.forEach(System.out::println);

        System.out.print("\nEnter the ID of the shipper to update phone number: ");
        int shipperIdToUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String newPhone = scanner.nextLine();

        boolean updated = dataManager.updateShipperPhone(shipperIdToUpdate, newPhone);
        if(updated)
        {
            System.out.println("Shipper phone number updated.");
        }
        else
        {
            System.out.println("Failed to update shipper.");
        }

        System.out.println("\nAll shippers after update:");
        shippers = dataManager.getAllShippers();
        shippers.forEach(System.out::println);

        System.out.print("\nEnter the ID of the shipper to delete: ");
        int shipperIdToDelete = scanner.nextInt();

        boolean deleted = dataManager.deleteShipper(shipperIdToDelete);
        if(deleted)
        {
            System.out.println("Shipper deleted.");
        }
        else
        {
            System.out.println("Failed to delete shipper.");
        }

        System.out.println("\nAll shippers after deletion:");
        shippers = dataManager.getAllShippers();
        shippers.forEach(System.out::println);

        scanner.close();
    }
}