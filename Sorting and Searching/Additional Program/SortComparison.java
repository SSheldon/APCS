public class SortComparison
{
    public static void main(String[] args)
    {
        int[] a1 = new int[5000], a2 = new int[5000], a3 = new int[5000];
        for (int i = 0; i < 5000; i++)
        {
            int a = (int)(Math.random() * 5000);
            a1[i] = a;
            a2[i] = a;
            a3[i] = a;
        }
        StopWatch s = new StopWatch();
        s.start();
        SelectionSort(a1);
        s.stop();
        System.out.println("Selection sort: " + s.getElapsedTime() + " ms");
        s.reset();
        s.start();
        InsertionSort(a2);
        s.stop();
        System.out.println("Insertion sort: " + s.getElapsedTime() + " ms");
        s.reset();
        s.start();
        MergeSort(a3);
        s.stop();
        System.out.println("Merge sort: " + s.getElapsedTime() + " ms");
        s.reset();
    }
    
    public static void SelectionSort(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i; j < a.length; j++)
            {
                if (a[j] < a[i])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    
    public static void InsertionSort(int[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] < a[i - 1])
            {
                int temp = a[i], j;
                for (j = i; j > 0 && a[j - 1] > temp; j--)
                    a[j] = a[j - 1];
                a[j] = temp;
            }
        }
    }
    
    public static void MergeSort(int[] a)
    {
        for (int x = 2; x / 2 < a.length; x *= 2)
            for (int i = 0; i < a.length; i += x)
                if (i + x / 2 < a.length)
                    Merge(a, i, i + x / 2, Math.min(i + x, a.length));
    }
    
    private static void Merge(int[] a, int start1, int start2, int end2)
    {
        int[] b = new int[start2 - start1];
        System.arraycopy(a, start1, b, 0, start2 - start1);
        int[] c = new int[end2 - start2];
        System.arraycopy(a, start2, c, 0, end2 - start2);
        for (int i = start1, bi = 0, ci = 0; i < end2; i++)
        {
            if (b[bi] <= c[ci])
            {
                a[i] = b[bi];
                bi++;
                if (bi == b.length)
                {
                    System.arraycopy(c, ci, a, i + 1, end2 - 1 - i);
                    break;
                }
            }
            else
            {
                a[i] = c[ci];
                ci++;
                if (ci == c.length)
                {
                    System.arraycopy(b, bi, a, i + 1, end2 - 1 - i);
                    break;
                }
            }
        }
    }
}
