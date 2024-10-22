package Yearup.pluralsight;

public class Employee
{
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;

    public Employee(String employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay()
    {
        return getRegularHours() * payRate + getOvertimeHours() * (payRate * 1.5);
    }

    public double getRegularHours()
    {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours()
    {
        return Math.max(hoursWorked - 40, 0);
    }

    public void punchInTime(double time)
    {
        punchInTime = time;
        System.out.println(name + "has punched in at: " + time + ".");
    }

    public void punchOut(double time)
    {
        double hourWorkedThisShift = time - punchInTime;
        if(hourWorkedThisShift > 0)
        {
            hoursWorked += hourWorkedThisShift;
            System.out.println(name + " has punched out at " + time +
                    ". Hours worked this shift: " + hourWorkedThisShift);
        }
        else
        {
            System.out.println("Invalid punch out time!");
        }
    }
}
