package baseball;

import java.util.*;

public class BaseballDigitGenerator {

    private final List<String> availableCharList;
    private final int digits;

    public BaseballDigitGenerator(List<String> availableCharList, int digits) {
        this.availableCharList = availableCharList;
        this.digits = digits;
    }

    List<String> generateRandomDigits(Random random) {
        List<String> shuffledList = getShuffledAvailableCharList(random);
        List<String> randomDigits = new ArrayList<>();
        for (int index = 0; index < this.digits; index++) {
            randomDigits.add(shuffledList.get(index));
        }
        return randomDigits;
    }

    private List<String> getShuffledAvailableCharList(Random random) {
        List<String> shuffledChars = new ArrayList<>(this.availableCharList);
        Collections.shuffle(shuffledChars, random);
        return shuffledChars;
    }

    public List<String> generateDigitsByUserInput() {
        Scanner scanner = new Scanner(System.in);
        String guide = createGuideMessage(this.availableCharList, this.digits);
        String input;
        do {
            System.out.println(guide);
            input = scanner.next();
        } while (!isValidateInput(input, this.availableCharList, this.digits));
        return Arrays.asList(input.split(""));
    }

    static boolean isValidateInput(String input, List<String> availableCharList, int digits) {
        boolean isLengthEqual = isLengthEqual(input, digits);
        boolean hasOnlyAvailableCharsEachOnce = hasOnlyAvailableCharsEachOnce(input, availableCharList);
        return isLengthEqual && hasOnlyAvailableCharsEachOnce;
    }

    private static boolean isLengthEqual(String input, int length) {
        return input.length() == length;
    }

    private static boolean hasOnlyAvailableCharsEachOnce(String input, List<String> availableCharList) {
        try {
            List<String> splitInput = Arrays.asList(input.split(""));
            List<String> removableCharList = new ArrayList<>(availableCharList);
            splitInput.forEach(s -> removeIfContain(s, removableCharList));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static <T> void removeIfContain(T element, List<T> list) {
        if (list.contains(element)) {
            list.remove(element);
            return;
        }

        throw new IllegalArgumentException("has not removable element!");
    }

    static String createGuideMessage(Iterable<String> availableChars, int digits) {
        String elementInfos = String.join(",", availableChars);
        return String.format("문자를 %d자리 입력해주세요. 가능한 문자는 다음과 같습니다.(%s)", digits, elementInfos);
    }
}
