package YearUp.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++)
        {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }

        Deck deck = new Deck();
        deck.shuffle();

        for (Player player : players)
        {
            player.dealCard(deck.deal());
            player.dealCard(deck.deal());
            player.printHand();
        }

        Player winner = null;
        int highestValue = 0;

        for (Player player : players)
        {
            int handValue = player.getHandValue();
            if (handValue <= 21 && handValue > highestValue)
            {
                highestValue = handValue;
                winner = player;
            }
        }

        if (winner != null)
        {
            System.out.println("The winner is " + winner.getName() + " with a hand value of " + highestValue + "!");
        }
        else
        {
            System.out.println("No winners! Everyone went over 21.");
        }
        scanner.close();
    }
}