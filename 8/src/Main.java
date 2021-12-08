import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();

        String[][][] inputArray = inputToArray(input);

        //pt 1
        solveOne(inputArray);

        
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
