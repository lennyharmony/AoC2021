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
        //part1
        int result = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i-1)) result++;
        }

        System.out.println("Result: " + result);

        //part2
        int result2 = 0;

        for (int i = 0; i < list.size() - 3; i++) {
            int A = list.get(i) + list.get(i + 1) + list.get(i + 2);
            int B = list.get(i + 1) + list.get(i + 2) + list.get(i + 3);
            if (B > A) result2++;
        }
        System.out.println("WindowResult: " + result2);
    }
}


