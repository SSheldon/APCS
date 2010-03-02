public class Exercise_P13_1
{
    public static String reverse(String s)
    {
        if (s.length() == 1) return s;
        return reverse(s.substring(1, s.length())) + s.substring(0, 1);
    }
    
    public static void main(String[] args)
    {
        System.out.println(reverse("Hello!"));
    }
}
