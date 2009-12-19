import java.util.Scanner;

public class PennyPitchGame
{
    private static final int HEIGHT = 5, WIDTH = 5;
    private boolean[][] pennies = new boolean[HEIGHT][WIDTH];
    private Scanner scanner = new Scanner(System.in);
    
    public void Run()
    {
        DisplayBoard();
        for (int i = 0; i < 5; i++)
        {
            scanner.nextLine();
            Toss();
            DisplayBoard();
        }
        int score = 0;
        for (int row = 0; row < HEIGHT; row++)
            for (int col = 0; col < WIDTH; col++)
                if (pennies[row][col]) score += Number(row, col);
        System.out.println("\nScore: " + score);
    }
    
    private void DisplayBoard()
    {
        for (int row = 0; row < HEIGHT; row++)
        {
            for (int col = 0; col < WIDTH; col++)
                System.out.print((pennies[row][col] ? "P" : Number(row, col)) + " ");
            System.out.println();
        }
    }
    
    private int Number(int row, int col)
    {
        return Math.min(HEIGHT / 2 + 1 -  Math.abs(HEIGHT / 2 - row),
            WIDTH / 2 + 1 - Math.abs(WIDTH / 2 - col));
    }
    
    private void Toss()
    {
        int rand;
        do rand = (int)(Math.random() * (HEIGHT * WIDTH));
        while (pennies[rand / WIDTH][rand % WIDTH]);
        pennies[rand / WIDTH][rand % WIDTH] = true;
    }
}
