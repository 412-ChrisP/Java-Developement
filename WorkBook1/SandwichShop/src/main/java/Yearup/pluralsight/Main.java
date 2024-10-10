package Yearup.pluralsight;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        double regularSize = 5.45;
        double largeSize = 8.95;
        double studentDiscount = 0.10;
        double seniorDiscount = 0.20;
        double finalPrice;

        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter the size of the sandwich (1 for regular, 2 for large): ");
        int size = scanner.nextInt();

        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();

        if (age <= 17 && size == 1)
        {
            finalPrice = regularSize * (1 - studentDiscount);
        }
        else if (age <= 17 && size == 2)
        {
            finalPrice = largeSize * (1 - studentDiscount);
        }
        else if (age >= 65 && size == 1)
        {
            finalPrice = regularSize * (1 - seniorDiscount);
        }
        else if (age >= 65 && size == 2)
        {
            finalPrice = largeSize * (1 - seniorDiscount);
        }
        else if (size == 1)
        {
            finalPrice = regularSize;
        }
        else if (size == 2)
        {
            finalPrice = largeSize;
        }
        else
        {
            System.out.println("Invalid size selection.");
            return;
        }
        System.out.printf("The cost of your sandwich is: $%.2f%n", finalPrice);
        scanner.close();
    }
}
