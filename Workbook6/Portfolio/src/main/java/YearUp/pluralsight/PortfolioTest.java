package YearUp.pluralsight;

import YearUp.pluralsight.finance.*;

public class PortfolioTest
{
    public static void main(String[] args)
    {
        Portfolio portfolio = new Portfolio("Retirement Portfolio", "Alice");

        portfolio.add(new BankAccount("Savings Account", "12345", 5000));
        portfolio.add(new CreditCard("Credit Card", "54321", -2000));
        portfolio.add(new Jewelry("Gold Necklace", 24,1));
        portfolio.add(new House("Chris's House",125000, 2000, 3000, 2));

        System.out.println("Total Portfolio Value: $" + portfolio.getValue());

        Valuable mostValuable = portfolio.getMostValuable();
        Valuable leastValuable = portfolio.getLeastValuable();

        System.out.println("Most Valuable Asset: " + (mostValuable != null ? mostValuable.getValue() : "None"));
        System.out.println("Least Valuable Asset: " + (leastValuable != null ? leastValuable.getValue() : "None"));
    }
}