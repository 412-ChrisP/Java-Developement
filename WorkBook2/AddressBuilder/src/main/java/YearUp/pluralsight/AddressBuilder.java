package YearUp.pluralsight;

import java.util.Scanner;

public class AddressBuilder
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StringBuilder addressInfo = new StringBuilder();

        System.out.print("Full name: ");
        String fullName = scanner.nextLine();
        addressInfo.append(fullName).append("\n");

        System.out.print("Billing Street: ");
        String billingStreet = scanner.nextLine();

        System.out.print("Billing City: ");
        String billingCity = scanner.nextLine();

        System.out.print("Billing State: ");
        String billingState = scanner.nextLine();

        System.out.print("Billing Zip: ");
        String billingZip = scanner.nextLine();

        addressInfo.append("Billing Address:\n");
        addressInfo.append(billingStreet).append("\n");
        addressInfo.append(billingCity).append(", ").append(billingState).append(" ").append(billingZip).append("\n");

        System.out.print("Shipping Street: ");
        String shippingStreet = scanner.nextLine();

        System.out.print("Shipping City: ");
        String shippingCity = scanner.nextLine();

        System.out.print("Shipping State: ");
        String shippingState = scanner.nextLine();

        System.out.print("Shipping Zip: ");
        String shippingZip = scanner.nextLine();

        addressInfo.append("Shipping Address:\n");
        addressInfo.append(shippingStreet).append("\n");
        addressInfo.append(shippingCity).append(", ").append(shippingState).append(" ").append(shippingZip).append("\n");

        System.out.println("\n" + addressInfo.toString());
    }
}
