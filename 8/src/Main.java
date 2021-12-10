import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();

        String[][][] inputArray = inputToArray(input);

        //pt 1
        solveOne(inputArray);

        String a = "abc";
        String b = "abcd";

        String[] test = {a, b};

//        System.out.println(containsCheckPosition("cd", test));

        solveTwo(inputArray);

//        b = b.replace("" + 'a', "");
//
//        System.out.println(b);
//        System.out.println(stringDiff(a, b));
//        System.out.println(stringDiff(stringDiff(a, b), b));


    }

    static String[][][] inputToArray(ArrayList<String> input) {
        String[][][] inputArray = new String[input.size()][2][];

        for (int i = 0; i < input.size(); i++) {
            String[] patterns = input.get(i).split("\\|")[0].split(" ");
            String[] outputs = input.get(i).split("\\|")[1].split(" ");
            inputArray[i][0] = patterns;
            inputArray[i][1] = outputs;
        }
        return inputArray;
    }

    static void solveOne(String[][][] input) {
        int count = 0;
        for (String[][] array : input) {

            for (String pattern : array[1]) {
                if (pattern.length() == 2 || pattern.length() == 3 || pattern.length() == 4 || pattern.length() == 7)
                    count++;
            }
        }
        System.out.println("Solution part 1 is: " + count);

    }

    static void solveTwo(String[][][] input) {
        String[] positions = new String[7];
        int answer = 0;

        for (String[][] array : input) {
            String[] patterns = array[0];
            String[] output = array[1];

            Dictionary numbers = new Hashtable();

            Arrays.sort(patterns, Comparator.comparingInt(String::length));
            patterns = sortStringArray(patterns);


            numbers.put("1", patterns[0]);
            numbers.put("7", patterns[1]);
            numbers.put("4", patterns[2]);
            numbers.put("8", patterns[9]);


            //search 6, 9 and 0
            for (int i = 6; i <= 8; i++) {
                if (!containCheck(numbers.get("1").toString(), patterns[i])) {
                    numbers.put("6", patterns[i]);
                } else if (containCheck(numbers.get("4").toString(), patterns[i])) {
                    numbers.put("9", patterns[i]);
                } else {
                    numbers.put("0", patterns[i]);
                }
            }


            //search 2, 3 and 5
            for (int i = 3; i <= 5; i++) {
                if (containCheck(numbers.get("1").toString(), patterns[i])) {
                    numbers.put("3", patterns[i]);
                } else if (containCheck(patterns[i], numbers.get("6").toString())) {
                    numbers.put("5", patterns[i]);
                } else {
                    numbers.put("2", patterns[i]);
                }
            }

            String answ = "";

            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j <= 9; j++) {

                    String number = numbers.get(Integer.toString(j)).toString();
                    if (number.length() == output[i].length() && containCheck(output[i], number)) {
                        answ += Integer.toString(j);

                    }
                }
            }
            answer += Integer.parseInt(answ);
        }
        System.out.println("Solution part 2 is: " + answer);
    }

    static String[] sortStringArray(String[] array) {
        String[] strArray = array;

        for (int i = 0; i < strArray.length; i++) {
            char[] charArray = strArray[i].toCharArray();
            Arrays.sort(charArray);
            strArray[i] = new String(charArray);
        }
        return strArray;
    }

    static boolean containCheck(String a, String b) {
        boolean result = true;

        for (int i = 0; i < a.length(); i++) {
            if (!b.contains(a.charAt(i) + "")) {
                result = false;
            }
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
