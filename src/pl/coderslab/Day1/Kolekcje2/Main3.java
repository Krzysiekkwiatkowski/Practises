package src.pl.coderslab.Day1.Kolekcje2;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Map<String, Country> map = getMap(initialize());
        Set<String> set = map.keySet();
        for (String capital: set) {
            System.out.println(capital + " - " + map.get(capital).getName());
        }
    }

    public static List<Country> initialize (){
        List<Country> list = new ArrayList<>();
        Country country1 = new Country("Polska", "Warszawa");
        Country country2 = new Country("Niemcy", "Berlin");
        Country country3 = new Country("Anglia", "Londyn");
        Country country4 = new Country("Francja", "Paryż");
        Country country5 = new Country("Rosja", "Moskwa");
        list.add(country1);
        list.add(country2);
        list.add(country3);
        list.add(country4);
        list.add(country5);
        return list;
    }

    public static Map<String, Country> getMap (List<Country> list){
        Map<String, Country> map = new HashMap<>();
        for (Country country : list) {
            map.put(country.getCapital(), country);
        }
        return map;
    }
}
