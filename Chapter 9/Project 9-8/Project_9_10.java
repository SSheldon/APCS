import java.util.Scanner;

public class Project_9_10
{
    public static void main(String[] args)
    {
        System.out.print("Enter number of rows to print: ");
        PrintPascalTriangle(new Scanner(System.in).nextInt());
    }
    
    public static int[][] PascalTriangle(int rows)
    {
        int[][] triangle = new int[rows][];
        for (int row = 0; row < rows; row++)
        {
            triangle[row] = new int[row + 1];
            for (int col = 0; col < row + 1; col++)
                triangle[row][col] = col == 0 || col == row ? 1 :
                    triangle[row - 1][col - 1] + triangle[row - 1][col];
        }
        return triangle;
    }
    
    public static void PrintPascalTriangle(int rows)
    {
        int[][] triangle = PascalTriangle(rows);
        for (int[] row : triangle)
        {
            for (int num : row) System.out.print(num + " ");
            System.out.println();
        }
    }
}
