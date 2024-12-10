package Yearup.pluralsight.db;

import Yearup.pluralsight.models.Actor;
import Yearup.pluralsight.models.Film;
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
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("CPham213");
    }

    public List<Actor> findActorsByName(String firstName, String lastName)
    {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT actor_id, first_name, last_name FROM actor WHERE first_name = ? AND last_name = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            try (ResultSet resultSet = statement.executeQuery())
            {
                while (resultSet.next())
                {
                    actors.add(new Actor(
                            resultSet.getInt("actor_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name")
                    ));
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
        return actors;
    }

    public List<Film> findFilmsByActorId(int actorId)
    {
        List<Film> films = new ArrayList<>();
        String query = "SELECT f.film_id, f.title, f.description, f.release_year, f.length " +
                "FROM film f " +
                "JOIN film_actor fa ON f.film_id = fa.film_id " +
                "WHERE fa.actor_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, actorId);

            try (ResultSet resultSet = statement.executeQuery())
            {
                while (resultSet.next())
                {
                    films.add(new Film(
                            resultSet.getInt("film_id"),
                            resultSet.getString("title"),
                            resultSet.getString("description"),
                            resultSet.getInt("release_year"),
                            resultSet.getInt("length")
                    ));
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Database error: " + e.getMessage());
        }
        return films;
    }
}