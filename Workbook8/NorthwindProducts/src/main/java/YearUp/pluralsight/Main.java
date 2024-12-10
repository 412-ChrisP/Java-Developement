package YearUp.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;
import java.util.Scanner;

public class Main
{
    private static final String URL = "jdbc:mysql://localhost:3306/northwind";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "CPham213";

    private static final BasicDataSource dataSource;

    static
    {
        dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("What do you want to do?");
            System.out.println("    1) Display all products");
            System.out.println("    2) Display all customers");
            System.out.println("    3) Display all categories");
            System.out.println("    0) Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 0)
            {
                break;
            }
            try (Connection connection = dataSource.getConnection())
            {
                if (choice == 1)
                {
                    displayAllProducts(connection);
                }
                else if (choice == 2)
                {
                    displayAllCustomers(connection);
                }
                else if (choice == 3)
                {
                    displayCategoriesAndProducts(connection, scanner);
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

    private static void displayAllProducts(Connection connection) throws SQLException
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

    private static void displayAllCustomers(Connection connection) throws SQLException
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

    private static void displayCategoriesAndProducts(Connection connection, Scanner scanner) throws SQLException
    {
        String query = "SELECT CategoryID, CategoryName FROM Categories ORDER BY CategoryID";
        try (Statement statement = connection.createStatement();
             ResultSet categoryResultSet = statement.executeQuery(query))
        {
            System.out.printf("%-5s %-30s\n", "Id", "Category Name");
            System.out.printf("%-5s %-30s\n", "----", "------------------------------");

            while (categoryResultSet.next())
            {
                int categoryId = categoryResultSet.getInt("CategoryID");
                String categoryName = categoryResultSet.getString("CategoryName");
                System.out.printf("%-5d %-30s\n", categoryId, categoryName);
            }
        }

        System.out.print("\nEnter a category ID to view products in that category: ");
        int categoryId = scanner.nextInt();

        String categoryQuery = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products WHERE CategoryID = ? ORDER BY ProductID";
        try (PreparedStatement preparedStatement = connection.prepareStatement(categoryQuery))
        {
            preparedStatement.setInt(1, categoryId);
            try (ResultSet productResultSet = preparedStatement.executeQuery())
            {
                System.out.printf("%-5s %-35s %-15s %-10s\n", "Id", "Name", "Price", "Stock");
                System.out.printf("%-5s %-35s %-15s %-10s\n", "----", "---------------------", "----------", "------");

                boolean hasResults = false;
                while (productResultSet.next())
                {
                    hasResults = true;
                    int productId = productResultSet.getInt("ProductID");
                    String productName = productResultSet.getString("ProductName");
                    double unitPrice = productResultSet.getDouble("UnitPrice");
                    int unitsInStock = productResultSet.getInt("UnitsInStock");

                    System.out.printf("%-5d %-35s %7.2f %12d\n", productId, productName, unitPrice, unitsInStock);
                }

                if (!hasResults)
                {
                    System.out.println("No products found for this category.");
                }
            }
        }
    }
}
