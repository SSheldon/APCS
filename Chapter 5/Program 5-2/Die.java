public class Die
{
    private int side;
    private int rollCounter = 0;
    private int sides;
    
    public Die(int sides)
    {
        this.sides = sides;
    }
    
    public Die()
    {
        this(6);
    }
    
    public int Roll()
    {
        side = (int)(Math.random() * sides) + 1;
        rollCounter++;
        return side;
    }
    
    public int GetSide()
    {
        return side;
    }
    
    public int GetRollCounter()
    {
        return rollCounter;
    }
}