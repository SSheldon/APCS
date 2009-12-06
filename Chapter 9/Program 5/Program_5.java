public class Program_5
{
    public static void main(String[] args)
    {
        boolean[] closed = new boolean[1000];            
        for (int i = 2; i <= 1000; i++)
            for (int j = i - 1; j < 1000; j += i)
                closed[j] = !closed[j];
        for (int i = 0; i < 1000; i++)
            if (!closed[i]) System.out.println(i + 1);
    }
}
