import java.awt.Point;

public abstract class Maze
{
    public abstract Point Entrance();
    
    public abstract Point Exit();
    
    public abstract boolean IsEmpty(int x, int y);
    
    public boolean IsEmpty(Point p)
    { return IsEmpty(p.x, p.y); }
    
    private int SurroundingEmpties(int x, int y)
    {
        int accumulator = 0;
        if (IsEmpty(x, y + 1)) accumulator++;
        if (IsEmpty(x, y - 1)) accumulator++;
        if (IsEmpty(x + 1, y)) accumulator++;
        if (IsEmpty(x - 1, y)) accumulator++;
        return accumulator;
    }
    
    public boolean IsSplit(Point p)
    { return SurroundingEmpties(p.x, p.y) > 2; }
    
    public boolean IsDeadEnd(Point p)
    { return SurroundingEmpties(p.x, p.y) <= 1; }
}
