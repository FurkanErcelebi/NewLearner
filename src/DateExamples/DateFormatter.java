package DateExamples;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DateFormatter {

    public static String setInt(int date_or_time){

        if(date_or_time < 10){
            return "0" + date_or_time ;
        }
        else {
            return  String.valueOf(date_or_time);
        }

    }

    public static String formatTimeStamp(Date date, int time) {

        String time_stamp = (date.getYear() + 1900) + "-" + setInt(date.getMonth() + 1) + "-" + setInt(date.getDate());

        if (time == 1) {
            time_stamp += "T";
        } else {

            time_stamp += " ";

        }

        time_stamp += setInt(date.getHours()) + ":" + setInt(date.getSeconds()) + ":" + setInt(date.getMinutes());

        return time_stamp;

    }

    public static void main(String args[]) throws ParseException {

        /*SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        sdfDate.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));

        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
        sdfTime.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));

        Date date = new Date();

        System.out.println("Date: " +  sdfDate.format(date));
        System.out.println("Time: " +  sdfTime.format(date));*/
        Date date = new Date();

        System.out.println("Miniminutes since 00:00:00 , 1.1.1970:" + date.getTime());
        int year = (int)(date.getTime() / 31557600000.0);
        System.out.println("Years :" + (1970 + year));
        int mouths = (int)(((date.getTime() %  31557600000.0)));
        System.out.println("Mouths :" + mouths);
        /*System.out.println("Hours :" + (24 - (int)(date.getTime() % 360000) / 6000));
        System.out.println("Days :" + (31 - (int)(date.getTime() % 8640000)/ 144000) );
        System.out.println("Seconds :" + (60 - (int)(date.getTime() % 6000) / 100));
        System.out.println("Minutes :" + date.getTime() % 100);*/
        //System.out.println("Date formatter mod0: " + formatTimeStamp(date,0));
        //System.out.println("Date formatter mod1: " + formatTimeStamp(date,1));

    }

}
