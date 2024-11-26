package YearUp.pluralsight;

import java.sql.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "CPham213";
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("What do you want to do?");
            System.out.println("    1) Display all products");
            System.out.println("    2) Display all customers");
            System.out.println("    0) Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 0)
            {
                break;
            }

            try (Connection connection = DriverManager.getConnection(url, username, password))
            {
                if (choice == 1)
                {
                    String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products";
                    try (Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(query))
                    {
                        System.out.printf("%-5s %-35s %-15s %-10s\n", "Id", "Name", "Price", "Stock");
                        System.out.printf("%-5s %-35s %-15s %-10s\n", "----", "---------------------", "----------", "------");

                        while (resultSet.next())
                        {
                            int productId = resultSet.getInt("ProductID");
                            String productName = resultSet.getString("ProductName");
                            double unitPrice = resultSet.getDouble("UnitPrice");
                            int unitsInStock = resultSet.getInt("UnitsInStock");

                            System.out.printf("%-5d %-35s %7.2f %12d\n", productId, productName, unitPrice, unitsInStock);
                        }
                    }
                }
                else if (choice == 2)
                {
                    String query = "SELECT ContactName, CompanyName, City, Country, Phone FROM Customers ORDER BY Country";
                    try (Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(query))
                    {
                        System.out.printf("%-25s %-35s %-20s %-20s %-15s\n", "Contact Name", "Company Name", "City", "Country", "Phone");
                        System.out.printf("%-25s %-35s %-20s %-20s %-15s\n", "-------------------------", "-----------------------------------", "--------------------", "--------------------", "---------------");

                        while (resultSet.next())
                        {
                            String contactName = resultSet.getString("ContactName");
                            String companyName = resultSet.getString("CompanyName");
                            String city = resultSet.getString("City");
                            String country = resultSet.getString("Country");
                            String phone = resultSet.getString("Phone");

                            System.out.printf("%-25s %-35s %-20s %-20s %-15s\n", contactName, companyName, city, country, phone);
                        }
                    }
                }
                else
                {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            catch (SQLException e)
            {
                System.err.println("Database error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}