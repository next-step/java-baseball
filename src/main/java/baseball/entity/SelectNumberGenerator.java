package baseball.entity;

public class SelectNumberGenerator {

    private final String generateNumber;

    public SelectNumberGenerator(String generateNumber) {
        this.generateNumber = generateNumber;
    }

    public SelectNumberGenerator() {
        this(initNumber());
    }

    private static String initNumber() {
        String generateNumber;
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() != 3) {
            generateNumber = randomNumber();
            appendNumber(generateNumber, stringBuilder);
        }

        return stringBuilder.toString();
    }

    private static String randomNumber() {
        return String.valueOf((int) (Math.random() * 9) + 1);
    }

    private static void appendNumber(String generateNumber, StringBuilder stringBuilder) {
        if (!stringBuilder.toString().contains(generateNumber)) {
            stringBuilder.append(generateNumber);
        }
    }

    public String getGenerateNumber() {
        return generateNumber;
    }

}
