package src.pl.coderslab.Day1.Kolekcje1;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        List<City> list = initialize();
        List<City> resultList = list.subList(1,4);
        for (City city : resultList) {
            System.out.println(city.getName() + " liczy " + city.getPopulation() + " tysięcy mieszkańców.");
        }
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

    public static List<City> sublist(List<City> list, int start, int end ){
        return list.subList(start, end);
    }
}
