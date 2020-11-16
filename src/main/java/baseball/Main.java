package baseball;

import baseball.game.BaseBall;
import baseball.result.BaseBallResult;
import baseball.game.BaseBallValueGenerator;
import baseball.validate.BaseBallInputValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isPlay = true;
        Scanner scanner = new Scanner(System.in);
        BaseBall baseBall = new BaseBall(BaseBallValueGenerator.generateValue());

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputValue = scanner.nextLine();
            BaseBallInputValidator.validate(inputValue);
            BaseBallResult result = baseBall.play(inputValue);
            System.out.println(result.getPrintResult());
            isPlay = result.isPlay();
            if (!isPlay) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isPlay = retryGame();
                baseBall = new BaseBall(BaseBallValueGenerator.generateValue());
            }
        } while (isPlay);
    }

    private static boolean retryGame() {
        Scanner scanner = new Scanner(System.in);

        if ("1".equals(scanner.nextLine())) {
            return true;
        }

        return false;
    }
}
