package baseball;

public class BaseballPosition {
    private final int val;

    private BaseballPosition(int val) {
        this.val = val;
    }

    public static BaseballPosition create(int val) {
        if (isNegative(val)) {
            throw new IllegalArgumentException("위치 값은 0 이상 이어야 합니다.");
        }

        return new BaseballPosition(val);
    }

    private static boolean isNegative(int position) {
        return position < 0;
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

        if (!(obj instanceof BaseballPosition)) {
            return false;
        }

        BaseballPosition target = (BaseballPosition) obj;
        return val == target.val;
    }
}
