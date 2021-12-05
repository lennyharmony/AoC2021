public class BingoBoard {
    private final int[][] numbers;
    private boolean bingo = false;

    public BingoBoard(int[][] numbers) {
        this.numbers = numbers;
    }

    public void markNumber(int number) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] == number) {
                    numbers[i][j] = -1;
                }
            }
        }
        //check horizontal
        for (int[] ints : numbers) {
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            if (sum == -5) {
                bingo = true;
                break;
            }
        }

        //check vertical
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = 0; j < numbers[i].length; j++) {
                sum += numbers[j][i];
            }
            if (sum == -5) bingo = true;
        }

        //check diagonal1
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i][i];
        }
        if (sum == -5) {
            bingo = true;
        }

        int sum2 = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            for (int j = 0; j < numbers.length; j++) {
                sum2 += numbers[i][j];
            }
            if (sum2 == -5) {
                bingo = true;
            }
        }

    }

    public int sumOfNumbers() {
        int sum = 0;

        for (int[] number : numbers)
            for (int j = 0; j < numbers[0].length; j++) {
                if (number[j] != -1) sum += number[j];
            }
        return sum;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public boolean isBingo() {
        return bingo;
    }
}
