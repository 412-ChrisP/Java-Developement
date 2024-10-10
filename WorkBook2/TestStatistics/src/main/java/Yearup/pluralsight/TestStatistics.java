package Yearup.pluralsight;
import java.util.Scanner;

public class TestStatistics
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double[] scores = new double[10];

        System.out.println("Please enter the Test Scores: ");
        for(int i = 0; i < scores.length; i++)
        {
            System.out.println("Score " + (i + 1) + ":");
            scores[i] = scanner.nextDouble();
        }

        calcAverage(scores);
        calcHighScore(scores);
        calcLowScore(scores);

        scanner.close();
    }

    private static void calcAverage(double[] scores)
    {
        double total = 0;
        double average = 0;
        for(int i = 0; i < scores.length; i++)
        {
            total += scores[i];
        }
        average = total/scores.length;
        System.out.printf("Average: %.2f%n", average);
    }

    private static void calcHighScore(double[] scores)
    {
        double highScore = scores[0];
        for(int i = 0; i < scores.length; i++)
        {
            if(scores[i] > highScore)
            {
                highScore = scores[i];
            }
        }
        System.out.printf("High Score: %.2f%n", highScore);
    }

    private static void calcLowScore(double[] scores)
    {
        double lowScore = scores[0];
        for(int i = 0; i < scores.length; i++)
        {
            if(scores[i] < lowScore)
            {
                lowScore = scores[i];
            }
        }
        System.out.printf("Low Score: %.2f%n" + lowScore);
    }
}