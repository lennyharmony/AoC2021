import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();
        int[][] grid = createGrid(input);

        solveOne(grid);


    }

    static int[][] createGrid(ArrayList<String> input) {
        int[][] grid = new int[input.size()][input.get(0).length()];

        for (int i = 0; i < input.size(); i++) {
            String[] temp = input.get(i).split("");

            for (int j = 0; j < input.get(0).length(); j++) {
                grid[i][j] = Integer.parseInt(temp[j]);
            }
        }

        return grid;
    }

    static void solveOne(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                boolean lowest = true;
                if (j != 0) {
                    if (grid[i][j] >= grid[i][j - 1]) lowest = false;
                }
                if (j != grid[i].length - 1) {
                    if (grid[i][j] >= grid[i][j + 1]) lowest = false;
                }
                if (i != 0) {
                    if (grid[i][j] >= grid[i - 1][j]) lowest = false;
                }
                if (i != grid.length - 1) {
                    if (grid[i][j] >= grid[i + 1][j]) lowest = false;
                }


                if (lowest) {

                    answer += grid[i][j] + 1;
                }
            }

        }
        System.out.println("Solution to pt1: " + answer);


    }

    static int[] removeXCandidates(int[] row) {


        return row;

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
