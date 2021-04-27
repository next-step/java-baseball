package baseball.business;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import baseball.etc.Constants;
import baseball.etc.Message;
import baseball.model.BaseNumbers;
import baseball.model.BaseballResult;

public class BaseballService {

    private final Random random = new SecureRandom();
    private BaseNumbers baseNumbers;
    private int numberSize;

    /**
     * 게임 시작.
     * @param size 숫자 야구 게임 숫자 길이.
     */
    public void startGame(int size) {
        if (size == 0) {
            size = Constants.BASEBALL_DEFAULT_NUMBER_SIZE;
        }

        this.numberSize = size;
        this.baseNumbers = this.createRandomNumbers(size);

        this.baseNumbers.getNumbers().forEach((data) -> {System.out.println(data);});
    }

    /**
     * 야구 게임에 사용할 숫자 생성.
     * @param size 야구 게임에 사용할 숫자 사이즈.
     * @return 야구 게임에 사용할 숫자 객체.
     */
    public BaseNumbers createRandomNumbers(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(Message.LESS_THAN_1.getText());
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(this.createDeduplicatedNumber(result));
        }

        return new BaseNumbers(result);
    }

    /**
     * 중복 없는 숫자 생성.
     * @param existNumbers 기존 숫자들.
     * @return 중복 없는 숫자.
     */
    public String createDeduplicatedNumber(List<String> existNumbers) {
        String numNumber;

        do {
            numNumber = String.valueOf(random.nextInt(10));
        } while (existNumbers.contains(numNumber));

        return numNumber;
    }

    /**
     * 야구 게임에 사용할 숫자 객체 반환.
     * @return 야구 게임에 사용할 숫자 객체.
     */
    public BaseNumbers getBaseNumbers() {
        return this.baseNumbers;
    }

    /**
     * 사용자가 입력한 숫자들과 가지고 있는 숫자들과 비교.
     * @param input 입력 받은 숫자.
     */
    public BaseballResult checkNumbers(String input) {
        validate(input);
        return this.baseNumbers.checkNumbers(input);
    }

    /**
     * 사용자로 부터 입력 받은 숫자 검증.
     * @param input 사용자가 입력한 숫자.
     * @return 유효성 검사 결과값.
     */
    public boolean validate(String input) {
        // 값이 없다면.
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(Message.NUMBER_REQUIRED.getText());
        }

        // 값이 허용 사이즈와 다르다면.
        if (input.length() != this.numberSize) {
            throw new IllegalArgumentException(
                Message.ONLY_LIMIT_CHARACTERS.getTextWithWord(String.valueOf(this.numberSize)));
        }

        return true;
    }
}
