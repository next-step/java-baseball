import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class BaseballService {

    private final Scanner scanner;
    private final BaseballUi ui;

    private String[] targetNumbers;
    private int numberSize;

    public BaseballService() {
        scanner = new Scanner(System.in);
        ui = new BaseballUi(scanner);
    }

    /**
     * 게임 시작.
     * @param size 숫자 야구 게임 숫자 길이.
     */
    public void startGame(int size) {

        if (size == 0) {
            size = Constants.BASEBALL_DEFAULT_NUMBER_SIZE;
        }

        this.numberSize = size;
        targetNumbers = this.createRandomNumbers(size);
        ui.askNumber();
    }

    /**
     * 야구 게임에 사용할 숫자 생성.
     * @param size 야구 게임에 사용할 숫자 사이즈.
     * @return 야구 게임에 사용할 숫자 객체.
     */
    public String[] createRandomNumbers(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(Message.LESS_THAN_1.getText());
        }

        Random random = new SecureRandom();
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            result[i] = String.valueOf(random.nextInt(10));
        }

        return result;
    }

    /**
     * 야구 게임에 사용할 숫자 객체 반환.
     * @return 야구 게임에 사용할 숫자 객체.
     */
    public String[] getTargetNumbers() {
        return this.targetNumbers;
    }
}
