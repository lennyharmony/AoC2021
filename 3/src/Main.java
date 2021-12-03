import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<String> list = readFile();

        //pt1
        int length = list.size();

        







    }

    static ArrayList<String> readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));

        ArrayList<String> list = new ArrayList<>();

        while(scanner.hasNext())
        {
            list.add(scanner.next());
        }
        return list;
    }

}
