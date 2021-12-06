import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();



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
