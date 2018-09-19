package src.pl.coderslab.Day1.Kolekcje1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main4 {

    public static void main(String[] args) {
        List<City> list = initialize();
        List<City> resultList = reverse(list);
        for (City city : resultList) {
            System.out.println(city.getName() + " liczy " + city.getPopulation() + " tysięcy mieszkańców.");
        }
    }

    public static List<City> reverse (List<City> list ){
        List<City> reverseList = new ArrayList<>();
        ListIterator<City> it = list.listIterator();
        while (it.hasNext()){
            it.next();
        }
        while (it.hasPrevious()){
            reverseList.add(it.previous());
        }
        return reverseList;
    }

    public static List<City> initialize(){
        List<City> list = new ArrayList<>();
        City city1 = new City("Gdańsk", 400);
        City city2 = new City("Olsztyn", 100);
        City city3 = new City("Warszawa", 1000);
        City city4 = new City("Gdynia", 300);
        City city5 = new City("Sopot", 150);
        list.add(city1);
        list.add(city2);
        list.add(city3);
        list.add(city4);
        list.add(city5);
        return list;
    }
}
