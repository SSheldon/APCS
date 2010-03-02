public class Exercise_P13_4
{
    public static boolean find(String s, String t)
    {
        if (s.length() < t.length()) return false;
        else if (s.substring(0, t.length()).equals(t)) return true;
        else return find(s.substring(1, s.length()), t);
    }
    
    public static void main(String[] args)
    {
        System.out.println(find("Mississippi!", "sip"));
    }
}
