import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseballService {

    private Scanner scanner;

    public void start() {
        boolean isPlay = true;
        Baseball baseball;
        baseball = new Baseball();
        baseball.setOpponentNumber(BaseUtil.getRandomNumber());
        while (isPlay) {
            baseball.init();
            baseball.setUserNumber(getUserNumber());
        }
    }

    private void initScanner() {
        scanner = new Scanner(System.in);
    }

    private List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요: ");
        initScanner();
        int inputNumber = scanner.nextInt();
        while (inputNumber > 0) {
            userNumber.add(inputNumber % 10);
            inputNumber /= 10;
        }
        Collections.reverse(userNumber);
        return userNumber;
    }

}