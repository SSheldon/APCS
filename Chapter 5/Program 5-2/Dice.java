public class Dice
{
    private Die[] dice;
    
    public Dice(int dice, int sides)
    {
        this.dice = new Die[dice];
        for (int i = 0; i < dice; i++)
        {
            this.dice[i] = new Die(sides);
        }
    }
    
    public Dice()
    {
        this(2, 6);
    }
    
    public int GetRollCounter()
    {
        return dice[0].GetRollCounter();
    }
    
    public int Roll()
    {
        for (Die die : dice)
        {
            die.Roll();
        }
        return GetSidesSum();
    }
    
    public int GetSidesSum()
    {
        int sum = 0;
        for (Die die : dice)
        {
            sum += die.GetSide();
        }
        return sum;
    }
    
    public String toString()
    {
        return "Sides sum: " + GetSidesSum();
    }
}