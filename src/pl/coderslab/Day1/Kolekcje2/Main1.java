package src.pl.coderslab.Day1.Kolekcje2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String value = "";
        int count = 0;
        while (!value.equals("exit")){
            System.out.println("Podaj wiadomość");
            value = scanner.nextLine();
            if(!value.equals("exit")){
                set.add(value);
            }
            if(!value.equals("exit")){
                count++;
            }

        }
        System.out.println("Podanych napisów: " + count + ", Rozmiar kolekcji: " + set.size());
    }
}
