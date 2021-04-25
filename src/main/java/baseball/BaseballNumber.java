package baseball;

class BaseballNumber {
    private final int number;
    private final int position;

    private BaseballNumber(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public static BaseballNumber createByNumberAndPosition(int number, int position) {
        if (!isRangeOneToNine(number)) {
            throw new IllegalArgumentException("숫자의 범위는 1이상, 9이하 입니다.");
        }

        if (isNegative(position)) {
            throw new IllegalArgumentException("위치 값은 0 이상 이어야 합니다.");
        }

        return new BaseballNumber(number, position);
    }

    private static boolean isRangeOneToNine(int number) {
        return number >= 1 && number <= 9;
    }

    private static boolean isNegative(int position) {
        return position < 0;
    }

    @Override
    public int hashCode() {
        return number;
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
        return number == target.number && position == target.position;
    }
}
