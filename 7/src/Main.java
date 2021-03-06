import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();

        String[] inputSplit = input.get(0).split(",");

        ArrayList<Integer> inputArray = new ArrayList<>();

        for (String s : inputSplit) {
            inputArray.add(Integer.parseInt(s));
        }
        //pt1
        System.out.println("Solution part 1: " + solveOne(inputArray));

        //pt2
        System.out.println("Solution part 2: " + solveTwo(inputArray));


    }

    static int solveOne(ArrayList<Integer> array) {
        int median;
        int length = array.size();
        Collections.sort(array);

        if (length % 2 == 0) {
            median = ((array.get(length / 2) + array.get(length / 2 + 1)) / 2);
        } else median = array.get(length / 2 + 1);

        int result = 0;
        for (Integer ints : array) {
            result += Math.abs(ints - median);
        }

        return result;
    }

    static int solveTwo(ArrayList<Integer> array) {
        Collections.sort(array);
        int maxValue = array.get(array.size() - 1);

        int minimum = Integer.MAX_VALUE;


        for (int i = 0; i <= maxValue; i++) {
            int tempMinimum = 0;

            for (Integer ints : array) {
                tempMinimum += Math.abs(ints - i) * (Math.abs(ints - i) + 1) / 2;
            }

            if (tempMinimum < minimum) {
                minimum = tempMinimum;
            }
            if (tempMinimum > minimum)
                break;
        }
        return minimum;

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
