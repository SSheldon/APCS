import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Program_5_4B
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(268, 58);
        System.out.print("Enter ZIP code: ");
        try
        {
            frame.getContentPane().add(new Bar(new BarCode(Digit.ZipCodeDigits(new Scanner(System.in).nextInt()))));
            frame.setVisible(true);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid ZIP code.");
        }
    }
}
