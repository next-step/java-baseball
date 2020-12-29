public class BaseballGameNumberComparator {

    private int lengthOfNumber;

    public BaseballGameNumberComparator(int lengthOfNumber) {
        this.lengthOfNumber = lengthOfNumber;
    }

    public int getBall(int x, int y) {
        int count = 0;
        boolean[] check = new boolean[10];
        for (int i = 0; i < this.lengthOfNumber; i++) {
            count += checkFirstDigit(check, x);
            count += checkFirstDigit(check, y);
            x /= 10;
            y /= 10;
        }
        return count - getStrike(x, y);
    }

    public int checkFirstDigit(boolean[] check, int num) {
        if(check[num % 10]) {
            return 0;
        }
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
