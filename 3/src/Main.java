import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = readFile();
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        //pt1
        ArrayList<Integer> oneCounter = createOneCounter();

        System.out.println(onePositions(list.get(0)));


        for (String s : list) {
            List<Integer> ones = onePositions(s);

            for (int index : ones) {
                Integer value = oneCounter.get(index);
                value = value + 1;
                oneCounter.set(index, value);
            }
        }

        for (Integer integer : oneCounter) {
            if (integer < list.size() / 2) {
                gamma.append("0");
                epsilon.append("1");
            } else {
                gamma.append("1");
                epsilon.append("0");
            }
        }

        System.out.println("Power consumption: " + Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2));

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

    static ArrayList<Integer> createOneCounter() {
        ArrayList<Integer> oneCounter = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            oneCounter.add(0);
        }
        return oneCounter;
    }

    static List<Integer> onePositions(String input) {

        int number = Integer.parseInt(input, 2);
        List<Integer> positions = new ArrayList<>();
        int position = input.length() - 1;
        while (number != 0) {
            if ((number & 1) != 0) {
                positions.add(position);
            }
            position--;
            number = number >>> 1;
        }
        return positions;
    }
}




