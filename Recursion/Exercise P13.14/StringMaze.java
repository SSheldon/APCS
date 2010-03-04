public class StringMaze extends Maze
{
    private final String[] maze;
    public final int entX, entY, exitX, exitY;
    
    public StringMaze(String[] maze, int entX, int entY, int exitX, int exitY)
    {
        this.maze = maze;
        this.entX = entX;
        this.entY = entY;
        this.exitX = exitX;
        this.exitY = exitY;
    }
    
    public int EntranceX() { return entX; }
    public int EntranceY() { return entY; }
    public int ExitX() { return exitX; }
    public int ExitY() { return exitY; }
    
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
