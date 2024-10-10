package YearUp.pluralsight;

public class MathApplication
{
    public static void main(String[] args)
    {
// Question 1: Find the highest salary between Bob and Gary
        double bobSalary = 50000;
        double garySalary = 60000;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest salary is: " + highestSalary);

        // Question 2: Find the smallest of two variables carPrice and truckPrice
        double carPrice = 25000;
        double truckPrice = 30000;
        double lowestPrice = Math.min(carPrice, truckPrice);
        System.out.println("The lowest price is: " + lowestPrice);

        // Question 3: Find the area of a circle whose radius is 7.25
        double radius = 7.25;
        double area = 3.14 * Math.pow(radius, 2); // Area = π * r²
        System.out.println("The area of the circle is: " + area);

        // Question 4: Find the square root of a variable set to 5.0
        double number = 5.0;
        double squareRoot = Math.sqrt(number);
        System.out.println("The square root of " + number + " is: " + squareRoot);

        // Question 5: Find the distance between the points (5, 10) and (85, 50)
        int x1 = 5, y1 = 10, x2 = 85, y2 = 50;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("The distance between the points (5, 10) and (85, 50) is: " + distance);

        // Question 6: Find the absolute value of a variable set to -3.8
        double negativeValue = -3.8;
        double absoluteValue = Math.abs(negativeValue);
        System.out.println("The absolute value of " + negativeValue + " is: " + absoluteValue);

        // Question 7: Generate and display a random number between 0 and 1
        double randomNumber = Math.random();
        System.out.println("The random number between 0 and 1 is: " + randomNumber);
    }
}