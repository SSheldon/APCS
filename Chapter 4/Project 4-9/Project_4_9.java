import java.util.Scanner;
import java.io.*;

public class Project_4_9
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(new File(
            "E:/AP CS Projects/Chapter 4/Project 4-10/numbers.txt"));
        int exponent, base;
        while (scanner.hasNext())
        {
            base = scanner.nextInt();
            exponent = scanner.nextInt();
            System.out.println(base + " ^ " + exponent + " = " +
                (int)Math.pow((double)base, (double)exponent));
        }
    }
}