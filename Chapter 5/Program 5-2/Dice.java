public class Dice
{
    Die[] dice;
    
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
}