package baseball.domain;

import java.util.*;

public class Baseball {
    private static final String SIZE_EXCEPTION = "자리수가 올바르지 않습니다. 세자리로 입력해주세요.";
    private static final String DUPLICATE_EXCEPTION = "중복된 숫자가 있습니다. 중복을 피해주세요.";
    private static final int BASEBALL_SIZE = 3;

    private final List<BaseballNo> baseball;


    private Baseball(List<BaseballNo> baseball) {
        validation(baseball);
        this.baseball = baseball;
    }

    private void validation(List<BaseballNo> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<BaseballNo> numbers) {
        if(numbers.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    private void validateDuplicate(List<BaseballNo> numbers) {
        Set<BaseballNo> baseballNumberSet = new HashSet<>(numbers);
        if (baseballNumberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    public static Baseball of(String numbers) {
        List<BaseballNo> baseball = new ArrayList<>();
        for(int i =0; i < numbers.length(); i++) {
            baseball.add(BaseballNo.of(numbers.charAt(i)));
        }
        return new Baseball(baseball);
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
            ball += checkBall(userBaseball.baseball, i);
            strike += checkStrike(userBaseball.baseball, i);
        }
        return new Result(Ball.of(ball), Strike.of(strike));
    }

    private int checkStrike (List<BaseballNo> baseballByUser, int idx) {
        if(baseball.get(idx).equals(baseballByUser.get(idx))){
            return 1;
        }
        return 0;
    }

    private int checkBall (List<BaseballNo> baseballByUser, int idx) {
        if(baseball.contains(baseballByUser.get(idx)) &&
                !baseball.get(idx).equals(baseballByUser.get(idx))) {
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
