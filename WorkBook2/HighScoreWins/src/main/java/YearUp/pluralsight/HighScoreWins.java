package YearUp.pluralsight;

import java.util.Scanner;

public class HighScoreWins
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a game score (ex. Home:Visitor|21:9): ");
        String input = scanner.nextLine().trim();

        String[] parts = input.split("\\|");

        String[] teams = parts[0].split(":");
        String[] scores = parts[1].split(":");

        String homeTeam = teams[0];
        String visitorTeam = teams[1];

        int homeScore = Integer.parseInt(scores[0]);
        int visitorScore = Integer.parseInt(scores[1]);

        if (homeScore > visitorScore)
        {
            System.out.println("Winner: " + homeTeam);
        } else if (visitorScore > homeScore)
        {
            System.out.println("Winner: " + visitorTeam);
        } else
        {
            System.out.println("It's a tie!");
        }
    }
}
