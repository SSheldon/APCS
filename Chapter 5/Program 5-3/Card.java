public class Card implements Comparable
{
    public static enum Suit { Clubs, Spades, Hearts, Diamonds }
    
    public Suit suit;    
    public int value;
    
    public Card(Suit suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }
    
    public String GetValue()
    {
        switch (value)
        {
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
            default:
                return Integer.toString(value);
        }
    }
    
    public int compareTo(Object obj)
    {
        return (int)Math.signum(this.value - ((Card)obj).value);
    }
}