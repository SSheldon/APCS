import java.util.Scanner;
import java.util.Vector;

public class Project_6_4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> grades = new Vector<Integer>();
        while (true)
        {
            System.out.print("Enter grade (or -1 to quit): ");
            int grade = scanner.nextInt();
            if (grade < 0) break;
            grades.add(grade);
        }
        //get min
        int min = grades.get(0);
        for (Integer i : grades)
        {
            min = Math.min(min, i);
        }
        //get max
        int max = grades.get(0);
        for (Integer i : grades)
        {
            max = Math.max(max, i);
        }
        //get average
        int sum = 0;
        for (Integer i : grades)
        {
            sum += i;
        }
        System.out.println("Class average letter grade: " + 
            getLetterGrade(Math.round(sum / grades.size())));
        System.out.println("Class minimum letter grade: " +
            getLetterGrade(min));
        System.out.println("Class maximum letter grade: " +
            getLetterGrade(max));
    }
    
    public static String getLetterGrade(int grade)
    {
        if (grade > 95) return "A+";
        else if (grade > 91) return "A";
        else if (grade > 89) return "A-";
        else if (grade > 85) return "B+";
        else if (grade > 81) return "B";
        else if (grade > 79) return "B-";
        else if (grade > 75) return "C+";
        else if (grade > 71) return "C";
        else if (grade > 69) return "C-";
        else if (grade > 65) return "D+";
        else if (grade > 61) return "D";
        else if (grade > 59) return "D-";
        else return "F";
    }
}
