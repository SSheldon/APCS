public class Program_5_3
{
    public static void main(String[] args)
    {
        Card[] cards = new Card[10];
        for (int i = 0; i < 10; i++)
        {
            int rank;
            Card.Suit suit;
            do
            {
                rank = (int)(Math.random() * 12) + 2;
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
            } while (CardsContains(cards, new Card(suit, rank)));
            cards[i] = new Card(suit, rank);
        }
        Hand hand1 = new Hand(
            cards[0],
            cards[1],
            cards[2],
            cards[3],
            cards[4]);
        System.out.println("Hand 1 cards:");
        for (int i = 0; i < 5; i++)
        {            
            System.out.println(i + ": " + hand1.GetCard(i));
        }
        System.out.println("Hand 1 type: " + 
            HandTypeToString(hand1.GetHandType()));
        Hand hand2 = new Hand(
            cards[5],
            cards[6],
            cards[7],
            cards[8],
            cards[9]);
         System.out.println("Hand 2 cards:");
        for (int i = 0; i < 5; i++)
        {            
            System.out.println(i + ": " + hand2.GetCard(i));
        }        
        System.out.println("Hand 2 type: " + 
            HandTypeToString(hand2.GetHandType()));
        switch (hand1.compareTo(hand2))
        {
            case -1:
                System.out.println("Hand 2 is better.");
                break;
            case 0:
                System.out.println("The hands are equally good.");
                break;
            case 1:
                System.out.println("Hand 1 is better.");
                break;
        }
    }
    
    public static boolean CardsContains(Card[] cards, Card card)
    {
        for (Card cardsCard : cards)
        {
            if (cardsCard != null && cardsCard.equals(card)) return true;
        }
        return false;
    }
    
    public static String HandTypeToString(Hand.HandType handType)
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
                throw new RuntimeException();
        }
    }
}