import java.util.Scanner;

public class Project_3_2
{
    public static void main(String[] args)
    {
        System.out.print("Enter sphere's radius: ");
        double radius = new Scanner(System.in).nextDouble();
        System.out.println("Diameter: " + 2 * radius);
        System.out.println("Circumference: " + 2 * radius * Math.PI);
        System.out.println("Surface Area: " + 4 * Math.pow(radius, 2.0) * Math.PI);
        System.out.println("Volume: " + 4 / 3 * Math.pow(radius, 3.0) * Math.PI);
    }
}