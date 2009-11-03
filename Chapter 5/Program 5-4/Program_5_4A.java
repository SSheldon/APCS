import java.util.Scanner;

public class Program_5_4A
{
    public static void main(String[] args)
    {
        System.out.print("Enter ZIP code: ");
        try
        {
            System.out.println(new BarCode(Digit.ZipCodeDigits(new Scanner(System.in).nextInt())));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid ZIP code.");
        }
    }
}
