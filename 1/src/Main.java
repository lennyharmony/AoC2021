import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("input.txt"));

        ArrayList<Integer> list = new ArrayList<>();

        while(scanner.hasNextInt())
        {
            list.add(scanner.nextInt());
        }
    }
}


