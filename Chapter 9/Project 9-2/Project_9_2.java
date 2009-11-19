import java.util.Scanner;

public class Project_9_2
{
    public static void main(String[] args)
    {
        double[] nums = new double[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++)
        {
            System.out.print("Enter a number: ");
            nums[i] = scanner.nextDouble();
        }
        double average = Average(nums);
        System.out.println("Average: " + average);
        System.out.println("Numbers greater than the average: ");
        for (double d : nums)
        {
            if (d > average) System.out.println(d);
        }
    }
    
    public static double Average(double[] nums)
    {
        double sum = 0;
        for (double d : nums)
        {
            sum += d;
        }
        return sum / nums.length;
    }
}
