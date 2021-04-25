import java.util.function.Predicate;

/**
 * 베이스볼 숫자 검증기
 */
public class BaseballNumberValidator {
    public Boolean validateNumber(String numbers) {
        return isValidSize()
                .and(isNumeric())
                .and(hasDifferentNumbers())
                .test(numbers);
    }

    /**
     * 길이가 3인지 판단
     * @return
     */
    public Predicate<String> isValidSize() {
        return numbers -> numbers.length() == 3;
    }

    /**
     * 숫자인지 판단
     * @return
     */
    public Predicate<String> isNumeric() {
        return numbers -> validateIsNumeric(numbers);
    }

    private boolean validateIsNumeric(String numbers) {
        try {
            Integer.parseInt(numbers);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 서로 다른 숫자인지 판단
     * @return
     */
    public Predicate<String> hasDifferentNumbers() {
        return numbers -> {
            String[] splitNumbers = numbers.split("");
            return !splitNumbers[0].equals(splitNumbers[1]) && !splitNumbers[0].equals(splitNumbers[2]) && !splitNumbers[1].equals(splitNumbers[2]);
        };
    }
}
