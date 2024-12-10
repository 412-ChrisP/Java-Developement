package YearUp.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManager
{
    private final BasicDataSource dataSource;

    public DataManager()
    {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("CPham213");
    }

    public void getCustomerOrderHistory(String customerId)
    {
        String procedure = "{CALL CustOrderHistory(?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(procedure))
        {
            callableStatement.setString(1, customerId);
            try (ResultSet resultSet = callableStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    System.out.println("\nCustomer Order History:");
                    do
                    {
                        String productName = resultSet.getString("ProductName");
                        int total = resultSet.getInt("Total");
                        System.out.printf("%-30s %d%n", productName, total);
                    } while (resultSet.next());
                }
                else
                {
                    System.out.println("No order history found for customer ID: " + customerId);
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public void getSalesByYear(String startDate, String endDate)
    {
        String procedure = "{CALL `Sales by Year`(?, ?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(procedure))
        {
            callableStatement.setString(1, startDate);
            callableStatement.setString(2, endDate);
            try (ResultSet resultSet = callableStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    System.out.println("\nSales by Year:");
                    do
                    {
                        String year = resultSet.getString("Year");
                        double sales = resultSet.getDouble("Sales");
                        System.out.printf("%-10s %.2f%n", year, sales);
                    } while (resultSet.next());
                }
                else
                {
                    System.out.println("No sales data found for the given date range.");
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public void getSalesByCategory(String categoryName, int year)
    {
        String procedure = "{CALL SalesByCategory(?, ?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(procedure))
        {
            callableStatement.setString(1, categoryName);
            callableStatement.setInt(2, year);
            try (ResultSet resultSet = callableStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    System.out.println("\nSales by Category:");
                    do
                    {
                        String productName = resultSet.getString("ProductName");
                        double totalSales = resultSet.getDouble("TotalSales");
                        System.out.printf("%-30s %.2f%n", productName, totalSales);
                    } while (resultSet.next());
                }
                else
                {
                    System.out.println("No sales data found for category: " + categoryName + " in year: " + year);
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}