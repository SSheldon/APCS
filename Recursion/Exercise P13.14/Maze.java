public abstract class Maze
{
    public abstract int EntranceX();
    public abstract int EntranceY();
    public abstract int ExitX();
    public abstract int ExitY();
    
    public abstract boolean IsEmpty(int x, int y);
    
    private int SurroundingEmpties(int x, int y)
    {
        int accumulator = 0;
        if (IsEmpty(x, y + 1)) accumulator++;
        if (IsEmpty(x, y - 1)) accumulator++;
        if (IsEmpty(x + 1, y)) accumulator++;
        if (IsEmpty(x - 1, y)) accumulator++;
        return accumulator;
    }
    
    public boolean IsSplit(int x, int y)
    { return SurroundingEmpties(x, y) > 2; }
    
    public boolean IsDeadEnd(int x, int y)
    { return SurroundingEmpties(x, y) <= 1; }
}
