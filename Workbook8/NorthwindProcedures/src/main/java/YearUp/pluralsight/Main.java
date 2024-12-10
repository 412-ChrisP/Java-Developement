package YearUp.pluralsight;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DataManager dataManager = new DataManager();

        boolean running = true;

        while (running)
        {
            System.out.println("\nNorthwind Procedures");
            System.out.println("    1) Search for Customer Order History");
            System.out.println("    2) Search for Sales by Year");
            System.out.println("    3) Search for Sales by Category");
            System.out.println("    0) Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.next();
                    dataManager.getCustomerOrderHistory(customerId);
                    break;
                case 2:
                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = scanner.next();
                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    String endDate = scanner.next();
                    dataManager.getSalesByYear(startDate, endDate);
                    break;
                case 3:
                    System.out.print("Enter Category Name: ");
                    scanner.nextLine();
                    String categoryName = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();
                    dataManager.getSalesByCategory(categoryName, year);
                    break;
                case 0:
                    running = false;
                    System.out.print("GOODBYE!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}