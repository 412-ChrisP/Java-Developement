package YearUp.pluralsight;

import java.util.ArrayList;

public class AssetManager
{
    public static void main(String[] args)
    {
        ArrayList<Asset> myAssets = new ArrayList<>();

        // Adding houses
        myAssets.add(new House("My House", "2015-08-20", 250000, "123 Main St", 1, 2000, 5000));
        myAssets.add(new House("Vacation Home", "2019-06-15", 150000, "456 Beach Ave", 2, 1200, 3000));

        // Adding vehicles
        myAssets.add(new Vehicle("Tom's Truck", "2021-05-12", 30000, "Toyota Tacoma", 2018, 90000));
        myAssets.add(new Vehicle("My Car", "2020-03-10", 25000, "Honda Accord", 2015, 120000));

        for (Asset asset : myAssets)
        {
            String message = "Asset Description: " + asset.getDescription() +
                    "\nDate Acquired: " + asset.getDateAcquired() +
                    "\nOriginal Cost: $" + asset.getOriginalCost() +
                    "\nCurrent Value: $" + asset.getValue();

            if (asset instanceof House)
            {
                House house = (House) asset;
                message += "\nAddress: " + house.getAddress();
            } else if (asset instanceof Vehicle)
            {
                Vehicle vehicle = (Vehicle) asset;
                message += "\nMake/Model: " + vehicle.getYear() + " " + vehicle.getMakeModel();
            }

            System.out.println(message + "\n");
        }
    }
}
