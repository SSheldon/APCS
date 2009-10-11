import java.util.Scanner;

public class Project_4_3
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter call length in minutes: ");
        int minutes = scanner.nextInt();
        System.out.println("Cost: $" + Cost(minutes));
    }

    public static double Cost(int minutes)
    {
        double cost = 0;
        if (minutes > 0) cost += 1.15;
        if (minutes > 2) cost += 0.5 * (minutes - 2);
        return cost;
    }
}