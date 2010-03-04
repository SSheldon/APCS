import java.util.List;
import java.util.ArrayList;

public class SubstringGenerator
{
    private String s;
    private List<String> substrings;
    
    public SubstringGenerator(String s)
    { SetString(s); }
    
    public void SetString(String s)
    { this.s = s; }
    
    public List<String> GetSubstrings()
    {
        substrings = new ArrayList<String>();
        GenerateSubstrings();
        return substrings;
    }
    
    private void GenerateSubstrings()
    {
        for (int i = 0; i <= s.length(); i++)
            AddSubstrings(s.substring(i, s.length()));
    }
    
    private void AddSubstrings(String sub)
    {
        if (sub.length() > 1)
            AddSubstrings(sub.substring(0, sub.length() - 1));
        substrings.add(sub);
    }
    
    public static void main(String[] args)
    {
        SubstringGenerator sg = new SubstringGenerator("rum");
        System.out.println(sg.GetSubstrings());
    }
}
