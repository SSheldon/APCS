import java.util.Scanner;

public class Project_4_1
{
    public static void main(String[] args)
    {
        int i1, i2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        i1 = scanner.nextInt();
        System.out.print("Enter second integer: ");
        i2 = scanner.nextInt();
        
        if (i1 >= i2)
            System.out.println(i1 / i2 + "r. " + i1 % i2);
        else
            System.out.println(i2 / i1 + "r. " + i2 % i1);
    }
}