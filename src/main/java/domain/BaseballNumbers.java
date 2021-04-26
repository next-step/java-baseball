package domain;

import utils.UtilMeassage;

import java.util.*;

public class BaseballNumbers {

    private static final int BASEBALL_SIZE = 3;

    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validation(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validation(List<BaseballNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<BaseballNumber> numbers) {
        if(numbers.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(UtilMeassage.BASEBALL_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicate(List<BaseballNumber> numbers) {
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(numbers);
        if (baseballNumberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(UtilMeassage.BASEBALL_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public static BaseballNumbers of(String numbers) {
        List<BaseballNumber> baseball = new ArrayList<>();
        for(int i =0; i < numbers.length(); i++) {
            baseball.add(BaseballNumber.of(numbers.charAt(i)));
        }
        return new BaseballNumbers(baseball);
    }

    public static BaseballNumbers of(List<Integer> numbers) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            baseballNumbers.add(BaseballNumber.of(number));
        }
        return new BaseballNumbers(baseballNumbers);
    }

    public BaseballResult match(BaseballNumbers userBaseball) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < BASEBALL_SIZE; i++) {
            ball += checkBall(userBaseball.baseballNumbers, i);
            strike += checkStrike(userBaseball.baseballNumbers, i);
        }
        return new BaseballResult(Ball.of(ball), Strike.of(strike));
    }

    private int checkStrike (List<BaseballNumber> baseballByUser, int idx) {
        if(baseballNumbers.get(idx).equals(baseballByUser.get(idx))){
            return 1;
        }
        return 0;
    }

    private int checkBall (List<BaseballNumber> baseballByUser, int idx) {
        if(baseballNumbers.contains(baseballByUser.get(idx)) &&
                !baseballNumbers.get(idx).equals(baseballByUser.get(idx))) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumbers baseball1 = (BaseballNumbers) o;
        return Objects.equals(baseballNumbers, baseball1.baseballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumbers);
    }

    @Override
    public String toString() {
        return "BaseballNumbers{" +
                "baseballNumbers=" + baseballNumbers +
                '}';
    }
}
