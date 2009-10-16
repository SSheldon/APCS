public class Card implements Comparable
{
    public static enum Suit { Clubs, Spades, Hearts, Diamonds }
    
    public final Suit suit;    
    public final int rank;
    
    public Card(Suit suit, int rank)
    {
        if (rank < 2 || rank > 14) throw new IllegalArgumentException();
        this.suit = suit;
        this.rank = rank;
    }
    
    public boolean equals(Object obj)
    {
        Card card = (Card)obj;
        return this.rank == card.rank && this.suit == card.suit;
    }
    
    public String toString()
    {
        String rankString;
        switch (rank)
        {
            case 11:
                rankString = "Jack";
            case 12:
                rankString = "Queen";
            case 13:
                rankString = "King";
            case 14:
                rankString = "Ace";
            default:
                rankString = Integer.toString(rank);
        }
        return rankString + " of " + suit;
    }
    
    public int compareTo(Object obj)
    {
        return (int)Math.signum(this.rank - ((Card)obj).rank);
    }
}