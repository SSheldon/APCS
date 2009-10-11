public class BarCode
{
    public boolean[] fullBars = new boolean[32];
    
    public BarCode(Digit[] digits)
    {
        if (digits.length != 6) throw new IllegalArgumentException();
        fullBars[0] = true;
        for (int i = 0; i < 6; i++)
        {
            SetDigit(i, digits[i]);
        }
        fullBars[31] = true;
    }
    
    public BarCode(String barCode)
    {
        if (barCode.length() != 32) throw new IllegalArgumentException();
        for (int i = 0; i < 32; i++)
        {
            if (!barCode.substring(i, i + 1).equals("|") && !barCode.substring(i, i + 1).equals(":")) throw new IllegalArgumentException();
            fullBars[i] = barCode.substring(i, i + 1).equals("|");
        }
    }
    
    public Digit GetDigit(int position)
    {
        int i = 5 * position + 1;
        if ( fullBars[i + 0] &&  fullBars[i + 1] && !fullBars[i + 2] && !fullBars[i + 3] && !fullBars[i + 4]) return new Digit(0);
        if (!fullBars[i + 0] && !fullBars[i + 1] && !fullBars[i + 2] &&  fullBars[i + 3] &&  fullBars[i + 4]) return new Digit(1);
        if (!fullBars[i + 0] && !fullBars[i + 1] &&  fullBars[i + 2] && !fullBars[i + 3] &&  fullBars[i + 4]) return new Digit(2);
        if (!fullBars[i + 0] && !fullBars[i + 1] &&  fullBars[i + 2] &&  fullBars[i + 3] && !fullBars[i + 4]) return new Digit(3);
        if (!fullBars[i + 0] &&  fullBars[i + 1] && !fullBars[i + 2] && !fullBars[i + 3] &&  fullBars[i + 4]) return new Digit(4);
        if (!fullBars[i + 0] &&  fullBars[i + 1] && !fullBars[i + 2] &&  fullBars[i + 3] && !fullBars[i + 4]) return new Digit(5);
        if (!fullBars[i + 0] &&  fullBars[i + 1] &&  fullBars[i + 2] && !fullBars[i + 3] && !fullBars[i + 4]) return new Digit(6);
        if ( fullBars[i + 0] && !fullBars[i + 1] && !fullBars[i + 2] && !fullBars[i + 3] &&  fullBars[i + 4]) return new Digit(7);
        if ( fullBars[i + 0] && !fullBars[i + 1] && !fullBars[i + 2] &&  fullBars[i + 3] && !fullBars[i + 4]) return new Digit(8);
        if ( fullBars[i + 0] && !fullBars[i + 1] &&  fullBars[i + 2] && !fullBars[i + 3] && !fullBars[i + 4]) return new Digit(9);
        throw new IllegalArgumentException();
    }
    
    private void SetDigit(int position, Digit digit)
    {
        int i = 5 * position + 1;
        switch (digit.value)
        {
            case 0:
                fullBars[i + 0] = true;
                fullBars[i + 1] = true;
                fullBars[i + 2] = false;
                fullBars[i + 3] = false;
                fullBars[i + 4] = false;
                break;
            case 1:
                fullBars[i + 0] = false;
                fullBars[i + 1] = false;
                fullBars[i + 2] = false;
                fullBars[i + 3] = true;
                fullBars[i + 4] = true;
                break;
            case 2:
                fullBars[i + 0] = false;
                fullBars[i + 1] = false;
                fullBars[i + 2] = true;
                fullBars[i + 3] = false;
                fullBars[i + 4] = true;
                break;
            case 3:
                fullBars[i + 0] = false;
                fullBars[i + 1] = false;
                fullBars[i + 2] = true;
                fullBars[i + 3] = true;
                fullBars[i + 4] = false;
                break;
            case 4:
                fullBars[i + 0] = false;
                fullBars[i + 1] = true;
                fullBars[i + 2] = false;
                fullBars[i + 3] = false;
                fullBars[i + 4] = true;
                break;
            case 5:
                fullBars[i + 0] = false;
                fullBars[i + 1] = true;
                fullBars[i + 2] = false;
                fullBars[i + 3] = true;
                fullBars[i + 4] = false;
                break;
            case 6:
                fullBars[i + 0] = false;
                fullBars[i + 1] = true;
                fullBars[i + 2] = true;
                fullBars[i + 3] = false;
                fullBars[i + 4] = false;
                break;
            case 7:
                fullBars[i + 0] = true;
                fullBars[i + 1] = false;
                fullBars[i + 2] = false;
                fullBars[i + 3] = false;
                fullBars[i + 4] = true;
                break;
            case 8:
                fullBars[i + 0] = true;
                fullBars[i + 1] = false;
                fullBars[i + 2] = false;
                fullBars[i + 3] = true;
                fullBars[i + 4] = false;
                break;
            case 9:
                fullBars[i + 0] = true;
                fullBars[i + 1] = false;
                fullBars[i + 2] = true;
                fullBars[i + 3] = false;
                fullBars[i + 4] = false;
                break;
        }
    }
    
    public String toString()
    {
        String barCode = "";
        for (boolean fullBar : fullBars) barCode += fullBar ? "|" : ":";
        return barCode;
    }
    
    public int toInt32()
    {
        int barCode = 0;
        for (int i = 0; i < 32; i++) barCode += fullBars[31 - i] ? (int)Math.pow(2, i) : 0;
        return barCode;
    }
}