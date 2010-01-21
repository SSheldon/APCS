public class Program_1
{
    public static void main(String[] args)
    {
        MonetaryCoin quarter = new MonetaryCoin(25);
        MonetaryCoin penny = new MonetaryCoin(1);
        MonetaryCoin nickel = new MonetaryCoin(5);
        
        int cents = quarter.getValue() + penny.getValue() + nickel.getValue();
        System.out.println("These coins are worth " + cents + " cents.");
        
        quarter.flip();
        System.out.println("Flipping the quarter resulted in " + quarter + ".");
    }
}
