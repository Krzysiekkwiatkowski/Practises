package src.pl.coderslab.Day1.WyrażeniaRegularne;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
    public static void main(String[] args) {
        List<String> operations = new ArrayList<>();
        String calculete = "";
        Scanner scanner = new Scanner(System.in);
        while (!calculete.equals("quit")) {
            System.out.println("Wpisz działanie lub quit");
            calculete = scanner.nextLine();
            if (!calculete.equals("quit") && verify(calculete)) {
                StringTokenizer stringTokenizer = new StringTokenizer(calculete, " ");
                ArrayList<Integer> numbers = new ArrayList<>();
                ArrayList<Character> marks = new ArrayList<>();
                String noWhite = "";
                int firstMultiply = 0;
                int firstDivide = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    noWhite += stringTokenizer.nextToken();
                }
                for (int i = 0; i < noWhite.length(); i++) {
                    if (noWhite.charAt(i) == '+' || noWhite.charAt(i) == '-' || noWhite.charAt(i) == '/' || noWhite.charAt(i) == '*') {
                        char mark = noWhite.charAt(i);
                        marks.add(mark);
                    }
                }
                StringTokenizer stringTokenizer1 = new StringTokenizer(noWhite, "+-/*");
                while (stringTokenizer1.hasMoreTokens()) {
                    numbers.add(Integer.parseInt(stringTokenizer1.nextToken()));
                }
                if(marks.contains('*') || marks.contains('/')){
                    if(marks.contains('*')){
                        firstMultiply = noWhite.indexOf('*');
                    } else {
                        firstDivide = noWhite.indexOf('/');
                    }
                }
                int firstResult = 0;
                int lastResult = 0;
                if(firstMultiply != 0 && noWhite.contains("+") && noWhite.indexOf("*") > noWhite.indexOf("+")){
                    firstResult = numbers.get(numbers.size()-2) * numbers.get(numbers.size()-1);
                    lastResult = numbers.get(0) + firstResult;
                } else if (firstMultiply != 0 && noWhite.contains("+") && noWhite.indexOf("*") < noWhite.indexOf("+")){
                    firstResult = numbers.get(0) * numbers.get(1);
                    lastResult = numbers.get(2) + firstResult;
                }
                if(firstMultiply != 0 &&  noWhite.contains("-") && noWhite.indexOf("*") > noWhite.indexOf("-")){
                    firstResult = numbers.get(numbers.size()-2) * numbers.get(numbers.size()-1);
                    lastResult = numbers.get(0) - firstResult;
                } else if(firstMultiply != 0 && noWhite.contains("-") && noWhite.indexOf("*") < noWhite.indexOf("-")){
                    firstResult = numbers.get(0) * numbers.get(1);
                    lastResult = firstResult - numbers.get(2);
                }
                if(firstDivide != 0 && noWhite.contains("+") && noWhite.indexOf("/") > noWhite.indexOf("+")){
                    firstResult = numbers.get(numbers.size()-2) / numbers.get(numbers.size()-1);
                    lastResult = numbers.get(0) + firstResult;
                } else if (firstDivide != 0 && noWhite.contains("+") && noWhite.indexOf("/") < noWhite.indexOf("+")){
                    firstResult = numbers.get(0) / numbers.get(1);
                    lastResult = numbers.get(2) + firstResult;
                }
                if(firstDivide != 0 &&  noWhite.contains("-") && noWhite.indexOf("/") > noWhite.indexOf("-")){
                    firstResult = numbers.get(numbers.size()-2) / numbers.get(numbers.size()-1);
                    lastResult = numbers.get(0) - firstResult;
                } else if(firstDivide != 0 && noWhite.contains("-") && noWhite.indexOf("/") < noWhite.indexOf("-")){
                    firstResult = numbers.get(0) / numbers.get(1);
                    lastResult = firstResult - numbers.get(2);
                }
                if(firstMultiply == 0 && firstDivide == 0){
                    for (int i = 0; i < 1; i++) {
                        if(marks.get(i) == '+'){
                            firstResult = numbers.get(i) + numbers.get(i+1);
                            if(numbers.size() == 3){
                                if(marks.get(i+1) == '+'){
                                    lastResult = firstResult + numbers.get(2);
                                } else {
                                    lastResult = firstResult - numbers.get(2);
                                }
                            }
                        }
                        if(marks.get(i) == '-'){
                            firstResult = numbers.get(i) - numbers.get(i+1);
                            if(numbers.size() == 3){
                                if(marks.get(i+1) == '+'){
                                    lastResult = firstResult + numbers.get(2);
                                } else {
                                    lastResult = firstResult - numbers.get(2);
                                }
                            }
                        }
                    }
                }
                if(numbers.size() == 2){
                    if(marks.get(0) == '+'){
                        lastResult = numbers.get(0) + numbers.get(1);
                    }
                    if(marks.get(0) == '-'){
                        lastResult = numbers.get(0) - numbers.get(1);
                    }
                    if(marks.get(0) == '/'){
                        lastResult = numbers.get(0) / numbers.get(1);
                    }
                    if(marks.get(0) == '*'){
                        lastResult = numbers.get(0) * numbers.get(1);
                    }
                }
                operations.add(calculete + " = " + lastResult);
            }
        }
        try {
            PrintWriter printWriter = new PrintWriter("operations.txt");
            for (String line : operations) {
                printWriter.println(line);
            }
            printWriter.close();
        } catch (FileNotFoundException e){
            System.out.println("Nie znaleziono pliku");
        }
    }

    public static boolean verify(String calculate) {
        String regex = "[0-9]+\\s*[+-\\/\\*]{1}+\\s*[0-9]+(\\s*[+-\\/\\*]{1}+\\s*[0-9]*)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(calculate);
        return matcher.matches();
    }
}
