package Yearup.pluralsight;
import java.util.Objects;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        double totalCost, gpsPerDay, tollTagPerDay, roadsideAssistancePerDay;
        double basicCarRental = 29.99;
        double underageDriverSurcharge = 1.30;

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the pickup date: ");
        String date = scanner.nextLine();

        System.out.println("Please enter the number of days: ");
        int days = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Do you want an electronic toll tag at 3.95/day? (yes/no)");
        String electronicTag = scanner.nextLine();

        if(Objects.equals(electronicTag, "yes"))
        {
            tollTagPerDay = 3.95;
        }
        else
        {
            tollTagPerDay = 0;
        }

        System.out.println("Do you want a GPS at 2.95/day? (yes/no) ");
        String GPS = scanner.nextLine();

        if(Objects.equals(GPS, "yes"))
        {
            gpsPerDay = 2.95;
        }
        else
        {
            gpsPerDay = 0;
        }

        System.out.println("Do you want roadside assistance at 3.95/day? (yes/no)");
        String roadsideAssistance = scanner.nextLine();

        if(Objects.equals(roadsideAssistance, "yes"))
        {
            roadsideAssistancePerDay = 3.95;
        }
        else
        {
            roadsideAssistancePerDay = 0;
        }

        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();

       if(age <= 24)
       {
           totalCost = (basicCarRental * underageDriverSurcharge * days) + (gpsPerDay * days) + (tollTagPerDay * days) + (roadsideAssistancePerDay * days);
       }
       else
       {
           totalCost = (basicCarRental * days) + (gpsPerDay * days) + (tollTagPerDay * days) + (roadsideAssistancePerDay * days);
       }
       System.out.printf("Basic car rental cost is: $%.2f%n", (basicCarRental * days));
       System.out.printf("Total optional cost is: $%.2f%n", ((gpsPerDay * days) + (tollTagPerDay * days) + (roadsideAssistancePerDay * days)));
       System.out.printf("Underage driver surcharge: $%.2f%n", ((basicCarRental * underageDriverSurcharge * days) - (basicCarRental * days)));
       System.out.printf("Total cost is: $%.2f%n" , totalCost);
       scanner.close();
    }
}