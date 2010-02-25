import java.awt.Point;
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
        Point entrance = maze.Entrance();
        LeadsToExit(Next(entrance, entrance), entrance);
        return moves;
    }
    
    private boolean LeadsToExit(Point p, Point old)
    {
        if (p.equals(maze.Exit()))
        {
            AddMove(p, old);
            return true;
        }
        else if (maze.IsDeadEnd(p)) return false;
        else if (!maze.IsSplit(p))
        {
            if (LeadsToExit(Next(p, old), p))
            {
                AddMove(p, old);
                return true;
            }
            else return false;
        }
        else
        {
            if (LeadsToExit(Next(p, old), p) ||
                LeadsToExit(AltNext(p, old), p))
            {
                AddMove(p, old);
                return true;
            }
            else return false;
        }
    }
    
    private void AddMove(Point p, Point old)
    {
        if (p.y > old.y) moves.push(Move.Up);
        else if (p.y < old.y) moves.push(Move.Down);
        else if (p.x > old.x) moves.push(Move.Right);
        else if (p.x < old.x) moves.push(Move.Left);
    }
    
    private Point Next(Point p, Point old)
    {
        Point next = new Point(p);
        next.translate(0, 1);
        if (maze.IsEmpty(next) && !old.equals(next)) return next;
        next.translate(-1, -1);
        if (maze.IsEmpty(next) && !old.equals(next)) return next;
        next.translate(1, -1);
        if (maze.IsEmpty(next) && !old.equals(next)) return next;
        next.translate(1, 1);
        if (maze.IsEmpty(next) && !old.equals(next)) return next;
        throw new RuntimeException();
    }
    
    private Point AltNext(Point p, Point old)
    {
        Point next = new Point(p);
        next.translate(1, 0);
        if (maze.IsEmpty(next) && !old.equals(next)) return next;
        next.translate(-1, -1);
        if (maze.IsEmpty(next) && !old.equals(next)) return next;
        next.translate(-1, 1);
        if (maze.IsEmpty(next) && !old.equals(next)) return next;
        next.translate(1, 1);
        if (maze.IsEmpty(next) && !old.equals(next)) return next;
        throw new RuntimeException();
    }
}
