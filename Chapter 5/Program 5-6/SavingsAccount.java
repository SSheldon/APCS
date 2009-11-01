public class SavingsAccount
{
    private static double annualInterestRate = .04;
    
    public static void modifyInterestRate(double annualInterestRate)
    {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }
    
    private double savingsBalance;
    
    public SavingsAccount(double savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    }
    
    public void calculateMonthlyInterest()
    {
        savingsBalance += savingsBalance *
            (SavingsAccount.annualInterestRate / 12.0);
    }
    
    public double getSavingsBalance()
    {
        return savingsBalance;
    }
}
