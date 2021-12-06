import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();
        String[] splitInput = input.get(0).split(",");
        ArrayList<Integer> intArray = new ArrayList<>();

        for (String s : splitInput) {
            int i = Integer.parseInt(s);
            intArray.add(i);
        }

        for (int day = 0; day < 80; day++) {
            checkFish(intArray);
        }
        System.out.println(intArray.size());

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

    static void checkFish(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == 0) {
                arrayList.set(i, 7);
                arrayList.add(9);
            }
            arrayList.set(i, arrayList.get(i) - 1);
        }
    }
}
