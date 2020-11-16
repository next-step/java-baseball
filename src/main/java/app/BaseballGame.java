package app;

import java.util.HashSet;
import java.util.Set;

/**
 * 숫자야구 메인 클래스
 */
public class BaseballGame {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final Set<Integer> generateNumbers = new HashSet<>();
    private final String[] generateNumberArray = new String[InputValidator.MAX_LENGTH];

    public BaseballGame() {
        setGenerateNumber();
    }

    /**
     * 임의로 생성한 숫자 set 리턴
     *
     * @return Set
     */
    public Set<Integer> getGenerateNumber() {
        return generateNumbers;
    }

    /**
     * 임의로 생성한 숫자 배열 리턴
     * @return String[]
     */
    public String[] getGenerateNumberArray() {
        return generateNumberArray;
    }

    /**
     * 임의의 중북되지 않는 3자리 숫자 생성
     */
    private void setGenerateNumber() {
        int i = 0;
        while (generateNumbers.size() < InputValidator.MAX_LENGTH) {
            int random = (int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER);
            if (!generateNumbers.contains(random)) {
                generateNumberArray[i] = Integer.toString(random);
                i++;
            }
            generateNumbers.add(random);
        }
    }
}
