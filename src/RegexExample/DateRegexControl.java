package RegexExample;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DateRegexControl {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the date:");
        String text = input.nextLine();
        String regex_pattern = "^(\\d)(\\d)(\\d)(\\d)-(\\d)(\\d)-(\\d)(\\d).(\\d)(\\d):(\\d)(\\d):(\\d)(\\d).*";

        if(Pattern.matches(regex_pattern,text)){
            System.out.println("This is date");
        }
        else {
            System.out.println("This is not date");
        }

    }

}
