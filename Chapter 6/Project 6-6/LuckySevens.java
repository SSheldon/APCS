import java.util.Scanner;
import java.util.Random;

public class LuckySevens
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        Random generator = new Random();
        
        int die1, die2,       // two dice
            dollars,          // initial number of dollars (input)
            count,            // number of rolls to reach depletion
            maxDollars,       // maximum amount held by the gambler
            countAtMax;       // count when the maximum is achieved
        
        // Request the input
        System.out.print("How many dollars do you have? ");
        dollars = reader.nextInt();
        
        // Initialize variable
        maxDollars = dollars;
        countAtMax = 0;
        count = 0;
        
        // Loop until the money is gone
        while (dollars > 0)
        {
            count++;
            
            // Roll the dice.
            die1 = generator.nextInt(6) + 1;
            die2 = generator.nextInt(6) + 1;
            
            // Calculate the winnings or losses
            if (die1 + die2 == 7)
                dollars += 4;
            else
                dollars -= 1;
            
            // If this is a new maximum, remember it
            if (dollars > maxDollars)
            {
                maxDollars = dollars;
                countAtMax = count;
            }
        }
        
        // Display the results
        System.out.println(
            "You are broke after " + count + " rolls.\n" +
            "You should have quit after " + countAtMax +
            " rolls when you had $" + maxDollars + ".");
    }
}
