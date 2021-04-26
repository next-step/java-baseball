package baseball.entity;

import baseball.util.ValidateNumberUtil;

public class SelectNumberGenerator {

    private final String generateNumber;

    private static final int GENERATE_START_NUMBER = 1;
    private static final int GENERATE_END_NUMBER = 9;

    public SelectNumberGenerator(String generateNumber) {
        this.generateNumber = generateNumber;
    }

    public SelectNumberGenerator() {
        this(initNumber());
    }

    private static String initNumber() {
        String generateNumber;
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() != ValidateNumberUtil.NUMBER_LENGTH) {
            generateNumber = randomNumber();
            appendNumber(generateNumber, stringBuilder);
        }

        return stringBuilder.toString();
    }

    private static String randomNumber() {
        return String.valueOf((int) (Math.random() * GENERATE_END_NUMBER) + GENERATE_START_NUMBER);
    }

    private static void appendNumber(String generateNumber, StringBuilder stringBuilder) {
        if (!stringBuilder.toString().contains(generateNumber)) {
            stringBuilder.append(generateNumber);
        }
    }

    public String generateNumber() {
        return generateNumber;
    }

}
