public class Exercise_P13_6
{
    public static int getMaximum(int[] values, int first, int last)
    {
        if (first == last) return values[last];
        return Math.max(values[last], getMaximum(values, first, last - 1));
    }
    
    public static void main(String[] args)
    {
        System.out.println(getMaximum(new int[] { 5, 3, 7, 1, 6 }, 0, 4));
    }
}