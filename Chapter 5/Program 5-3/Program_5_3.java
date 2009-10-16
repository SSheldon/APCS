public class Program_5_3
{
    public static void main(String[] args)
    {
        Card[] cards = new Card[5];
        for (int i = 0; i < 5; i++)
        {
            int rank = (int)(Math.random() * 12) + 2;
            Card.Suit suit;
            switch ((int)(Math.random() * 4))
            {
                case 0:
                    suit = Card.Suit.Clubs;
                    break;
                case 1:
                    suit = Card.Suit.Spades;
                    break;
                case 2:
                    suit = Card.Suit.Hearts;
                    break;
                default:
                    suit = Card.Suit.Diamonds;
                    break;    
            }
            cards[i] = new Card(suit, rank);
            System.out.println(i + ": " + cards[i]);
        }
        
        Hand hand = new Hand(
            cards[0],
            cards[1],
            cards[2],
            cards[3],
            cards[4]);
        
        System.out.println(hand.GetHandType());
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