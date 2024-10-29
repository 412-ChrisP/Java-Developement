package Yearup.pluralsight;

public class Employee
{
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;

    public Employee(String employeeId, String name, String department, double payRate, int hoursWorked)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public double getPayRate()
    {
        return payRate;
    }

    public void setPayRate(double payRate)
    {
        this.payRate = payRate;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    public double getPunchInTime()
    {
        return punchInTime;
    }

    public void setPunchInTime(double punchInTime)
    {
        this.punchInTime = punchInTime;
    }

    public double getTotalPay()
    {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * (payRate * 1.5);
        return regularPay + overtimePay;
    }

    public double getRegularHours()
    {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours()
    {
        return Math.max(hoursWorked - 40, 0);
    }

    public void punchIn(double time)
    {
        punchInTime = time;
        System.out.println(name + " has punched in at: " + time + ".");
    }

    public void punchOut(double time)
    {
        double hoursWorkedThisShift = time - punchInTime;
        if (hoursWorkedThisShift > 0)
        {
            hoursWorked += hoursWorkedThisShift;
            System.out.println(name + " has punched out at " + time +
                    ". Hours worked this shift: " + hoursWorkedThisShift);
            punchInTime = 0;
        }
        else
        {
            System.out.println("Invalid punch-out time!");
        }
    }

    public void punchTimeCard(double time)
    {
        if (punchInTime == 0)
        {
            punchIn(time);
        }
        else
        {
            punchOut(time);
        }
    }
}
