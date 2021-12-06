import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();
        int[][][] arrays = getArray(input);

        int maxValue = getMaxValue(arrays);

        int[][] grid = new int[maxValue + 1][maxValue + 1];

        fillGrid(grid, arrays);

        System.out.println("Overlapping points: " + countOverlap(grid));

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

    static int[][][] getArray(ArrayList<String> input) {
        int[][][] result = new int[input.size()][2][2];

        for (int i = 0; i < input.size(); i++) {
            String[] firstSplit = input.get(i).split(" -> ");
            String[] firstCoord = firstSplit[0].split(",");
            String[] secondCoord = firstSplit[1].split(",");

            result[i][0][0] = Integer.parseInt(firstCoord[0]);
            result[i][0][1] = Integer.parseInt(firstCoord[1]);
            result[i][1][0] = Integer.parseInt(secondCoord[0]);
            result[i][1][1] = Integer.parseInt(secondCoord[1]);

        }
        return result;
    }

    static int getMaxValue(int[][][] arrays) {
        int maxValue = 0;

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                for (int k = 0; k < arrays[i][j].length; k++) {
                    if (arrays[i][j][k] > maxValue) maxValue = arrays[i][j][k];
                }
            }
        }
        return maxValue;
    }

    static void fillGrid(int[][] grid, int[][][] arrays) {

        for (int i = 0; i < arrays.length; i++) {

            if (arrays[i][0][1] == arrays[i][1][1]) { //horizontal line
                drawHorizontal(grid, arrays[i]);
            }

            if (arrays[i][0][0] == arrays[i][1][0]) { //vertical line
                drawVertical(grid, arrays[i]);
            }
        }
    }


    static void drawHorizontal(int[][] grid, int[][] coords) {
        int startX = Math.min(coords[0][0], coords[1][0]);
        int yCoord = coords[0][1];
        int length = Math.abs(coords[0][0] - coords[1][0]) + 1;
        for (int i = 0; i < length; i++) {
            grid[startX + i][yCoord] += 1;
        }

    }

    static void drawVertical(int[][] grid, int[][] coords) {
        int startY = Math.min(coords[0][1], coords[1][1]);
        int xCoord = coords[0][0];
        int length = Math.abs(coords[0][1] - coords[1][1]) + 1;
        for (int i = 0; i < length; i++) {
            grid[xCoord][startY + i] += 1;
        }

    }

    static int countOverlap(int[][] grid) {
        int counter = 0;
        for (int[] ints : grid) {
            for (int i : ints) {
                if (i >= 2) counter++;
            }
        }
        return counter;
    }


}
