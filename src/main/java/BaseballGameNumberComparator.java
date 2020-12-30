public class BaseballGameNumberComparator {

    private int lengthOfNumber;

    public BaseballGameNumberComparator(int lengthOfNumber) {
        this.lengthOfNumber = lengthOfNumber;
    }

    public int getBall(int x, int y) {
        int ball = lengthOfNumber * 2;
        boolean[] check = new boolean[10];
        for (int i = 0; i < this.lengthOfNumber; i++) {
            ball -= checkDigit(check, x, i);
            ball -= checkDigit(check, y, i);
        }
        return ball - getStrike(x, y);
    }

    public int checkDigit(boolean[] check, int num, int index) {
        int digit = (num / (int)Math.pow(10, index)) % 10;
        if (check[digit]) {
            return 0;
        }
        check[digit] = true;
        return 1;
    }

    public int getStrike(int x, int y) {
        int strike = 0;
        for (int i = 0; i < this.lengthOfNumber; i++) {
            strike += compareFirstDigit(x, y);
            x /= 10;
            y /= 10;
        }
        return strike;
    }

    public int compareFirstDigit(int x, int y) {
        if (x % 10 == y % 10) {
            return 1;
        }
        return 0;
    }
}
