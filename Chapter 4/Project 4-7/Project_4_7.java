import java.util.Scanner;

public class Project_4_7
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int exponent;
        while (true)
        {
            System.out.print("Enter the exponent 2 will be raised to or -1 to quit: ");
            exponent = scanner.nextInt();
            if (exponent == -1) break;
            if (exponent >= 0) System.out.println((int)Math.pow(2.0, (double)exponent));
        }
    }
}