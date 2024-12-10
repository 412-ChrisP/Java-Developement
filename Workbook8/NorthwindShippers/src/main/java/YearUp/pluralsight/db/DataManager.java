package YearUp.pluralsight.db;

import YearUp.pluralsight.models.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    // Insert new shipper
    public int addShipper(String companyName, String phone)
    {
        String query = "INSERT INTO Shippers (CompanyName, Phone) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            statement.setString(1, companyName);
            statement.setString(2, phone);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0)
            {
                try (ResultSet generatedKeys = statement.getGeneratedKeys())
                {
                    if (generatedKeys.next())
                    {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
        return -1;
    }

    public List<Shipper> getAllShippers()
    {
        List<Shipper> shippers = new ArrayList<>();
        String query = "SELECT ShipperID, CompanyName, Phone FROM Shippers";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query))
        {
            while (resultSet.next())
            {
                shippers.add(new Shipper(
                        resultSet.getInt("ShipperID"),
                        resultSet.getString("CompanyName"),
                        resultSet.getString("Phone")
                ));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
        return shippers;
    }

    public boolean updateShipperPhone(int shipperId, String phone)
    {
        String query = "UPDATE Shippers SET Phone = ? WHERE ShipperID = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, phone);
            statement.setInt(2, shipperId);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteShipper(int shipperId)
    {
        String query = "DELETE FROM Shippers WHERE ShipperID = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, shipperId);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
        return false;
    }
}
