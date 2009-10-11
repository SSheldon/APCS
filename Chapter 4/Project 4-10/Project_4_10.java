import java.util.Scanner;

public class Project_4_10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter starting salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter percentage increase: ");
        double raise = scanner.nextDouble() / 100.0;
        System.out.print("Enter number of years in the schedule: ");
        int years = scanner.nextInt();
        for (int year = 0; year < years; year++)
        {
            System.out.println("Year " + (year + 1) +
                " salary: $" + (salary += salary * raise));
        }
    }
}