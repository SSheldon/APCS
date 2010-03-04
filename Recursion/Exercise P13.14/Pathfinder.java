import java.util.Stack;

public class Pathfinder
{
    private Maze maze;
    private Stack<Move> moves;
    
    public enum Move { Up, Left, Down, Right }
    
    public Pathfinder(Maze maze)
    {
        this.maze = maze;
    }
    
    public Stack<Move> GetMoves()
    {        
        moves = new Stack<Move>();
        int x = maze.EntranceX(), y = maze.EntranceY();
        LeadsToExit(NextX(x, y, x, y), NextY(x, y, x, y), x, y);
        return moves;
    }
    
    private boolean LeadsToExit(int x, int y, int oldX, int oldY)
    {
        if (x == maze.ExitX() && y == maze.ExitY())
        {
            AddMove(x, y, oldX, oldY);
            return true;
        }
        else if (maze.IsDeadEnd(x, y)) return false;
        else
        {
            if (LeadsToExit(NextX(x, y, oldX, oldY),
                NextY(x, y, oldX, oldY), x, y))
            {
                AddMove(x, y, oldX, oldY);
                return true;
            }
            else if (maze.IsSplit(x, y))
            {
                if (LeadsToExit(AltNextX(x, y, oldX, oldY),
                    AltNextY(x, y, oldX, oldY), x, y))
                {
                    AddMove(x, y, oldX, oldY);
                    return true;
                }
                else return false;
            }
            else return false;
        }
    }
    
    private void AddMove(int x, int y, int oldX, int oldY)
    {
        if (y > oldY) moves.push(Move.Up);
        else if (y < oldY) moves.push(Move.Down);
        else if (x > oldX) moves.push(Move.Right);
        else if (x < oldX) moves.push(Move.Left);
    }
    
    private int NextX(int x, int y, int oldX, int oldY)
    {
        if (maze.IsEmpty(x + 1, y) && x + 1 != oldX) return x + 1;
        else if (maze.IsEmpty(x, y - 1) && y - 1 != oldY) return x;
        else if (maze.IsEmpty(x - 1, y) && x - 1 != oldX) return x - 1;
        else if (maze.IsEmpty(x, y + 1) && y + 1 != oldY) return x;
        else throw new RuntimeException();
    }
    
    private int NextY(int x, int y, int oldX, int oldY)
    {
        if (maze.IsEmpty(x + 1, y) && x + 1 != oldX) return y;
        else if (maze.IsEmpty(x, y - 1) && y - 1 != oldY) return y - 1;
        else if (maze.IsEmpty(x - 1, y) && x - 1 != oldX) return y;
        else if (maze.IsEmpty(x, y + 1) && y + 1 != oldY) return y + 1;
        else throw new RuntimeException();
    }
    
    private int AltNextX(int x, int y, int oldX, int oldY)
    {
        if (maze.IsEmpty(x, y + 1) && y + 1 != oldY) return x;
        else if (maze.IsEmpty(x - 1, y) && x - 1 != oldX) return x - 1;
        else if (maze.IsEmpty(x, y - 1) && y - 1 != oldY) return x;
        else if (maze.IsEmpty(x + 1, y) && x + 1 != oldX) return x + 1;
        else throw new RuntimeException();
    }
    
    private int AltNextY(int x, int y, int oldX, int oldY)
    {
        if (maze.IsEmpty(x, y + 1) && y + 1 != oldY) return y + 1;
        else if (maze.IsEmpty(x - 1, y) && x - 1 != oldX) return y;
        else if (maze.IsEmpty(x, y - 1) && y - 1 != oldY) return y - 1;
        else if (maze.IsEmpty(x + 1, y) && x + 1 != oldX) return y;
        else throw new RuntimeException();
    }
}
