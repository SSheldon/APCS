public class Phonebook
{
    private int[] numbers;
    private int[] nameIndexes;
    private String[] names;
    private int[] numberIndexes;
    
    public Phonebook(int[] numbers, String[] names)
    {
        if (numbers.length != names.length) throw new RuntimeException();
        this.numbers = numbers;
        nameIndexes = new int[numbers.length];
        for (int i = 0; i < nameIndexes.length; i++) nameIndexes[i] = i;
        this.names = names;
        numberIndexes = new int[names.length];
        for (int i = 0; i < numberIndexes.length; i++) numberIndexes[i] = i;
        SortNumbers();
        SortNames();
    }
    
    private void SortNumbers()
    {
        for (int i = 1; i < numbers.length; i++)
        {
            if (numbers[i] < numbers[i - 1])
            {
                int tempN = numbers[i], tempI = nameIndexes[i], j;
                for (j = i; j > 0 && numbers[j - 1] > tempN; j--)
                {
                    numbers[j] = numbers[j - 1];
                    nameIndexes[j] = nameIndexes[j - 1];
                }
                numbers[j] = tempN;
                nameIndexes[j] = tempI;
            }
        }
        for (int i = 0; i < numbers.length; i++)
        {
            numberIndexes[nameIndexes[i]] = i;
        }
    }
    
    private void SortNames()
    {
        for (int i = 1; i < names.length; i++)
        {
            if (names[i].compareTo(names[i - 1]) < 0)
            {
                String tempN = names[i];
                int tempI = numberIndexes[i], j;
                for (j = i; j > 0 && names[j - 1].compareTo(tempN) > 0; j--)
                {
                    names[j] = names[j - 1];
                    numberIndexes[j] = numberIndexes[j - 1];
                }
                names[j] = tempN;
                numberIndexes[j] = tempI;
            }
        }
        for (int i = 0; i < names.length; i++)
        {
            nameIndexes[numberIndexes[i]] = i;
        }
    }
    
    private int Search(int v)
    {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int diff = numbers[mid] - v;
            if (diff == 0) return mid;
            else if (diff < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    
    private int Search(String v)
    {
        int low = 0;
        int high = names.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int diff = names[mid].compareTo(v);
            if (diff == 0) return mid;
            else if (diff < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    
    public int Lookup(String name)
    {
        int i = Search(name);
        if (i == -1) return 0;
        else return numbers[numberIndexes[i]];
    }
    
    public String ReverseLookup(int number)
    {
        int i = Search(number);
        if (i == -1) return null;
        else return names[nameIndexes[i]];
    }
}
