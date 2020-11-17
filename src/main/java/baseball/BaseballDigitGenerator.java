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

    List<String> generateDigitsByUserInput() {
        Scanner scanner = new Scanner(System.in);
        String guide = createGuideMessage(this.availableCharList, this.digits);
        System.out.println(guide);
        String input = scanner.next();
        return Arrays.asList(input.split(""));
    }

    static String createGuideMessage(Iterable<String> availableChars, int digits) {
        String elementInfos = String.join(",", availableChars);
        return String.format("문자를 %d자리 입력해주세요. 가능한 문자는 다음과 같습니다.(%s)", digits, elementInfos);
    }
}
