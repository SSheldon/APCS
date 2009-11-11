import java.util.Scanner;
import java.util.Random;

public class LuckySevens
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        Random generator = new Random();
        
        int die1, die2,       // two dice
            totalCount;       // total number of rolls to reach depletion
        final int dollars;    // initial number of dollars (input)
        
        // Request the input
        System.out.print("How many dollars do you have? ");
        dollars = reader.nextInt();
        
        // Initialize variables
        totalCount = 0;
        
        for (int i = 0; i < 100; i++)
        {
            int simDollars = dollars;
            // Loop until the money is gone
            while (simDollars > 0)
            {
                totalCount++;
                
                // Roll the dice.
                die1 = generator.nextInt(6) + 1;
                die2 = generator.nextInt(6) + 1;
                
                // Calculate the winnings or losses
                if (die1 + die2 == 7)
                    simDollars += 4;
                else
                    simDollars -= 1;
            }
        }
        
        // Display the results
        System.out.println("On average, you were broke after " + 
            (double)totalCount / 100.0 + " rolls.");
    }
}
