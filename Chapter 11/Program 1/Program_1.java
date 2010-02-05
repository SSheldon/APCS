import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Program_1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers to be generated: ");
        List<Integer> list = createList(scanner.nextInt());
        System.out.println(list);
        System.out.println("Mean: " + getMean(list));
        System.out.println("Median: " + getMedian(list));
    }
    
    public static List<Integer> createList(int n)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++)
            list.add((int)(Math.random() * 90) + 10);
        return list;
    }
    
    public static double getMean(List<Integer> list)
    {
        int sum = 0;
        for (int i : list) sum += i;
        return (double)sum / list.size();
    }
    
    public static double getMedian(List<Integer> list)
    {
        Collections.sort(list);
        int length = list.size();
        if (length % 2 == 0)
            return (list.get(length / 2) + list.get(length / 2 + 1)) / 2.0;
        else return list.get(length / 2);
    }
}
