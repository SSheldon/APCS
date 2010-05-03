import java.io.*;
import java.util.Scanner;

public class Exercise_P15_4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.print("Enter the key: ");
            String key = scanner.nextLine().toUpperCase();
            System.out.print("Enter the name of a text file to encrypt: ");
            System.out.println(EncryptFile(scanner.nextLine(), key));
            System.out.print("Enter the name of a text file to Decrypt: ");
            System.out.println(DecryptFile(scanner.nextLine(), key));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }
    
    public static String Encrypt(String s, String key)
    {
        String e = "";
        for (int i = 0; i < s.length(); i++)
        {
            e += Encrypt(e.charAt(i), key.charAt(i % key.length()));
        }
        return e;
    }
    
    public static char Encrypt(char c, char key)
    {
        return Char((Int(c) + Int(key)) % 26);
    }
    
    public static char Decrypt(char c, char key)
    {
        return Char((Int(c) + 26 - Int(key)) % 26);
    }
    
    private static int Int(char c)
    { return (int)(c) - 65; }
    
    private static char Char(int i)
    { return (char)(i + 65); }
    
    private static String EncryptFile(String fileName, String key)
        throws FileNotFoundException
    {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s = "";
        int i = 0;
        try
        {
            int next = reader.read();
            while (next != -1)
            {
                char c;
                if (next >= 65 && next <= 90 || next >= 97 && next <= 122)
                {
                    if (next > 90) //lowercase
                    {
                        c = (char)((int)Encrypt((char)(next - 32),
                            key.charAt(i)) + 32);
                    }
                    else c = Encrypt((char)next, key.charAt(i));
                    i = (i + 1) % key.length();
                }
                else c = (char)next;
                s += c;
                next = reader.read();
            }
        }
        catch (IOException e) { }
        return s;
    }
    
    private static String DecryptFile(String fileName, String key)
        throws FileNotFoundException
    {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s = "";
        int i = 0;
        try
        {
            int next = reader.read();
            while (next != -1)
            {
                char c;
                if (next >= 65 && next <= 90 || next >= 97 && next <= 122)
                {
                    if (next > 90) //lowercase
                    {
                        c = (char)((int)Decrypt((char)(next - 32),
                            key.charAt(i)) + 32);
                    }
                    else c = Decrypt((char)next, key.charAt(i));
                    i = (i + 1) % key.length();
                }
                else c = (char)next;
                s += c;
                next = reader.read();
            }
        }
        catch (IOException e) { }
        return s;
    }
}
