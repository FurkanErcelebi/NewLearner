package RegexExample;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DateRegexControl {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the date:");
        String text = input.nextLine();
        String regex_pattern = "^(19|20)\\d\\d([-])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])( )([01][0-9]|2[0-3])([:])([0-5][0-9])([:])([0-5][0-9])$";

        if(Pattern.matches(regex_pattern,text)){
            System.out.println("This is date");
        }
        else {
            System.out.println("This is not date");
        }

    }

}
