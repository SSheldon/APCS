import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date
{
    GregorianCalendar date;
    
    public Date(int day, int month, int year)
    {
        date = new GregorianCalendar(year, month - 1, day);
    }
    
    public Date(String month, int day, int year)
    {
        date = new GregorianCalendar(year, ParseMonth(month), day);
    }
    
    public Date(int days, int years)
    {
        date = new GregorianCalendar(years, 0, 1);
        date.set(Calendar.DAY_OF_YEAR, days);
    }
    
    public String Format1()
    {       
        String format = "";
        if (GetMonth() < 10) format += "0";
        format += GetMonth() + "/";
        if (date.get(Calendar.DAY_OF_MONTH) < 10) format += "0";
        format += date.get(Calendar.DAY_OF_MONTH) + "/";
        if (date.get(Calendar.YEAR) < 1000) format += "0";
        if (date.get(Calendar.YEAR) < 100) format += "0";
        if (date.get(Calendar.YEAR) < 10) format += "0";
        format += date.get(Calendar.YEAR);
        return format;
    }
    
    public String Format2()
    {
        return GetMonthName() + " " + date.get(Calendar.DAY_OF_MONTH) + ", " + date.get(Calendar.YEAR);
    }

    public String Format3()
    {
        String format = "";
        if (date.get(Calendar.DAY_OF_YEAR) < 100) format += "0";
        if (date.get(Calendar.DAY_OF_YEAR) < 10) format += "0";
        format += date.get(Calendar.DAY_OF_YEAR) + " ";
        if (date.get(Calendar.YEAR) < 1000) format += "0";
        if (date.get(Calendar.YEAR) < 100) format += "0";
        if (date.get(Calendar.YEAR) < 10) format += "0";
        format += date.get(Calendar.YEAR);
        return format;
    }
    
    private int GetMonth()
    {
        return date.get(Calendar.MONTH) + 1;
    }
    
    private String GetMonthName()
    {
        switch (GetMonth())
        {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "";
        }
    }
    
    private int ParseMonth(String month)
    {
            if (month == "January") return 0;        
            if (month == "February") return 1;
            if (month == "March") return 2;
            if (month == "April") return 3;
            if (month == "May") return 4;
            if (month == "June") return 5;
            if (month == "July") return 6;
            if (month == "August") return 7;
            if (month == "September") return 8;
            if (month == "October") return 9;
            if (month == "November") return 10;
            return 11;
    }
}
