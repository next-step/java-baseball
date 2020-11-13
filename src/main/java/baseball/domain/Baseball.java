package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Baseball {
    private static final int BASEBALL_SIZE = 3;

    private final List<BaseballNo> baseball;


    private Baseball(List<BaseballNo> baseball) {
        if(baseball.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException();
        }
        this.baseball = baseball;
    }

    public static Baseball of(List<Integer> numbers) {
        List<BaseballNo> baseball = new ArrayList<>();
        for (Integer number : numbers) {
            baseball.add(BaseballNo.of(number));
        }
        return new Baseball(baseball);
    }

    public Result match(Baseball userBaseball) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < BASEBALL_SIZE; i++) {
            ball += checkBall(userBaseball.baseball.get(i)); // 비교대상만 있으면 되지
            strike += checkStrike(userBaseball.baseball, i); // 자리수까지 필요해.
        }
        ball = ball - strike;
        return new Result(ball, strike);

    }
    private int checkStrike (List<BaseballNo> baseballByUser, int idx) {
        if(baseballByUser.get(idx).equals(baseball.get(idx))){
            return 1;
        }
        return 0;
    }
    private int checkBall (BaseballNo baseballNo) {
        if(baseball.contains(baseballNo)){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball1 = (Baseball) o;
        return Objects.equals(baseball, baseball1.baseball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseball);
    }

    @Override
    public String toString() {
        return "Baseball{" +
                "baseball=" + baseball +
                '}';
    }
}
