import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = readFile();
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        int[] ones = countOnes(list);

        for (int i = 0; i < ones.length; i++) {
            if (ones[i] < list.size() / 2) {
                gamma.append("0");
                epsilon.append("1");
            } else {
                gamma.append("1");
                epsilon.append("0");
            }
        }
        System.out.println("Power consumption: " + Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2));

        //pt 2


        for (int i = 0; i < list.get(0).length(); i++) {
            ones = countOnes(list);
            if (ones[i] >=)
        }

    }

    static int[] countOnes(ArrayList<String> list) {
        int stringLength = list.get(0).length();
        int[] ones = new int[stringLength];

        for (int i = 0; i < ones.length; i++) {
            ones[i] = 0;
        }
        System.out.println(Arrays.toString(ones));

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

   
}




