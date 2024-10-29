package Yearup.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest
{

    private Employee employee;

    @Test
    public void punchIn_StartTimeNotSet_StartTimeSetToGivenTime() {
        // Act
        employee.punchIn(9.0);
        // Assert
        assertEquals(9.0, employee.getPunchInTime(), "Punch-in time should be recorded correctly.");
    }

    @Test
    public void punchOut_HoursNotSet_HoursWorkedSetCorrectly() {
        // Arrange
        employee.punchIn(9.0);
        // Act
        employee.punchOut(17.5);
        // Assert
        assertEquals(8.5, employee.getHoursWorked(), "Hours worked should be calculated correctly.");
    }

    @Test
    public void totalPay_CalculatesCorrectly_WithRegularAndOvertime() {
        // Arrange
        employee.setHoursWorked(45);  // Adding 5 hours of overtime
        // Act
        double totalPay = employee.getTotalPay();
        // Assert
        assertEquals(950.0, totalPay, 0.01, "Total pay should include overtime pay.");
    }

    @Test
    public void regularAndOvertimeHours_CalculatedCorrectly() {
        // Arrange
        employee.setHoursWorked(45);  // 5 hours over regular 40 hours
        // Assert
        assertEquals(40, employee.getRegularHours(), "Regular hours should be capped at 40.");
        assertEquals(5, employee.getOvertimeHours(), "Overtime hours should be correctly calculated.");
    }
}


