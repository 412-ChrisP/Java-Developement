package YearUp.pluralsight;

import java.util.Scanner;

public class FullNameParser
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String inputName = scanner.nextLine().trim();

        String[] nameParts = inputName.split("\\s+");

        String firstName = nameParts[0];
        String middleName = "";
        String lastName = "";

        if (nameParts.length == 2)
        {
            lastName = nameParts[1];
            middleName = "(none)";
        } else if (nameParts.length == 3)
        {
            middleName = nameParts[1];
            lastName = nameParts[2];
        }

        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
    }
}