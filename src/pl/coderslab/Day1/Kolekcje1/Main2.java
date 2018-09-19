package src.pl.coderslab.Day1.Kolekcje1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int divider = 3;
        List<Integer> resultList = removeDivider(list, divider);
        for (Integer number : resultList) {
            System.out.println(number);
        }
    }

    public static List<Integer> removeDivider(List<Integer> list, int divider) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            int number = it.next();
            if(number % divider == 0){
                it.remove();
            }
        }
        return list;
    }
}
