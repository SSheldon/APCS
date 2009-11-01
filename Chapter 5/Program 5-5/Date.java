import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date
{
    private GregorianCalendar date;
    
    public Date(int month, int day, int year)
    {
        date = new GregorianCalendar(year, month - 1, day);
    }
    
    public Date(String month, int day, int year)
    {
        this(Date.ParseMonth(month), day, year);
    }
    
    public Date(int days, int years)
    {
        this(days / 31 + 1, days % 31, years);
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
        if (GetDriversLicenseDay() < 100) format += "0";
        if (GetDriversLicenseDay() < 10) format += "0";
        format += GetDriversLicenseDay() + " ";
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
                throw new RuntimeException();
        }
    }
    
    private static int ParseMonth(String month)
    {
        month = month.toLowerCase();
        if (month.equals("january")) return 1;        
        if (month.equals("february")) return 2;
        if (month.equals("march")) return 3;
        if (month.equals("april")) return 4;
        if (month.equals("may")) return 5;
        if (month.equals("june")) return 6;
        if (month.equals("july")) return 7;
        if (month.equals("august")) return 8;
        if (month.equals("september")) return 9;
        if (month.equals("october")) return 10;
        if (month.equals("november")) return 11;
        if (month.equals("december")) return 12;
        throw new IllegalArgumentException();
    }
    
    private int GetDriversLicenseDay()
    {
        return date.get(Calendar.MONTH) * 31 + date.get(Calendar.DAY_OF_MONTH);
    }
}
