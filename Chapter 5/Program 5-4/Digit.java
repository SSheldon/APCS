public class Digit
{
    public int value;
    
    public Digit(int value)
    {
        if (value > 9 || value < 0) throw new IllegalArgumentException();
        this.value = value;
    }
    
    public static Digit[] ZipCodeDigits(int zipcode)
    {
        if (zipcode > 99999 || zipcode < 0) throw new IllegalArgumentException();
        int sum = 0, tempZip = zipcode;
        for (int i = 4; i >= 0; i--)
        {
            sum += tempZip / (int)Math.pow(10, i);
            tempZip %= (int)Math.pow(10, i);
        }
        return Digits(zipcode * 10 + (10 * (int)Math.ceil(sum / 10.0) - sum), 6);
    }
    
    public static Digit[] Digits(int number, int length)
    {
        if (number < 0 || number >= (int)Math.pow(10, length)) throw new IllegalArgumentException();
        Digit[] digits = new Digit[length];
        int tempNum = number;
        for (int i = 0; i < length; i++)
        {
            digits[i] = new Digit(tempNum / (int)Math.pow(10, length - 1 - i));
            tempNum %= (int)Math.pow(10, length - 1 - i);
        }
        return digits;
    }
}
