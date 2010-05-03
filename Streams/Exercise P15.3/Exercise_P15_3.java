import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;

public class Exercise_P15_3
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.print("Enter the name of a text file: ");
            Hashtable<Character, Double> freqs = Frequencies(scanner.nextLine());
            for (char c = 'A'; c <= 'Z'; c++)
                System.out.println(c + ": " + freqs.get(c));
        }
        catch (FileNotFoundException e) { }
    }
    
    public static Hashtable<Character, Double> Frequencies(String fileName)
        throws FileNotFoundException
    {
        int[] counts = new int[26];
        int sum = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        try
        {
            for (String line = reader.readLine(); line != null;
                line = reader.readLine())
            {
                line = line.toUpperCase();
                for (int i = 0; i < line.length(); i++)
                {
                    char c = line.charAt(i);
                    if (c >= 'A' && c <= 'Z')
                    {
                        counts[Int(c)]++;
                        sum++;
                    }
                }
            }
        }
        catch (IOException e) { }
        Hashtable<Character, Double> freqs = new Hashtable<Character, Double>();
        for (int i = 0; i < counts.length; i++)
            freqs.put(Char(i), (double)counts[i] / (double)sum);
        return freqs;
    }
    
    private static int Int(char c)
    { return (int)(c) - 65; }
    
    private static char Char(int i)
    { return (char)(i + 65); }
}