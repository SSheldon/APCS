import java.util.Scanner;

public class Project_4_8
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int exponent, base;
        while (true)
        {
            System.out.print("Enter the base or -1 to quit: ");
            base = scanner.nextInt();
            if (base == -1) break;
            if (base > 1)
            {
                System.out.print(
                    "Enter the exponent the base will be raised to: ");
                exponent = scanner.nextInt();
                if (exponent >= 0) 
                    System.out.println(
                        (int)Math.pow((double)base, (double)exponent));
            }
        }
    }
}