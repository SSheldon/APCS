import java.awt.Point;

public class StringMaze extends Maze
{
    private final String[] maze;
    private final Point entrance, exit;
    
    public StringMaze(String[] maze, Point entrance, Point exit)
    {
        this.maze = maze;
        this.entrance = entrance;
        this.exit = exit;
    }
    
    public Point Entrance()
    {
        return new Point(entrance);
    }
    
    public Point Exit()
    {
        return new Point(exit);
    }
    
    public boolean IsEmpty(int x, int y)
    {
        try
        {
            return maze[maze.length - 1 - y].charAt(x) == ' ';
        }
        catch (IndexOutOfBoundsException e)
        {
            return false;
        }
    }
}
