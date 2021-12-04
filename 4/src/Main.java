import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();
        ArrayList<Integer> numberCallList = getCallList(input);
        



    }

    static ArrayList<String> readFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>();
        list.add(scanner.nextLine());

        while (true) {
            assert scanner != null;
            if (!scanner.hasNext()) break;
            list.add(scanner.nextLine());
        }
        return list;
    }

    static ArrayList<Integer> getCallList(ArrayList<String> input) {
        ArrayList<Integer> callList = new ArrayList<>();
        String[] elements = input.get(0).split(",");

        for (String element : elements) {
            callList.add(Integer.parseInt(element.trim()));
        }

        return callList;
    }
}
