
package TGHM;

public class Time {
    private static int hour,minute;
    private static int day,month,year;
    
    public Time(){
        hour = 15;
        minute =30;
        day = 10;
        month = 4;
        year = 2016;
    }
    
    public int gethour(){
        return hour;
    }
    
    public int getminute(){
        return minute;
    }
    
    public int getday(){
        return day;
    }
    
    public int getmonth(){
        return month;
    }
    
    public int getyear(){
        return year;
    }
}
