import java.util.Scanner;

public class Program_5_4C
{
    public static void main(String[] args)
    {
        System.out.print("Enter bar code: ");
        BarCode a;
        try
        {
            a = new BarCode(new Scanner(System.in).nextLine().trim());
            if (!a.IsValidZIPCodeBarCode()) throw new IllegalArgumentException();
            for (int i = 0; i < 5; i++)
            {
                System.out.print(a.GetDigit(i).value);
            }
            System.out.println();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid bar code.");
        }
    }
}
