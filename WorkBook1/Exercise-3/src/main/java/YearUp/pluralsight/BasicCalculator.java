package YearUp.pluralsight;

import java.util.Scanner;

public class BasicCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNumber = scanner.nextDouble();

        System.out.println("\nPossible calculations:");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultiply");
        System.out.println("(D)ivide");

        System.out.print("Please select an option: ");
        char operation = scanner.next().charAt(0);

        double result;
        switch (operation)
        {
            case 'A':
                result = firstNumber + secondNumber;
                System.out.printf("%.2f + %.2f = %.2f\n", firstNumber, secondNumber, result);
                break;
            case 'S':
                result = firstNumber - secondNumber;
                System.out.printf("%.2f - %.2f = %.2f\n", firstNumber, secondNumber, result);
                break;
            case 'M':
                result = firstNumber * secondNumber;
                System.out.printf("%.2f * %.2f = %.2f\n", firstNumber, secondNumber, result);
                break;
            case 'D':
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                    System.out.printf("%.2f / %.2f = %.2f\n", firstNumber, secondNumber, result);
                } else
                {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid option selected. Please try again.");
                break;
        }
    }
}
