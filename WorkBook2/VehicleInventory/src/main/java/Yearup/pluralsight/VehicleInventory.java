package Yearup.pluralsight;
import java.util.Scanner;

public class VehicleInventory
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Vehicle[] vehicleInfo = new Vehicle[20];
        int vehicleCount = 0;
        vehicleInfo[vehicleCount++] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicleInfo[vehicleCount++] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicleInfo[vehicleCount++] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicleInfo[vehicleCount++] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicleInfo[vehicleCount++] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicleInfo[vehicleCount++] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        int userChoice;
        do {
            System.out.println("What do you want to do?\n" +
                    "1 - List all vehicles\n" +
                    "2 - Search by make/model\n" +
                    "3 - Search by price range\n" +
                    "4 - Search by color\n" +
                    "5 - Add a vehicle\n" +
                    "6 - Quit\n" +
                    "Enter your command:");

            userChoice = scanner.nextInt();

            switch(userChoice)
            {
                case 1:
                    ListVehicles listVehicles = new ListVehicles();
                    listVehicles.list(vehicleInfo, vehicleCount);
                    break;
                case 2:
                    SearchMakeModel searchMakeModel = new SearchMakeModel();
                    searchMakeModel.searchMM(vehicleInfo, vehicleCount);
                    break;
                case 3:
                    new SearchPriceRange();
                    break;
                case 4:
                    new SearchColor();
                    break;
                case 5:
                    new AddVehicle();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid Input. Please enter 1-6");
            }
        } while (userChoice != 6);
        scanner.close();
    }
}