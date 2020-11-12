package baseball.domain;

import java.util.*;

public class BaseballNo {
    private static final Map<Integer, BaseballNo> baseballNos = new HashMap<>();
    private final int no;

    static {
        for (int i = 1; i < 10; i++) {
            baseballNos.put(i, new BaseballNo(i));
        }
    }

    private BaseballNo(int no) {
        if(no < 1 || no > 10) {
            throw new IllegalArgumentException();
        }
        this.no = no;
    }

    public static BaseballNo of(int number) {
        return Optional.ofNullable(baseballNos.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNo that = (BaseballNo) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return "BaseballNo{" +
                "no=" + no +
                '}';
    }
}
