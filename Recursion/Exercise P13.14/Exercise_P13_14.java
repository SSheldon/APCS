import java.util.Stack;

public class Exercise_P13_14
{
    public static final String[] maze = {
        "* *******",
        "*     * *",
        "* ***** *",
        "* * *   *",
        "* * *** *",
        "*   *   *",
        "*** * * *",
        "*     * *",
        "******* *"};
    
    public static void main(String[] args)
    {
        Pathfinder finder = new Pathfinder(new StringMaze(maze, 7, 0, 1, 8));
        Stack<Pathfinder.Move> moves = finder.GetMoves();
        while (!moves.empty()) System.out.println(moves.pop());
    }
}
