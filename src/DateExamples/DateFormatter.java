package DateExamples;


import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateFormatter {
	
	public static String getDateFormat(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss Z", new Locale("tr-TR"));
        return simple.format(date);
    }

    public static void main(String args[]) throws Exception ,ParseException {

       Scanner input = new Scanner(System.in);
       System.out.printf("Enter the date:");
       String sDate1 = input.nextLine();
       Date date1=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss aaa zzz", Locale.ENGLISH).parse(sDate1);  
       System.out.println(sDate1+"\t->\t"+ new Date(date1.getTime() - 3 * 3600 * 1000) + "\t->\t" + getDateFormat(new Date(date1.getTime() - 6 * 3600 * 1000))); 

    }

}
