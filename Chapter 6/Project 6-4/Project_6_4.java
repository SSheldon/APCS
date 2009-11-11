import java.util.Scanner;
import java.util.Vector;

public class Project_6_4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        IntList grades = new IntList();
        while (true)
        {
            System.out.print("Enter grade (or -1 to quit): ");
            int grade = scanner.nextInt();
            if (grade < 0) break;
            grades.Add(grade);
        }
        System.out.println("Class average letter grade: " + 
            getLetterGrade((int)Math.round(grades.Avg())));
        System.out.println("Class minimum letter grade: " +
            getLetterGrade(grades.Min()));
        System.out.println("Class maximum letter grade: " +
            getLetterGrade(grades.Max()));
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
