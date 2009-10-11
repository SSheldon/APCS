import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Exercise_P4_15
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(285, 305);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time (hh:mm): ");
        String time = scanner.nextLine();
        time = time.trim();
        frame.getContentPane().add(new Clock(
            Integer.parseInt(time.substring(0, 2)),
            Integer.parseInt(time.substring(3, 5))));
        frame.setVisible(true);
    }
}