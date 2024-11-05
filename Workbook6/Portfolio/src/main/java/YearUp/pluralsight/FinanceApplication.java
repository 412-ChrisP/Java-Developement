package YearUp.pluralsight;

import YearUp.pluralsight.finance.BankAccount;
import YearUp.pluralsight.finance.Valuable;

public class FinanceApplication
{
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount("123", "Pam", 12500);
        Valuable account2 = new BankAccount("456", "Gary", 1500);

        account1.deposit(100);

    }
}