import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        try {
            list = Files.readAllLines(Paths.get("input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Integer> intList = new ArrayList<>();
        intList = getIntegerArray(list);


        int result = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= list.get(i-1)) result++;
        }
    }

    private static ArrayList<Integer> getIntegerArray(ArrayList<String> stringArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
                System.out.println("Could not parse " + nfe);
            }
        }
        return result;
    }
}


