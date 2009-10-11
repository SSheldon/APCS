import java.util.Scanner;

public class Program_5_4A
{
    public static void main(String[] args)
    {
        System.out.print("Enter ZIP code: ");
        System.out.println(new BarCode(Digit.ZipCodeDigits(new Scanner(System.in).nextInt())));
        BarCode a = new BarCode("||:|:::|:|:||::::::||:|::|:::|||");
        System.out.println(a);
    }

    public static String BarCode(int zipCode)
    {
        String barCode = "|";
        int sum = 0, tempZip = zipCode;
        for (int i = 4; i >= 0; i--)
        {
            sum += tempZip / (int)Math.pow(10, i);
            tempZip %= (int)Math.pow(10, i);
        }
        int digits = zipCode * 10 + (10 - sum % 10);
        for (int i = 5; i >= 0; i--)
        {
            switch (digits / (int)Math.pow(10, i))
            {
                case 0:
                    barCode += "||:::";
                    break;
                case 1:
                    barCode += ":::||";
                    break;
                case 2:
                    barCode += "::|:|";
                    break;
                case 3:
                    barCode += "::||:";
                    break;
                case 4:
                    barCode += ":|::|";
                    break;
                case 5:
                    barCode += ":|:|:";
                    break;
                case 6:
                    barCode += ":||::";
                    break;
                case 7:
                    barCode += "|:::|";
                    break;
                case 8:
                    barCode += "|::|:";
                    break;
                case 9:
                    barCode += "|:|::";
                    break;
            }
            digits %= (int)Math.pow(10, i);
        }
        barCode += "|";
        return barCode;
    }
}
