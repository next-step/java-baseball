package baseball;

class BaseballNumber {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private final int val;

    private BaseballNumber(int val) {
        this.val = val;
    }

    public static BaseballNumber create(int number) {
        if (!isRangeOneToNine(number)) {
            throw new IllegalArgumentException("숫자의 범위는 1이상, 9이하 입니다.");
        }

        return new BaseballNumber(number);
    }

    private static boolean isRangeOneToNine(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }



    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BaseballNumber)) {
            return false;
        }

        BaseballNumber target = (BaseballNumber) obj;
        return val == target.val;
    }
}
