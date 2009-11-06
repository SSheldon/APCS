import java.util.Scanner;

public class Project_6_5
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int n1 = scanner.nextInt();        
        System.out.print("Enter second integer: ");
        int n2 = scanner.nextInt();
        System.out.println("Greatest common divisor: " + GCD(n1, n2));
    }
    
    public static int GCD(int n1, int n2)
    {
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);
        int large = Math.max(n1, n2);
        int small = Math.min(n1, n2);
        while (small != 0)
        {
            int remainder = large % small;
            System.out.println("Remainder of " + large + 
                " divided by " + small + ": " + remainder);
            large = small;
            small = remainder;
        }
        return large;
    }
}
