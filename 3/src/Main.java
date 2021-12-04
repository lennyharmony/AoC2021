import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = readFile();
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        int[] ones = countOnes(list);

        for (int one : ones) {
            if (one < list.size() / 2) {
                gamma.append("0");
                epsilon.append("1");
            } else {
                gamma.append("1");
                epsilon.append("0");
            }
        }
        System.out.println("Power consumption: " + Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2));

        //pt2

        String oxygenRating = getRating(list, true);
        String co2Rating = getRating(list, false);
        System.out.println("Oxygen generator rating: " + oxygenRating);
        System.out.println("CO2 scrubber rating: " + co2Rating);

        System.out.println("Life support rating: " + Integer.valueOf(oxygenRating, 2) * Integer.valueOf(co2Rating, 2));

    }

    static int[] countOnes(ArrayList<String> list) {
        int stringLength = list.get(0).length();
        int[] ones = new int[stringLength];

        for (String s : list) {
            int[] addOnes = new int[stringLength];

            for (int i = 0; i < stringLength; i++) {
                int input = Integer.parseInt(String.valueOf(s.charAt(i)));
                Array.set(addOnes, i, input);
            }
            ones = addArrays(ones, addOnes);
        }

        return ones;
    }

    static int[] addArrays(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + b[i];
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
            list.add(scanner.next());
        }
        return list;
    }

    static String getRating(ArrayList<String> list, boolean leastOrMost) {
        int[] ones = countOnes(list);
        char toKeep;

        for (int i = 0; i < ones.length; i++) {
            ones = countOnes(list);

            if (ones[i] >= list.size() * 0.5) {
                if (leastOrMost) {
                    toKeep = '1';
                } else {
                    toKeep = '0';
                }
            } else {
                if (leastOrMost) {
                    toKeep = '0';
                } else {
                    toKeep = '1';
                }
            }

            ArrayList<String> resultList = new ArrayList<>();
            for (String s : list) {
                if (s.charAt(i) == toKeep) {
                    resultList.add(s);
                }
            }
            list = resultList;

            if (list.size() == 1) {
                break;
            }
        }
        return list.get(0);
    }
}




