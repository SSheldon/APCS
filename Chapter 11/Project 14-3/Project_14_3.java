import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_14_3
{
    public static void main(String[] args)
    {
        List<String> nouns = new ArrayList<String>();
        List<String> verbs = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            System.out.print("Enter a noun (or hit enter to continue): ");
            String response = scanner.nextLine().trim();
            if (response.equals("")) break;
            else nouns.add(response);
        }        
        while (true)
        {
            System.out.print("Enter a verb (or hit enter to continue): ");
            String response = scanner.nextLine().trim();
            if (response.equals("")) break;
            else verbs.add(response);
        }        
        System.out.println(Sentence(nouns, verbs));
    }
    
    public static String Sentence(List<String> nouns, List<String> verbs)
    {
        String sentence = "The ";
        sentence += nouns.get((int)(Math.random() * nouns.size())) + " ";
        sentence += verbs.get((int)(Math.random() * verbs.size())) + " the ";
        sentence += nouns.get((int)(Math.random() * nouns.size())) + " with a ";
        sentence += nouns.get((int)(Math.random() * nouns.size())) + ".";
        return sentence;
    }
}
