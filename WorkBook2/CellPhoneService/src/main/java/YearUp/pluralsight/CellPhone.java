package YearUp.pluralsight;

public class CellPhone
{
    private int serialNumber;
    private String model;
    private String carrier;
    private String phoneNumber;
    private String owner;

    public CellPhone()
    {
        this.serialNumber = 0;
        this.model = "";
        this.carrier = "";
        this.phoneNumber = "";
        this.owner = "";
    }

    public void setSerialNumber(int serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setCarrier(String carrier)
    {
        this.carrier = carrier;
    }

    public int getSerialNumber()
    {
        return serialNumber;
    }

    public String getModel()
    {
        return model;
    }

    public String getCarrier()
    {
        return carrier;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getOwner()
    {
        return owner;
    }

    public void dial(String phoneNumber)
    {
        System.out.println(owner + "'s phone is calling " + phoneNumber);
    }

    public void dial(CellPhone phone)
    {
        System.out.println(owner + "'s phone is calling " + phone.getPhoneNumber());
    }

    public static void display(CellPhone phone)
    {
        System.out.println("\nOwner: " + phone.getOwner());
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
    }
}