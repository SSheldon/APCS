public class Program_5_3
{
    public static void main(String[] args)
    {
        Hand hand = new Hand(
            new Card(Card.Suit.Spades, 8),
            new Card(Card.Suit.Clubs, 8),
            new Card(Card.Suit.Clubs, 8),
            new Card(Card.Suit.Clubs, 2),
            new Card(Card.Suit.Clubs, 2));
        
        System.out.println(TypeOfHand(hand.GetHandType()));
    }
    
    public static String TypeOfHand(Hand.HandType handType)
    {
        switch (handType)
        {
            case StraightFlush:
                return "Straight Flush";
            case Straight:
                return "Straight";
            case FourOfAKind:
                return "Four of a Kind";
            case FullHouse:
                return "Full House";
            case Flush:
                return "Flush";
            case ThreeOfAKind:
                return "Three of a Kind";
            case TwoPair:
                return "Two Pair";
            case OnePair:
                return "One Pair";
            case HighCards:
                return "High Cards";
            default:
                return "Oh teh noes!";
        }
    }
}