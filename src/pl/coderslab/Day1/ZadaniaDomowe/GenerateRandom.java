package src.pl.coderslab.Day1.ZadaniaDomowe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class GenerateRandom {

    public static void main(String[] args) {
        int amount = 5000;
        int interval = 10;
        Map<Integer, Integer> map = checkRand(amount, interval);
        for (int i = 0; i < interval; i++) {
            System.out.println(i + " : " + map.get(i));
        }
    }

    public static Map<Integer, Integer> checkRand(int amount, int interval){
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            int randomNumber = random.nextInt(interval);
            if(!map.containsKey(randomNumber)){
                int counter = 1;
                map.put(randomNumber, counter);
            } else if(map.containsKey(randomNumber)){
                int counter = map.get(randomNumber);
                map.remove(randomNumber);
                counter++;
                map.put(randomNumber, counter);
            }
        }
        return map;
    }
}
