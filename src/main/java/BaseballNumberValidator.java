import java.util.function.Predicate;

public class BaseballNumberValidator {
    public Boolean validateNumber(String numbers) {
        return isValidSize()
                .and(isNumeric())
                .and(hasDifferentNumbers())
                .test(numbers);
    }

    public Predicate<String> isValidSize() {
        return numbers -> numbers.length() == 3;
    }

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

    public Predicate<String> hasDifferentNumbers() {
        return numbers -> {
            String[] splitNumbers = numbers.split("");
            return !splitNumbers[0].equals(splitNumbers[1]) && !splitNumbers[0].equals(splitNumbers[2]) && !splitNumbers[1].equals(splitNumbers[2]);
        };
    }
}
