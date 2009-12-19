import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Project_9_5
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++)
        {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = scanner.nextInt();
        }
        System.out.println("Median: " + Median(nums));
        Hashtable<Integer, Integer> freqs = Frequencies(nums);
        int[] mode = Mode(freqs);
        System.out.print("Mode: " + mode[0]);
        for (int i = 1; i < mode.length; i++) System.out.print(", " + i);
        System.out.println();
        PrintFreqTable(freqs);
    }
    
    public static Hashtable<Integer, Integer> Frequencies(int[] nums)
    {
        Hashtable<Integer, Integer> freqs = new Hashtable<Integer, Integer>();
        for (int i : nums)
        {
            if (freqs.containsKey(i)) freqs.put(i, freqs.get(i) + 1);
            else freqs.put(i, 1);
        }
        return freqs;
    }
    
    public static int[] Mode(Hashtable<Integer, Integer> freqs)
    {
        int maxCount = 0;
        for (int i : freqs.values())
            maxCount = Math.max(maxCount, i);
        ArrayList<Integer> modes = new ArrayList<Integer>();
        for (int i : freqs.keySet())
            if (freqs.get(i) == maxCount && !modes.contains(i)) modes.add(i);
        int[] modesArray = new int[modes.size()];
        for (int i = 0; i < modesArray.length; i++)
            modesArray[i] = modes.get(i);
        return modesArray;
    }
    
    public static double Median(int[] nums)
    {
        Arrays.sort(nums);
        int length = nums.length;
        if (length % 2 == 0)
            return (nums[length / 2] + nums[length / 2 + 1]) / 2.0;
        else return nums[length / 2];
    }
    
    public static void PrintFreqTable(Hashtable<Integer, Integer> freqs)
    {
        int count = 0;
        for (int i : freqs.values()) count += i;
        System.out.println("Number      Frequency");
        for (int i : freqs.keySet())
            System.out.printf("%-12d%-4.1f%n", i,
                (double)freqs.get(i) / count);
    }
}
