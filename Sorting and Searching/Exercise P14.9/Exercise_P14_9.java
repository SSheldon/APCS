public class Exercise_P14_9
{
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
    
    public static void MergeSort(int[] a)
    {
        for (int x = 2; x / 2 < a.length; x *= 2)
            for (int i = 0; i < a.length; i += x)
                if (i + x / 2 < a.length)
                    Merge(a, i, i + x / 2, Math.min(i + x, a.length));
    }
    
    public static void main(String[] args)
    {
        int[] a = new int[20];
        for (int i = 0; i < a.length; i++)
            a[i] = (int)(Math.random() * 100);
        for (int i : a) System.out.print(i + " ");
        System.out.println();
        MergeSort(a);
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }
}
