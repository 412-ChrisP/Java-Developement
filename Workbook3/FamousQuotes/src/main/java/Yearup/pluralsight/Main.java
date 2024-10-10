package YearUp.pluralsight;

import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {

        String[] quotes = {"The only limit to our realization of tomorrow is our doubts of today.",
        "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "It is during our darkest moments that we must focus to see the light.",
                "The best way to predict your future is to create it.",
                "Don’t watch the clock; do what it does. Keep going.",
                "Believe you can and you're halfway there.",
                "Start where you are. Use what you have. Do what you can.",
                "The journey of a thousand miles begins with one step.",
                "You miss 100% of the shots you don’t take.",
                "What lies behind us and what lies before us are tiny matters compared to what lies within us."};

        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        Random random = new Random();

        while (continueLoop)
        {
            try
            {
                System.out.println("1. Enter a number between 1-10 to display a specific quote.");
                System.out.println("2. Enter 'R' to display a random quote.");
                System.out.print("Your choice: ");

                String input = scanner.next();

                if (input.equalsIgnoreCase("R"))
                {
                    int randomIndex = random.nextInt(quotes.length);
                    System.out.println(quotes[randomIndex]);
                } else {
                    int index = Integer.parseInt(input);
                    System.out.println(quotes[index - 1]);
                }

                System.out.print("Do you want to see another quote? (Y/N): ");
                String answer = scanner.next();

                if (answer.equalsIgnoreCase("N"))
                {
                    continueLoop = false;
                }
            } catch (Exception exception)
            {
                System.out.println("Invalid input. Please enter a number between 1 and 10 or 'R' for a random quote.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}