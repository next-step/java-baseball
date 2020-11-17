package util;

import static ui.Input.userInput;
import static ui.Output.printResultAndReturn;


public class BaseBallGameUtil {

    private static int strike = 0;
    private static int ball = 0;


    // 메인 메서드
    public static void playGame(int[] computerNumbers) {
        boolean rtn_result = true;

        while (rtn_result) {
            int[] userNumbers = userInput();
            rtn_result = judgeStrikeBall(computerNumbers, userNumbers);
        }
    }

    // 스트라이크,볼 판단 메서드
    public static Boolean judgeStrikeBall(int[] computerNumbers, int[] userNumbers) {

        Boolean result = true;

        for (int i = 0; i < 3; i++) {
            strike = judgeStrike(computerNumbers[i], userNumbers[i]);
            ball = judgeBall(computerNumbers, userNumbers[i], i);
        }

        result = printResultAndReturn(strike, ball);
        resetCount();

        return result;


    }

    // 스트라이크 판단 메서드
    private static int judgeStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            strike++;
        }

        return strike;

    }

    // 볼 판단 메서드
    private static int judgeBall(int[] ComputerNumbers, int userNumber, int idx) {
        for (int i = 0; i < ComputerNumbers.length; i++) {
            if (i == idx) continue;
            if (ComputerNumbers[i] == userNumber) {
                ball++;
            }
        }
        return ball;
    }


    // 스트라이크, 볼 초기화 메서드
    private static void resetCount() {
        strike = 0;
        ball = 0;
    }


}
