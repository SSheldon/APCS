import java.util.Arrays;

public class Hand implements Comparable
{
    public static enum HandType { HighCards, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush; }
    
    private Card[] cards = new Card[5];
    
    public Hand(Card c1, Card c2, Card c3, Card c4, Card c5)
    {
        cards[0] = c1;
        cards[1] = c2;
        cards[2] = c3;
        cards[3] = c4;
        cards[4] = c5;
        Arrays.sort(cards);
    }
    
    public Card GetCard(int index)
    {
        return cards[index];
    }
    
    private boolean IsStraight()
    {
        //check for repeated cards
        for (int i1 = 0; i1 < 5; i1++)
        {
            for (int i2 = 0; i2 < 5; i2++)
            {
                if (i2 != i1 && cards[i1].rank == cards[i2].rank) return false;
            }
        }
        //check if hand is straight
        if (cards[0].rank == 2 && cards[1].rank == 3 && cards[2].rank == 4 && cards[3].rank == 5 && cards[4].rank == 14) return true;
        else
        {
            for (int i = 1; i < 5; i++)
            {
                if (cards[i].rank != cards[i - 1].rank + 1) return false;
            }
            return true;
        }
    }
    
    private boolean IsFlush()
    {
        Card.Suit suit = cards[0].suit;
        for (Card card : cards)
        {
            if (card.suit != suit) return false;
        }
        return true;
    }
    
    public HandType GetHandType()
    {
        //StraightFlush
        if (this.IsFlush() && this.IsStraight()) return HandType.StraightFlush;
        //FourOfAKind
        if (this.ContainsSet(4)) return HandType.FourOfAKind;
        //FullHouse
        if ((cards[0].rank == cards[1].rank && cards[0].rank == cards[2].rank && cards[3].rank == cards[4].rank) ||
            (cards[0].rank == cards[1].rank && cards[2].rank == cards[3].rank && cards[2].rank == cards[4].rank)) 
            return HandType.FullHouse;
        //Flush
        if (this.IsFlush()) return HandType.Flush;
        //Straight
        if (this.IsStraight()) return HandType.Straight;
        //ThreeOfAKind
        if (this.ContainsSet(3)) return HandType.ThreeOfAKind;
        //TwoPair
        if (this.NumberOfPairs() == 2) return HandType.TwoPair;
        //OnePair
        if (this.ContainsSet(2)) return HandType.OnePair;
        //HighCards
        return HandType.HighCards;
    }
    
    private boolean ContainsSet(int number)
    {
        for (int i = 0; i < 6 - number; i++)
        {
            boolean isSet = true;
            for (int a = 0; a < number - 1; a++)
            {
                if (cards[i + a].rank != cards[i + a + 1].rank) isSet = false;
                if (!isSet) break;
            }
            if (isSet) return true;
        }
        return false;
    }
    
    private int NumberOfPairs()
    {
        int number = 0;
        for (int i = 0; i < 4; i++)
        {
            if (cards[i].rank == cards[i + 1].rank) number++;
        }
        return number;
    }
    
    public int compareTo(Object obj)
    {
        Hand hand = (Hand)obj;
        if (this.GetHandType() == hand.GetHandType())
        {
            for (int i = 0; i < 5; i++)
            {
                if (this.GetHighCardRank(i) != hand.GetHighCardRank(i))
                    return (int)Math.signum(this.GetHighCardRank(i) - hand.GetHighCardRank(i));
            }
            throw new RuntimeException();
        }
        else return (int)Math.signum(this.GetHandType().ordinal() - hand.GetHandType().ordinal());
    }

    private int GetHighCardRank(int index)
    {
        switch (this.GetHandType())
        {
            case StraightFlush:
            case Straight:
                if (cards[0].rank == 2 && cards[4].rank == 14) return cards[(index == 4 ? 4 : 3 - index)].rank;
                else return cards[4 - index].rank;
            case FourOfAKind:
                if (index >= 0 && index <= 3) return cards[cards[0].rank == cards[3].rank ? 0 : 4].rank;
                else return cards[cards[0].rank == cards[3].rank ? 4 : 0].rank;
            case FullHouse:
                if (index >= 0 && index <= 2) return cards[cards[0].rank == cards[2].rank ? 0 : 4].rank;
                else return cards[cards[0].rank == cards[2].rank ? 4 : 0].rank;                
            case ThreeOfAKind:
                int three = 0;
                for (int i = 0; i < 3; i++)
                {
                    if (cards[i].rank == cards[i + 1].rank && cards[i].rank == cards[i + 2].rank)
                    {
                        three = cards[i].rank;
                        break;
                    }
                }
                if (index >= 0 && index <= 2) return three;
                else
                {
                    if (index == 3)
                    {
                        for (int i = 4; i >= 0; i--)
                            if (cards[i].rank != three) return cards[i].rank;
                    }
                    else
                    {
                        for (int i = 0; i < 5; i++)
                            if (cards[i].rank != three) return cards[i].rank;
                    }
                }
            case TwoPair:
                int highPair = 0;
                for (int i = 4; i >= 1; i--)
                {
                    if (cards[i].rank == cards[i - 1].rank)
                    {
                        highPair = cards[i].rank;
                        break;
                    }
                }
                if (index == 0 || index == 1) return highPair;
                int lowPair = 0;
                for (int i = 0; i < 4; i++)
                {
                    if (cards[i].rank == cards[i + 1].rank)
                    {
                        lowPair = cards[i].rank;
                        break;
                    }
                }
                if (index == 2 || index == 3) return lowPair;
                else
                {
                    for (int i = 0; i < 5; i++)
                        if (cards[i].rank != highPair && cards[i].rank != lowPair)
                            return cards[i].rank;
                }
            case OnePair:
                int pair = 0;
                for (int i = 0; i < 4; i++)
                {
                    if (cards[i].rank == cards[i + 1].rank)
                    {
                        pair = cards[i].rank;
                        break;
                    }
                }
                if (index == 0 || index == 1) return pair;
                int counter = 0;
                for (int i = 4; i >= 0; i--)
                {
                    if (cards[i].rank != pair)
                    {
                        if (counter == index - 2) return cards[i].rank;
                        counter++;
                    }
                }
                throw new RuntimeException();
            case Flush:
            case HighCards:
                return cards[4 - index].rank;
            default:
                throw new RuntimeException();
        }
    }
}