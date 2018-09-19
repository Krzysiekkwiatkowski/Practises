package src.pl.coderslab.Day1.WyrażeniaRegularne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

    public static void main(String[] args) {
        String password = "Aa4AaAaAa22";
        System.out.println(verifyPassword(password));
    }

    static boolean verifyPassword(String password){
        String regex1 = "((([a-z]){1}[0-9]*([A-Z]){1}[0-9]*)*)|((([A-Z]){1}[0-9]*([a-z]){1}[0-9]*)*)";
        String regex2 = ".{10,15}";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            pattern = Pattern.compile(regex2);
            matcher = pattern.matcher(password);
            if(matcher.matches()){
                return true;
            }
        }
        return false;
    }
}
