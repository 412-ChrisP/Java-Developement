package Yearup.pluralsight;

public class Reservation
{
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend)
    {
        setRoomType(roomType);
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType()
    {
        return roomType;
    }

    public void setRoomType(String roomType)
    {
        this.roomType = roomType;

        if ("king".equalsIgnoreCase(roomType))
        {
            price = 139.00;
        }
        else if ("double".equalsIgnoreCase(roomType))
        {
            price = 124.00;
        }

        if (isWeekend)
        {
            price *= 1.10;
        }
    }

    public double getPrice()
    {
        return price;
    }

    public int getNumberOfNights()
    {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights)
    {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend()
    {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend)
    {
        this.isWeekend = isWeekend;
        setRoomType(this.roomType);
    }

    public double getReservationTotal()
    {
        return price * numberOfNights;
    }
}
