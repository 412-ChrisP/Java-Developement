package YearUp.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        CellPhone phone1 = new CellPhone();
        CellPhone phone2 = new CellPhone();

        System.out.print("Please enter the details for the first phone.\n");

        System.out.print("What is the serial number? ");
        int serialNumber1 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("What model is the phone? ");
        String model1 = scanner.nextLine();

        System.out.print("Who is the carrier? ");
        String carrier1 = scanner.nextLine();

        System.out.print("What is the phone number? ");
        String phoneNumber1 = scanner.nextLine();

        System.out.print("Who is the owner of the phone? ");
        String owner1 = scanner.nextLine();

        phone1.setSerialNumber(serialNumber1);
        phone1.setModel(model1);
        phone1.setCarrier(carrier1);
        phone1.setPhoneNumber(phoneNumber1);
        phone1.setOwner(owner1);

        System.out.print("\nEnter the details for the second phone.\n");

        System.out.print("What is the serial number? ");
        int serialNumber2 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("What model is the phone? ");
        String model2 = scanner.nextLine();

        System.out.print("Who is the carrier? ");
        String carrier2 = scanner.nextLine();

        System.out.print("What is the phone number? ");
        String phoneNumber2 = scanner.nextLine();

        System.out.print("Who is the owner of the phone? ");
        String owner2 = scanner.nextLine();

        phone2.setSerialNumber(serialNumber2);
        phone2.setModel(model2);
        phone2.setCarrier(carrier2);
        phone2.setPhoneNumber(phoneNumber2);
        phone2.setOwner(owner2);

        System.out.println("\nPhone Information:");
        CellPhone.display(phone1);
        CellPhone.display(phone2);

        System.out.println("\nDialing:");

        phone1.dial(phone2.getPhoneNumber());
        phone2.dial(phone1.getPhoneNumber());

        phone1.dial("855-555-2222");
        phone1.dial(phone2);
    }


}