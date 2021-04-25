package baseball.domain.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

final class BaseballNo {
    private static final int MAX_CACHE_SIZE = 10;
    private static final int START_BASEBALL_NO = 1;
    private static final int END_BASEBALL_NO = 9;
    public static final String ERROR_MESSAGE_UNEXPECTED_RANGE_NO = format("야구게임 숫자 범위는 %d ~ %d까지 입니다.", START_BASEBALL_NO, END_BASEBALL_NO);

    private final int baseballNo;

    private static final BaseballNo EMPTY = new BaseballNo(0);

    private static final List<BaseballNo> cached;
    static {
        cached = new ArrayList<>(MAX_CACHE_SIZE);
        cached.add(EMPTY);
        for (int no = START_BASEBALL_NO; END_BASEBALL_NO >= no; ++no){
            cached.add(new BaseballNo(no));
        }
    }

    private BaseballNo(int no) {
        this.baseballNo = no;
    }

    static BaseballNo valueOf(int no){
        if (isOutOfRange(no)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_UNEXPECTED_RANGE_NO);
        }
        return cached.get(no);
    }

    static List<BaseballNo> shuffleBaseballNos(){
        // 배열의 0번째 영역은 EMPTY객가 존재하하고, 나머지 배열의 인덱스는 1 ~ 9 까지 값으로 사용되므로
        // 랜덤으로 사용되는 1 ~ 9 까지의 값을 얻기 위해서 subList 생성함
        final List<BaseballNo> correctBaseballNos = cached.subList(START_BASEBALL_NO, cached.size());

        final List<BaseballNo> tempBaseballNosForShuffling = new ArrayList<>(correctBaseballNos);
        Collections.shuffle(tempBaseballNosForShuffling);

        return Collections.unmodifiableList(tempBaseballNosForShuffling);
    }

    static boolean isOutOfRange(int no) {
        return START_BASEBALL_NO > no || END_BASEBALL_NO < no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNo that = (BaseballNo) o;
        return baseballNo == that.baseballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(baseballNo);
    }

    @Override
    public String toString() {
        return Integer.toString(baseballNo);
    }
}
