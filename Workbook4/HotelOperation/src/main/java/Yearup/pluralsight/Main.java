package Yearup.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        Room room = new Room(2, 100.00,false,false);

        room.checkIn();
        System.out.println("Room is occupied: " + room.isOccupied());
        System.out.println("Room is dirty: " + room.isDirty());

        room.checkout();
        System.out.println("Room is occupied: " + room.isOccupied());
        room.cleanRoom();
        System.out.println("Room is dirty: " + room.isDirty());

        Employee employee = new Employee("1", "John Doe", "Housekeeping", 15.00, 0); // Added 'hoursWorked' param as 0
        employee.punchIn(9.0);

        employee.punchOut(17.5);
        System.out.println("Hours worked: " + employee.getHoursWorked());
        System.out.println("Total pay: " + employee.getTotalPay());
        System.out.println("Regular hours: " + employee.getRegularHours());
        System.out.println("Overtime hours: " + employee.getOvertimeHours());

        employee.punchTimeCard(9.0);
        employee.punchTimeCard(18.0);
        System.out.println("Hours worked: " + employee.getHoursWorked());
        System.out.println("Total pay: " + employee.getTotalPay());
        System.out.println("Regular hours: " + employee.getRegularHours());
        System.out.println("Overtime hours: " + employee.getOvertimeHours());
    }
}