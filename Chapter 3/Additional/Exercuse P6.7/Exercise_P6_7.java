import java.util.Vector;
import java.util.Scanner;

public class Exercise_P6_7
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many values you will be entering: ");
        int count = scanner.nextInt();
        double[] values = new double[count];
        for (int i = 0; i < count; i++)
        {
            System.out.print("Enter value " + (i + 1) + ": ");
            values[i] = scanner.nextDouble();
        }
        double meanSum = 0;
        for (double v : values) { meanSum += v; }
        double mean = meanSum / count;
        double standardDevSum = 0;
        for (int i = 0; i < count; i++)
        {
            standardDevSum += Math.pow(values[i] - mean, 2.0);
        }
        double standardDev = Math.sqrt(standardDevSum / (count - 1));
        System.out.println("Count: " + count);
        System.out.println("Average: " + mean);
        System.out.println("Standard Deviation: " + standardDev);
    }
}
