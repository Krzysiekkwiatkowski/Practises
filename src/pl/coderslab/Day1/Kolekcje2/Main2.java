package src.pl.coderslab.Day1.Kolekcje2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        Map<String, String> map = getMap();
        Set<String> keys = map.keySet();
        Scanner scanner = new Scanner(System.in);
        String value = "";
        int count = 0;
        for (String key : keys) {
            System.out.println("Podaj przeciwieństwo dla: " + key);
            value = scanner.next();
            if(value.equals(map.get(key))){
                count++;
            }
        }
        System.out.println("Poprawnych odpowiedzi: " + count);
    }

    public static Map<String, String> getMap(){
        Map<String, String> map = new HashMap<>();
        map.put("ciepło","zimno");
        map.put("mały","duży");
        map.put("miękki","twardy");
        map.put("biały","czarny");
        map.put("nowy","stary");
        return map;
    }
}
