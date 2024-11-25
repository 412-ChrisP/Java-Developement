package YearUp.pluralsight;

import java.sql.*;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "CPham213";

        String query = "SELECT ProductName FROM Products";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("Products:");

        while (resultSet.next())
        {
            System.out.println(resultSet.getString("ProductName"));
        }

    }
}