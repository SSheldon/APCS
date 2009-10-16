import java.util.Scanner;

public class CrapsGame
{
    private int bankroll;
    private Dice dice;
    private Scanner scanner;
    
    public CrapsGame()
    {
        scanner = new Scanner(System.in);
        dice = new Dice();
    }
    
    private void Initialize()
    {
        System.out.print("Enter your bankroll: $");
        bankroll = scanner.nextInt();
    }
    
    public void Run()
    {
        Initialize();        
        while (bankroll > 0)
        {
            int bet;
            do
            {
                System.out.print("Enter your bet ($0 to quit): $");
                bet = scanner.nextInt();
            } while (bet > bankroll || bet < 0);
            if (bet == 0) break;
            if (RunRound()) WinRound(bet);
            else LoseRound(bet);
            System.out.println("Your current bankroll is $" + bankroll);
        }
        System.out.println("Thanks for playing! You finished with $" + bankroll);
    }
    
    private boolean RunRound()
    {
        int point = Roll();
        if (point == 7 || point == 11) return true;
        else if (point == 2 || point == 3 || point == 12) return false;
        else
        {
            do
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    
                }
                Roll();
            } while (dice.GetSidesSum() != 7 && dice.GetSidesSum() != point);
            return dice.GetSidesSum() == point;
        }
    }
    
    private int Roll()
    {
        dice.Roll();
        System.out.println("You rolled " + dice.GetSidesSum() + ".");
        return dice.GetSidesSum();
    }
    
    private void WinRound(int bet)
    {
        System.out.println("You win!");
        bankroll += bet;
    }
    
    private void LoseRound(int bet)
    {
        System.out.println("You lose...");
        bankroll -= bet;
    }
}
