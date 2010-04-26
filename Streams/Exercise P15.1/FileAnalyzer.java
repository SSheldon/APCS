import java.io.*;

public class FileAnalyzer
{
    private BufferedReader reader;
    private int lines, chars, words;
    
    public void SetFile(String fileName) throws FileNotFoundException
    {
        reader = new BufferedReader(new FileReader(fileName));
        lines = 0;
        chars = 0;
        words = 0;
        AnalyzeFile();
    }
    
    private void AnalyzeFile()
    {
        try
        {
            for (String line = reader.readLine(); line != null;
                line = reader.readLine())
            {
                lines++;
                chars += line.length();
                words += Words(line);
            }
        }
        catch (IOException e)
        {
            return;
        }
    }
    
    private static int Words(String s)
    {
        if (s.length() == 0) return 0;
        int words = 0;
        if (s.charAt(0) != ' ') words++;
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') words++;
        return words;
    }
    
    public int GetLines() { return lines; }
    public int GetChars() { return chars; }
    public int GetWords() { return words; }
}
