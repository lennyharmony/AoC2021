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

        int result = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i-1)) result++;
        }
        
        System.out.println("Result: " + result);
    }
}


