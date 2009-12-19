public class Program_6
{
    public static void main(String[] args)
    {
        int[] a = new int[150];
        int[] b = new int[150];
        for (int i = 0; i < 150; i++) a[i] = (int)(Math.random() * 51);
        for (int i = 0; i < 150; i++) b[i] = (int)(Math.random() * 51);
        int[] total = new int[150];
        for (int i = 0; i < 150; i++) total[i] = a[i] + b[i];
        
        Print(total);
        SelectionSort(total);
        Print(total);
        BackwardsPrint(total);
        System.out.println("Highest score: " + Max(total));
        System.out.println("Lowest score: " + Min(total));
        System.out.println("Average score: " + Average(total));
        System.out.println("Standard deviation: " + StandardDeviation(total));
        PrintFrequencyBarGraph(total);
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
    
    public static double StandardDeviation(int[] array)
    {
        double sum = 0, avg = Average(array);
        for (int i = 0; i < array.length; i++)
            sum += Math.pow(array[i] - avg, 2);
        return Math.sqrt(sum / array.length);
    }
    
    public static void SelectionSort(int[] array)
    {
        int temp;
        for (int i = 0; i < array.length; i++)
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[i])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
    }
    
    public static void PrintFrequencyBarGraph(int[] array)
    {
        int[] intervals = new int[10];
        int start = 0;
        for (int i = 0; i < 9; i++)
        {
            int end = IndexOfFirstGreater(array, i * 10 + 9);
            if (end == -1) end = array.length;
            intervals[i] = end - start;
            start = end;
        }
        intervals[9] = array.length - start;
        for (int i = 0; i < 10; i++)
        {
            if (i == 9) System.out.print("90+  : ");
            else System.out.print(i + "0-" + i + "9: ");
            for (int j = 0; j < intervals[i]; j++)
                System.out.print("x");
            System.out.println();
        }
    }
    
    public static int IndexOfFirstGreater(int[] array, int value)
    {
        int index = -1;
        for (int i = 0; i < array.length; i++)
            if (array[i] > value)
            {
                index = i;
                break;
            }
        return index;
    }
}
