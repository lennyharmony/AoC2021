import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = readFile();
        ArrayList<Integer> numberCallList = getCallList(input);
        ArrayList<BingoBoard> boards = createBingoBoards(input);

        outerloop:
        for (int i = 0; i < numberCallList.size(); i++) {
            int boardIndex = 0;

            for (BingoBoard board : boards) {
                board.markNumber(numberCallList.get(i));
                if (Bingo.isBingo()) {
                    System.out.println("BINGO at board number: " + (boardIndex + 1));
                    System.out.println("Number called: " + numberCallList.get(i));
                    System.out.println("Sum of unmarked numbers: " + boards.get(boardIndex).sumOfNumbers());
                    System.out.println("FINAL SCORE: " + numberCallList.get(i) * boards.get(boardIndex).sumOfNumbers());
                    System.out.println("BOARD " + (boardIndex + 1));
                    for (int[] row : boards.get(boardIndex).getNumbers()) {
                        System.out.println(Arrays.toString(row));
                    }

                    break outerloop;
                }
                boardIndex++;
            }
        }


    }

    static ArrayList<String> readFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>();
        list.add(scanner.nextLine());

        while (true) {
            assert scanner != null;
            if (!scanner.hasNext()) break;
            list.add(scanner.nextLine());
        }
        return list;
    }

    static ArrayList<Integer> getCallList(ArrayList<String> input) {
        ArrayList<Integer> callList = new ArrayList<>();
        String[] elements = input.get(0).split(",");

        for (String element : elements) {
            callList.add(Integer.parseInt(element.trim()));
        }

        return callList;
    }

    static ArrayList<BingoBoard> createBingoBoards(ArrayList<String> input) {
        ArrayList<BingoBoard> bingoBoards = new ArrayList<>();
        int[][][] arrays = createArrays(input);
        for (int i = 0; i < arrays.length; i++) {
            bingoBoards.add(new BingoBoard(arrays[i]));
        }
        return bingoBoards;
    }

    static int[][][] createArrays(ArrayList<String> input) {
        input.remove(0);

        int[][][] result = new int[input.size() / 6][][];
        int index = 0;

        for (int i = 1; i < input.size(); i = i + 6) {
            int[][] array = new int[5][5];
            for (int j = 0; j < 5; j++) {
                String string = input.get(i + j);
                int[] row = stringToArray(string);
                array[j] = row;
            }
            result[index] = array;
            index++;
        }
        return result;

    }

    static int[] stringToArray(String str) {

        String[] splitArray = str.trim().split("\\s+");
        int[] array = new int[splitArray.length];

        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }


}
