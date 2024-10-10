package Yearup.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormatDates
{
    public static void main(String[] args)
    {
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(currentDate.format(format1));

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(currentDate.format(format2));

        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(currentDate.format(format3));

        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        System.out.println(gmtTime.format(format4) + " GMT");

        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");
        System.out.println(currentDateTime.format(format5));
    }
}
