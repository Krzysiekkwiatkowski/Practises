package src.pl.coderslab.Day1.ZadaniaDomowe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {
    public static void main(String[] args) {
        try {
            Map<Integer, Double> payments = new HashMap<>();
            Map<Integer, String> peolpe = new HashMap<>();
            File file = new File("earnings.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String person = scanner.nextLine();
                if (!cantBeFired(person) && isAPerson(person)) {
                    String name = "";
                    double payment = 0.00;
                    StringTokenizer stringTokenizer = new StringTokenizer(person, " ,;");
                    while (stringTokenizer.hasMoreTokens()) {
                        String word = stringTokenizer.nextToken();
                        for (int i = 0; i < word.length(); i++) {
                            char letter = word.charAt(i);
                            if (Character.isUpperCase(letter)) {
                                name += word + " ";
                            }
                        }
                        try {
                            if (Double.parseDouble(word) != 0.0) {
                                payment = Double.parseDouble(word);
                            }
                        } catch (NumberFormatException e) {
                            continue;
                        }
                    }
                    payments.put(payments.size(), payment);
                    peolpe.put(peolpe.size(), name);
                }
            }
            int[] sortId = new int[peolpe.size()];
            for (int i = 0; i < payments.size(); i++) {
                for (int j = 0; j < payments.size()-1; j++) {
                    if (payments.get(j) < payments.get(j + 1)) {
                        String oldPerson = peolpe.get(j);
                        double oldPayment = payments.get(j);
                        String newPerson = peolpe.get(j + 1);
                        double newPayment = payments.get(j + 1);
                        payments.put(j, newPayment);
                        payments.put(j + 1, oldPayment);
                        peolpe.put(j, newPerson);
                        peolpe.put(j + 1, oldPerson);
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(peolpe.get(i) + " " + payments.get(i) + "0 zł");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }

    public static boolean cantBeFired(String person) {
        String regex = ".*(Kowalsk)[a,i]{1}.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(person);
        return matcher.find();
    }

    public static boolean isAPerson(String person) {
        String regex = "(pracę){1}|(zlecenie){1}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(person);
        return matcher.find();
    }
}
