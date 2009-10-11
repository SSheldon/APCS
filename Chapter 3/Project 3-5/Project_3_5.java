import java.util.Scanner;

public class Project_3_5
{
    public static void main(String[] args)
    {
        double wage, pay = 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hourly wage: ");
        wage = scanner.nextDouble();
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Enter regular hours worked on " + DayOfWeek(i) + ": ");
            pay += scanner.nextDouble() * wage;
            System.out.print("Enter overtime hours worked on " + DayOfWeek(i) + ": ");
            pay += scanner.nextDouble() * 1.5 * wage;
        }
        System.out.println("Total weekly pay: " + pay);
    }
    
    public static String DayOfWeek(int day)
    {
        switch (day)
        {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            default:
                return "Friday";
            
        }
    }
}
