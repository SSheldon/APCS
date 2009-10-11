import java.util.Scanner;

public class Project_2_5
{
    public static void main(String[] args)
    {
        double m, v;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter mass in kilograms: ");
        m = scanner.nextDouble();
        System.out.print("Enter velocity in meters per second: ");
        v = scanner.nextDouble();
        System.out.println("The object's momentum is " + m * v);
    }
}