package Yearup.pluralsight;

public class Car
{
    private int numberOfDoors;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean openTrunk()
    {
        return false;
    }

    public boolean closeTrunk()
    {
        return false;
    }
}
