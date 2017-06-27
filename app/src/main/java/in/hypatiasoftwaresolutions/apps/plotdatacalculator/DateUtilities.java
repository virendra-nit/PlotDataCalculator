package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import java.util.Date;

/**
 * Created by viru on 3/21/2017.
 */
public class DateUtilities {
    private static String[] months={"jan","feb","march","apr","may","june","july","aug","sep","oct","nov","dec"};
    private static String[] days={"sun","mon","tues","wed","thur","fri","sat"};
    public  static String getcurrentTime()
    {
        Date date=new Date();
        return Utilities.pad(date.getHours()) + ":" + Utilities.pad( date.getMinutes());
    }
    public static int getCurrentHour()
    {
        Date date=new Date();
        return date.getHours();
    }
    public static int getCurrentMinute()
    {
        Date date=new Date();
        return date.getMinutes();
    }
    public static String getCurrentDate()
    {

        Date date=new Date();
        int day=date.getDate();
        int month=date.getMonth()+1;
        int year=date.getYear() + 1900;
        return getDate(day, month, year);
    }
    public static String getWeekDay(int day,int month,int year)
    {
        Date date=new Date(year-1900, month-1, day);
        int n=  date.getDay();
        return days[n];
    }
    public static String getDate(int day,int month,int year)
    {
        return Utilities.pad(day) + "-" + months[month-1] + "-" + year;
    }
    public static boolean isValidDate(int day,int month,int year)
    {
        if(day<1 || month<1 || month>12 || year<=0)
            return false;
        if(day>daysInMonth(month, year))
            return false;
        return true;
    }
    public static int daysInMonth(int month,int year)
    {
        switch(month)
        {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if(isLeapYear(year))
                    return 29;
                return 28;
            default:return 31;
        }
    }
    public static boolean isLeapYear(int year)
    {
        if(year % 400==0)
            return true;
        if(year % 4==0 && year % 100!=0)
            return true;
        return false;
    }

}
