import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise_P15_1
{
    public static void main(String[] args)
    {
        FileAnalyzer x = new FileAnalyzer();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            try
            {
                System.out.print("Enter the name of a text file: ");
                x.SetFile(scanner.nextLine());
            }
            catch (FileNotFoundException e)
            {
                break;
            }
            System.out.println("Lines: " + x.GetLines());
            System.out.println("Words: " + x.GetWords());
            System.out.println("Characters: " + x.GetChars());            
        }
    }
}
