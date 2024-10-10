package YearUp.pluralsight;

import java.util.Scanner;

public class FullNameApplication
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for parts of their name
        System.out.println("Please enter your name");

        System.out.print("First name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Middle name: ");
        String middleName = scanner.nextLine().trim();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Suffix: ");
        String suffix = scanner.nextLine().trim();

        // Construct the full name
        StringBuilder fullName = new StringBuilder(firstName);

        if (!middleName.isEmpty())
        {
            fullName.append(" ").append(middleName);
        }

        fullName.append(" ").append(lastName);

        if (!suffix.isEmpty())
        {
            fullName.append(", ").append(suffix);
        }

        System.out.println("\nFull name: " + fullName.toString());
    }
}
