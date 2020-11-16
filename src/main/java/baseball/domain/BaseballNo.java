package baseball.domain;

import java.util.*;

public class BaseballNo {
    private static final int BASEBALL_MIN_NUM = 1;
    private static final int BASEBALL_MAX_NUM = 9;

    private static final Map<Integer, BaseballNo> baseballNos = new HashMap<>();

    static {
        for (int i = BASEBALL_MIN_NUM; i <= BASEBALL_MAX_NUM; i++) {
            baseballNos.put(i, new BaseballNo(i));
        }
    }

    private final int no;

    private BaseballNo(int no) {
        validation(no);
        this.no = no;
    }

    public static BaseballNo of(char number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException();
        }

        return of(Integer.parseInt(String.valueOf(number)));
    }

    public static BaseballNo of(int number) {
        validation(number);
        return Optional.ofNullable(baseballNos.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    private static void validation(int number) {
        if(number < BASEBALL_MIN_NUM || number > BASEBALL_MAX_NUM) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요. ERROR: " + number);
        }
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
