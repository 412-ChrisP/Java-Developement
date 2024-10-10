package Yearup.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger
{
    private static final String LOG_FILE = "logs.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args)
    {
        logAction("launch");

        Scanner scanner = new Scanner(System.in);
        String searchTerm;

        while (true)
        {
            System.out.print("Enter a search term (X to exit): ");
            searchTerm = scanner.nextLine();

            if (searchTerm.equalsIgnoreCase("X")) {
                logAction("exit");
                System.out.println("Exiting application...");
                break;
            }
            else
            {
                logAction("search : " + searchTerm);
                System.out.println("Searching for: " + searchTerm);
            }
        }

        scanner.close();
    }

    private static void logAction(String action)
    {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(FORMATTER);
        String logEntry = timestamp + " " + action;

        try (FileWriter writer = new FileWriter(LOG_FILE, true))
        {
            writer.write(logEntry + System.lineSeparator());
        } catch (IOException e)
        {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
