public class BingoBoard {
    private final int[][] numbers;

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
        int testIndex = 0;
        for (int[] ints : numbers) {
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            if (sum == -5) {
                Bingo.setBingo(true);
                break;
            }
            testIndex++;
        }

        //check vertical
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = 0; j < numbers[i].length; j++) {
                sum += numbers[j][i];
            }
            if (sum == -5) {
                Bingo.setBingo(true);
            }
        }

        //check diagonal
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i][i];
        }
        if (sum == -5) {
            Bingo.setBingo(true);
        }
    }

    public int sumOfNumbers() {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] != -1) sum += numbers[i][j];
            }
        }
        return sum;
    }

    public int[][] getNumbers() {
        return numbers;
    }
}
