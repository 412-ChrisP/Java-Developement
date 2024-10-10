package Yearup.pluralsight;

public class ListVehicles
{
    public void list(Vehicle[] Vehicle, int vehicleCounter)
    {
        System.out.println("List of Vehicles: \n");
        for(int i = 0; i < vehicleCounter; i++)
        {
            System.out.println(Vehicle[i]);
        }
    }
}