import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();

        solveOne(input);

    }

    static void solveOne(ArrayList<String> input) {
        String polymer = input.get(0);

        Hashtable<String, String> table = new Hashtable<>();

        for (int i = 1; i < input.size(); i++) {
            String[] temp = input.get(i).split("->");
            table.put(temp[0].trim(), temp[1].trim());
        }

        polymer = polymerSteps(polymer, table, 10);
        Hashtable<Character, Integer> charMap = mapChars(polymer);

        int max = Collections.max(charMap.values());
        int min = Collections.min(charMap.values());

        System.out.println("Solution part 1: " + (max - min));

    }

    public static String polymerSteps(String polymer, Hashtable<String, String> table, int steps) {
        for (int i = 0; i < steps; i++) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < polymer.length() - 1; j++) {
                String temp = polymer.charAt(j) + String.valueOf(polymer.charAt(j + 1));
                result.append(polymer.charAt(j));
                if (table.containsKey(temp)) {
                    result.append(table.get(temp));
                }
            }
            result.append(polymer.charAt(polymer.length() - 1));
            polymer = result.toString();
        }
        return polymer;
    }

    public static Hashtable<Character, Integer> mapChars(String polymer) {
        Hashtable<Character, Integer> result = new Hashtable<>();

        for (int i = 0; i < polymer.length(); i++) {
            char key = polymer.charAt(i);
            int count = result.getOrDefault(key, 0);
            result.put(key, count + 1);
        }
        return result;
    }

    static ArrayList<String> readFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            assert scanner != null;
            if (!scanner.hasNext()) break;
            list.add(scanner.nextLine());
        }
        return list;
    }
}
