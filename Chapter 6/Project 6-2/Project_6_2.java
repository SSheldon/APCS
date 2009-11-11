import java.util.Scanner;

public class Project_6_2
{    
    public static void main(String[] args)
    {
        System.out.print("Enter a number between 1 and 100: ");
        int n = new Scanner(System.in).nextInt();
        if (n < 0 || n > 100)
        {
            System.out.println("Invalid number.");
            return;
        }
        
        int guesses = 1;
        int guess = 50;
        for ( ; ; guesses++)
        {
            //guess
            System.out.println("Is the number " + guess + "?");
            //check
            if (n == guess) break;
            System.out.println("No, the number is " + 
                (n < guess ? "less" : "more") + ".");
            //change
            guess += (int)Math.ceil(50.0 / Math.pow(2, guesses)) *
                (n < guess ? -1 : 1);
        }
        System.out.println("Yes! You got it in " + guesses + " guess" +
            (guesses > 1 ? "es" : "") + ".");
    }
}
