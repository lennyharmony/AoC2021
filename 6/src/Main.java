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

        long[] fishCount = initialFishCount(intArray);

        System.out.println(countFishAfterDays(fishCount, 256));
        
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


    static long countFishAfterDays(long[] fish, int days) {

        for (int i = 1; i <= days; i++) {
            long children = fish[0];

            System.arraycopy(fish, 1, fish, 0, fish.length - 1);
            fish[8] = children;
            fish[6] += children;
        }

        long amountOfFish = 0;
        for (long amt : fish) {
            amountOfFish += amt;
        }
        return amountOfFish;

    }

    static long[] initialFishCount(ArrayList<Integer> ints) {
        long[] result = new long[9];

        for (int fish : ints) {
            result[fish]++;
        }
        return result;
    }
}
