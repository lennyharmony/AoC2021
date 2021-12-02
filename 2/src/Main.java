import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<String> list = readFile();

        //part1
        int hor = 0;
        int depth = 0;

        for (int i = 0; i < list.size(); i = i + 2) {
            String cmd = list.get(i);
            int amt = Integer.parseInt(list.get(i+1));
            switch (cmd) {
                case "forward":
                    hor += amt;
                    break;
                case "down":
                    depth += amt;
                    break;
                case "up":
                    depth -= amt;
                    break;
            }
        }
        System.out.println(hor * depth);


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

