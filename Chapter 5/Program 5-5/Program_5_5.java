import java.util.Scanner;

public class Program_5_5
{
    public static void main(String[] args)
    {
        System.out.print("Enter date: ");
        Date date = parseDate(new Scanner(System.in).nextLine());
        System.out.println(date.Format1());
        System.out.println(date.Format2());
        System.out.println(date.Format3());
    }
    
    public static Date parseDate(String s)
    {
        s = s.trim();
        if (s.contains("/"))
        {
            int slash1 = s.indexOf("/");
            int slash2 = s.indexOf("/", slash1 + 1);
            return new Date(
                Integer.parseInt(s.substring(0, slash1)),
                Integer.parseInt(s.substring(slash1 + 1, slash2)),
                Integer.parseInt(s.substring(slash2 + 1, s.length())));
        }
        else if (s.contains(","))
        {
            int space1 = s.indexOf(" ");
            return new Date(
                s.substring(0, space1),
                Integer.parseInt(s.substring(space1 + 1, s.indexOf(","))),
                Integer.parseInt(s.substring(s.indexOf(" ", space1 + 1) + 1, s.length())));
        }
        else
        {
            int space = s.indexOf(" ");
            return new Date(
                Integer.parseInt(s.substring(0, space)),
                Integer.parseInt(s.substring(space + 1, s.length())));
                
        }
    }
}
