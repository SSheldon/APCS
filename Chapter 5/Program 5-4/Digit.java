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
        int sum = 0, tempZip = zipcode;
        for (int i = 4; i >= 0; i--)
        {
            sum += tempZip / (int)Math.pow(10, i);
            tempZip %= (int)Math.pow(10, i);
        }
        return Digits(zipcode * 10 + (10 - sum % 10));
    }
    
    public static Digit[] Digits(int number)
    {
        if (number < 0) throw new IllegalArgumentException();
        String numberString = "" + number;
        Digit[] digits = new Digit[numberString.length()];
        for (int i = 0; i < numberString.length(); i++)
        {
            digits[i] = new Digit(Integer.parseInt(numberString.substring(i, i + 1)));
        }
        return digits;
    }
}
