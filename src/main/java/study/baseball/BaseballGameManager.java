package study.baseball;

import java.util.Scanner;

/**
 *
 * <p> 야구 게임 클래스  </p>
 *
 */

public class BaseballGameManager {

    private static int computerNumber;
    private static int playerNumber;

    static final Scanner scan = new Scanner(System.in);

    /**
     * <p> 숫자야구 게임 시작 메서드 </p>
     * 설명 : 야구게임에 필요한 메서드를 호출한다.
     * @return boolean
     */
    public static boolean startGame() {

        boolean isCorrect = false;
        computerNumber = Computer.generateBaseballNumber();

        do {

            playerNumber = BaseballPlayer.inputNumber(scan);
            isCorrect = BaseballCalculator.compareNumber(computerNumber, playerNumber);

        } while (!isCorrect);

        return BaseballPlayer.isContinueGame(scan);
    }

}
