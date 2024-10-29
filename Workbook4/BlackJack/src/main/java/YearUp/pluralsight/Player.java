package YearUp.pluralsight;

public class Player
{
    private String name;
    private Hand hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName()
    {
        return name;
    }

    public Hand getHand()
    {
        return hand;
    }

    public int getHandValue()
    {
        return hand.getValue();
    }

    public void dealCard(Card card)
    {
        hand.deal(card);
    }

    public void printHand()
    {
        System.out.println(name + "'s hand:");
        hand.print();
    }
}
