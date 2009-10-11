import java.util.Scanner;

public class Project_4_5
{
    public static void main(String[] args)
    {
        System.out.print("Enter the number of iterations: ");
        System.out.println("Liebniz Approximation: " +
            LiebnizApprox(new Scanner(System.in).nextInt()));        
    }

    public static double LiebnizApprox(int iterations)
    {
        boolean positive = true;
        double approx = 0;
        for (int i = 1; i < 2 * iterations; i += 2)
        {
            if (positive) approx += 1.0 / i;
            else approx -= 1.0 / i;
            positive = !positive;
        }
        return approx;
    }
}
