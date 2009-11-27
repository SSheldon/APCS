import java.util.Hashtable;
import java.util.ArrayList;

public class Project_9_5
{
    public static void main(String[] args)
    {
        int[] a = { 1, 4, 2, 5, 2, 3, 4 };
        int[] mode = Mode(a);
        for (int i : mode)
        {
            System.out.println(i);
        }
    }
    
    public static int[] Mode(int[] nums)
    {
        Hashtable<Integer, Integer> freqs = new Hashtable<Integer, Integer>();
        for (int i : nums)
        {
            if (freqs.containsKey(i))
                freqs.put(i, freqs.get(i).intValue() + 1);
            else
                freqs.put(i, 1);
        }
        int maxCount = 0;
        for (Integer i : freqs.values())
        {
            maxCount = Math.max(maxCount, i.intValue());
        }
        ArrayList<Integer> modes = new ArrayList<Integer>();
        for (Integer i : freqs.keySet())
        {
            if (freqs.get(i).intValue() == maxCount && !modes.contains(i))
                modes.add(i);
        }
        int[] modesArray = new int[modes.size()];
        for (int i = 0; i < modesArray.length; i++)
        {
            modesArray[i] = modes.get(i).intValue();
        }
        return modesArray;
    }
}
