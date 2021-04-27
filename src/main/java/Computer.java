import java.util.*;

public class Computer {

    public static final int NUMBERS_LENGTH = 3;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;

    private Set<Integer> numbers;
    private final Random random = new Random();

    public void initializeNewNumbers() {
        numbers = new HashSet<>();

        while (numbers.size() < NUMBERS_LENGTH) {
            numbers.add(generateRandomNaturalNumber());
        }
    }

    private int generateRandomNaturalNumber() {
        return random.nextInt(MAX_NUMBER) + MIN_NUMBER;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    public HintResult generateResult(String answer) {
        validateAnswer(answer);

        HintResult hintResult = new HintResult();
        List<Integer> numbersToList = new ArrayList<>(numbers);
        List<Integer> answerToList = new ArrayList<>();

        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            String answerNumber = String.valueOf(answer.toCharArray()[i]);
            answerToList.add(Integer.valueOf(answerNumber));
        }

        for (int i = 0; i < numbersToList.size(); i++) {
            Integer numberOfAnswer = answerToList.get(i);
            if (!numbersToList.contains(numberOfAnswer)) {
                continue;
            }

            if (numbersToList.get(i).equals(numberOfAnswer)) {
                hintResult.increaseStrikeCount();
                continue;
            }

            hintResult.increaseBallCount();
        }
        return hintResult;
    }

    private void validateAnswer(String answer) {
        if (answer == null) {
            throw new IllegalArgumentException("제시한 수가 null일 수 없습니다.");
        }
        validateAnswerLength(answer);
        validateIsAnswerConsistOfNaturalNumber(answer);
        validateIsAnswerConsistOfUniqueNumber(answer);
    }

    private void validateAnswerLength(String answer) {
        if (answer.length() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(String.format("제시한 수는 %d자리 수 이어야 합니다.", NUMBERS_LENGTH));
        }
    }

    private void validateIsAnswerConsistOfNaturalNumber(String answer) {
        for (char number : answer.toCharArray()) {
            validateNaturalNumber(number);
        }
    }

    private void validateNaturalNumber(char charNumber) {
        int number = Integer.parseInt(String.valueOf(charNumber));
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("제시한 수는 자연수로 이루어져야 합니다.");
        }
    }

    private void validateIsAnswerConsistOfUniqueNumber(String answer) {
        Set<Character> numberSet = new HashSet<>();
        for (char number : answer.toCharArray()) {
            numberSet.add(number);
        }

        if (answer.length() != numberSet.size()) {
            throw new IllegalArgumentException("제시한 수는 서로 다른 숫자로 이루어져야 합니다.");
        }
    }
}