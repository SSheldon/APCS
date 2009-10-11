import java.util.Scanner;

public class Project_4_2
{
    public static void main(String[] args)
    {
        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter side length: ");
        a = scanner.nextDouble();
        System.out.print("Enter side length: ");
        b = scanner.nextDouble();
        System.out.print("Enter side length: ");
        c = scanner.nextDouble();
        System.out.println("The triangle is" + 
            (RightTriangle(a, b, c) ? " " : " not ") +
            "a right triangle.");
    }
    
    public static boolean RightTriangle(double a, double b, double c)
    {
        return (a * a + b * b == c * c) ||
            (b * b + c * c == a * a) ||
            (c * c + a * a == b * b);
    }
    
}