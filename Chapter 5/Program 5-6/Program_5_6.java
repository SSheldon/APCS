public class Program_5_6
{
    private Program_5_6() { }
    
    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        SavingsAccount.modifyInterestRate(.04);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Saver 1 balance: " + saver1.getSavingsBalance());        
        System.out.println("Saver 2 balance: " + saver2.getSavingsBalance());
        SavingsAccount.modifyInterestRate(.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Saver 1 balance: " + saver1.getSavingsBalance());        
        System.out.println("Saver 2 balance: " + saver2.getSavingsBalance());
    }
}
