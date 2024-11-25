package YearUp.pluralsight;

import java.sql.*;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "CPham213";

        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

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