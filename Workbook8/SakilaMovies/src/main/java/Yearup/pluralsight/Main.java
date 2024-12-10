package Yearup.pluralsight;

import java.util.List;
import java.util.Scanner;
import Yearup.pluralsight.db.DataManager;
import Yearup.pluralsight.models.Actor;
import Yearup.pluralsight.models.Film;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DataManager dataManager = new DataManager();

        System.out.print("\nEnter the first name of the actor: ");
        String firstName = scanner.nextLine();

        System.out.print("\nEnter the last name of the actor: ");
        String lastName = scanner.nextLine();

        List<Actor> actors = dataManager.findActorsByName(firstName, lastName);
        if (actors.isEmpty())
        {
            System.out.println("No actors found with the name: " + firstName + " " + lastName);
        }
        else
        {
            System.out.println("\nFound Actors:");
            for (Actor actor : actors)
            {
                System.out.println(actor);
            }

            System.out.print("\nEnter the actor ID to see their movies: ");
            int actorId = scanner.nextInt();

            List<Film> films = dataManager.findFilmsByActorId(actorId);
            if (films.isEmpty())
            {
                System.out.println("No movies found for the selected actor.");
            }
            else
            {
                System.out.println("\nMovies featuring the actor:");
                for (Film film : films)
                {
                    System.out.println(film);
                }
            }
        }
        scanner.close();
    }
}