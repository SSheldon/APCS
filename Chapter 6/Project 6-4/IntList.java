public class IntList
{
    private int count = 0;
    private int min, max, sum;
    
    public void Add(int i)
    {
        if (count == 0)
        {
            min = i;
            max = i;
            sum = i;
        }
        else
        {            
            min = Math.min(min, i);
            max = Math.max(max, i);
            sum += i;
        }
        count++;
    }
    
    public int Min()
    {
        return min;
    }
    
    public int Max()
    {
        return max;
    }
    
    public int Sum()
    {
        return sum;
    }
    
    public double Avg()
    {
        return (double)sum / (double)count;
    }
    
    public int Count()
    {
        return count;
    }
}