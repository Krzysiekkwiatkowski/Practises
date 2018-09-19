package src.pl.coderslab.Day1.WyrażeniaRegularne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {

    public static void main(String[] args) {
        String email = "krzyszt.kwiatkowski@gmail.com";
        System.out.println(verifyEmail(email));
    }

    static boolean verifyEmail(String email){
        String regex = "[a-zA-Z0-9\\.]*\\@[a-zA-Z0-9]*\\.[a-zA-Z0-9]{2,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
