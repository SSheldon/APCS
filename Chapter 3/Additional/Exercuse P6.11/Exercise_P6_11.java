import java.util.Scanner;
import java.util.Vector;

public class Exercise_P6_11
{
    public static void main(String[] args)
    {
        System.out.print("Enter integer: ");
        int max = new Scanner(System.in).nextInt();
        if (max > 1) System.out.println(2);
        if (max > 2) System.out.println(3);
        Vector<Integer> oddPrimes = new Vector<Integer>();
        oddPrimes.add(3);
        for (int i = 5; i <= max; i += 2)
        {
            boolean prime = true;
            for (int oddPrime: oddPrimes)
            {
                if (i % oddPrime == 0) prime = false;
                if (!prime) break;
            }
            if (prime)
            {
                oddPrimes.add(i);
                System.out.println(i);
            }
        }
    }
}
