import java.util.Arrays;

public class Hand// implements Comparable
{
    public static enum HandType { HighCards, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush; }
    
    Card[] cards = new Card[5];
    
    public Hand(Card c1, Card c2, Card c3, Card c4, Card c5)
    {
        cards[0] = c1;
        cards[1] = c2;
        cards[2] = c3;
        cards[3] = c4;
        cards[4] = c5;
        Arrays.sort(cards);
    }
    
    boolean IsStraight()
    {
        //check for repeated cards
        for (int i1 = 0; i1 < 5; i1++)
        {
            for (int i2 = 0; i2 < 5; i2++)
            {
                if (i2 != i1 && cards[i1].value == cards[i2].value) return false;
            }
        }
        //check if hand is straight
        if (cards[0].value == 2 && cards[1].value == 3 && cards[2].value == 4 && cards[3].value == 5 && cards[4].value == 14) return true;
        else
        {
            for (int i = 1; i < 5; i++)
            {
                if (cards[i].value != cards[i - 1].value + 1) return false;
            }
            return true;
        }
    }
    
    boolean IsFlush()
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
        if ((cards[0].value == cards[1].value && cards[0].value == cards[2].value && cards[3].value == cards[4].value) ||
            (cards[0].value == cards[1].value && cards[2].value == cards[3].value && cards[2].value == cards[4].value)) 
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
    
    boolean ContainsSet(int number)
    {
        for (int i = 0; i < 6 - number; i++)
        {
            boolean isSet = true;
            for (int a = 0; a < number - 1; a++)
            {
                if (cards[i + a].value != cards[i + a + 1].value) isSet = false;
                if (!isSet) break;
            }
            if (isSet) return true;
        }
        return false;
    }
    
    int NumberOfPairs()
    {
        int number = 0;
        for (int i = 0; i < 4; i++)
        {
            if (cards[i].value == cards[i + 1].value) number++;
        }
        return number;
    }
    
//  public int compareTo(Object obj)
//  {
//      Hand hand = (Hand)obj;
//      if ((int)this.GetHandType() < (int)hand.GetHandType()) return -1;
//      if ((int)this.GetHandType() > (int)hand.GetHandType()) return 1;
//      if (this.GetHandType() == hand.GetHandType())
//      {
//          switch (this.GetHandType())
//          {
//              case HandType.StraightFlush:
//              case HandType.Straight:
//                  return (int)Math.signum((double)(this.GetHighCardValue(0) - hand.GetHighCardValue(0)));
//              case HandType.FourOfAKind:
//                  
//              case HandType.FullHouse:
//                  
//              case HandType.Straight:
//                  
//              case HandType.ThreeOfAKind:
//                  
//              case HandType.TwoPair:
//                  
//              case HandType.OnePair:
//                  
//              case HandType.Flush:
//              case HandType.HighCards:
//                  
//          }
//      }
//      return 0;
//  }
//  
//  public int GetHighCardValue(int place)
//  {
//      switch (this.GetHandType())
//      {
//          case HandType.StraightFlush:
//          case HandType.Straight:
//              if (cards[4] == 14) return 5;
//              else return cards[4];
//          case HandType.FourOfAKind:
//              
//          case HandType.FullHouse:
//              
//          case HandType.ThreeOfAKind:
//              
//          case HandType.TwoPair:
//              
//          case HandType.OnePair:
//              
//          case HandType.Flush:
//          case HandType.HighCards:
//              return cards[place].value;
//  }   
}

//StraightFlush has 1 level of comparison
//FourOfAKind has 2 levels of comparison
//FullHouse has 2 levels of comparison
//Flush has 1 level of comparison
//Straight has 5 levels of comparison
//ThreeOfAKind has 3 levels of comparison
//TwoPair has 3 levels of comparison
//OnePair has 4 levels of comparison
//HighCards has 5 levels of comparison