package ppyong.nextstep;

import java.util.Scanner;
import ppyong.nextstep.utils.ClientInputValidator;
import ppyong.nextstep.utils.RandomNumberUtil;

public class GameBot {
    private static final int MAX_NUMBER_SIZE = 3;
    private static final String REPLAY_NUMBER = "1";
    private static final String STOP_NUMBER = "2";

    private String botRandomNumber;
    private Scanner scanner;
    private RandomNumberUtil randomNumberUtil;
    private ClientInputValidator clientInputValidator;

    public GameBot() {
        scanner = new Scanner(System.in);
        randomNumberUtil = new RandomNumberUtil(MAX_NUMBER_SIZE);
    }

    public void run() {
        boolean continued = true;
        while(continued) {
            botRandomNumber = randomNumberUtil.createRandomNumber();
            clientInputValidator = new ClientInputValidator(botRandomNumber);
            inputNumber();
            continued = !isQuit();
        }
    }

    public boolean isQuit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return !input.equals(REPLAY_NUMBER);
    }

    private void inputNumber() {
        boolean continued = true;
        while (continued) {
            System.out.print("숫자를 입력해주세요: ");
            String input = scanner.nextLine();

            continued = !clientInputValidator.checkValidNumber(input);
        }
    }
}
