package YearUp.pluralsight;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class TheaterReservations
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine();

        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];

        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String dateInput = scanner.nextLine();

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        System.out.print("How many tickets would you like? ");
        int numberOfTickets = scanner.nextInt();

        String ticketText = numberOfTickets == 1 ? "ticket" : "tickets";

        System.out.printf("%d %s reserved for %s under %s, %s%n",
                numberOfTickets, ticketText, outputFormatter, lastName, firstName);
    }
}