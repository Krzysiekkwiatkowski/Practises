package src.pl.coderslab.Day1.ZadaniaDomowe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {

    public static void main(String[] args) {
        String email = "_kpjt";
        System.out.println(verifyLogin(email));
    }

    static boolean verifyLogin(String email){
        String regex = "[a-zA-Z_-][a-zA-Z0-9_-]{4,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
