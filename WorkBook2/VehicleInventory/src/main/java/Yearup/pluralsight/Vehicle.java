package Yearup.pluralsight;

public class Vehicle
{
    private int vehicleID;
    private String makeModel;
    private String color;
    private int odometerReading;
    private float price;

    public Vehicle(int vehicleID, String makeModel, String color, int odometerReading, float price)
    {
        this.vehicleID = vehicleID;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    public int getVehicleID()
    {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID)
    {
        this.vehicleID = vehicleID;
    }

    public String getMakeModel()
    {
        return makeModel;
    }

    public void setMakeModel(String makeModel)
    {
        this.makeModel = makeModel;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int getOdometerReading()
    {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading)
    {
        this.odometerReading = odometerReading;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }
    public String toString()
    {
        return "Vehicle ID: " + vehicleID +
                "\n Make/Model: " + makeModel +
                "\n Color: " + color +
                "\n Odometer Reading: " + odometerReading +
                "\n Price: $" + price + "\n";
    }
}
