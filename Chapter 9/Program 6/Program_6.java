import java.util.Arrays;

public class Program_6
{
    public static void main(String[] args)
    {
        int[] a = new int[150];
        int[] b = new int[150];
        for (int i = 0; i < 150; i++) a[i] = (int)(Math.random() * 51);
        for (int i = 0; i < 150; i++) b[i] = (int)(Math.random() * 51);
        int[] total = new int[300];
        for (int i = 0; i < 300; i++)
        {
            if (i < 150) total[i] = a[i];
            else total[i] = b[i - 150];
        }
        
        //print total
        Print(total);
        //print total from low to high
        Arrays.sort(total);
        Print(total);
        //print total from high to low
        BackwardsPrint(total);
        //print highest
        System.out.println("Highest score: " + Max(total));
        //print lowest
        System.out.println("Lowest score: " + Min(total));
        //print average
        System.out.println("Average score: " + Average(total));
    }
    
    public static void Print(int[] array)
    {
        for (int i : array) System.out.print(i + " ");
        System.out.println();
    }
    
    public static void BackwardsPrint(int[] array)
    {
        for (int i = array.length - 1; i >= 0; i--)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    
    public static int Max(int[] array)
    {
        int max = array[0];
        for (int i : array) max = Math.max(i, max);
        return max;
    }
    
    public static int Min(int[] array)
    {
        int min = array[0];
        for (int i : array) min = Math.min(i, min);
        return min;
    }
    
    public static double Average(int[] array)
    {
        int sum = 0;
        for (int i : array) sum += i;
        return (double)sum / (double)array.length;
    }
}
