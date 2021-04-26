package study.baseball;

import study.common.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;

import static study.common.Constants.BASEBALL_NUMBER_LEN;
import static study.common.GameMessages.*;


/**
 * <p> 야구 게임 관련 계산 클래스  </p>
 *
 * @author bo-yoon
 * created on 2021.04.25
 */
public class BaseballCalculator {


    private static int strike;
    private static int ball;
    private static List<Integer> arrComputerNumbers = new ArrayList<>();
    private static List<Integer> arrPlayerNumbers = new ArrayList<>();
    private static NumberUtils numberUtils = new NumberUtils();


    /**
     * <p> 숫자 비교 메서드 </p>
     * 설명 : 두 수를 비교해 야구게임 결과를 반환
     *
     * @param computerNumber
     * @param playerNumber
     * @return boolean
     */
    public static boolean compareNumber(int computerNumber, int playerNumber) {

        allocatedNum(computerNumber, playerNumber);

        strike = calculateStrike();
        ball = calculateBall();

        return compareResult(strike, ball);
    }

    /**
     * <p> 숫자 설정 메서드 </p>
     * 숫자를 배열로 치환 후 클래스 내에서 사용할 수 있게 할당
     *
     * @param computerNumber
     * @param playerNumber
     * @return void
     */
    public static void allocatedNum(int computerNumber, int playerNumber) {
        arrComputerNumbers = numberUtils.convertNumberToList(computerNumber);
        arrPlayerNumbers = numberUtils.convertNumberToList(playerNumber);
    }

    /**
     * <p> strike 계산 메서드 </p>
     * 설명 : strike 계산
     *
     * @return int
     */
    public static int calculateStrike() {
        int ans = 0;
        for (int i = 0; i < arrComputerNumbers.size(); i++) {
            if (arrComputerNumbers.get(i) == arrPlayerNumbers.get(i)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * <p> ball 계산 메서드 </p>
     * 설명 : ball 계산
     *
     * @return int
     */
    public static int calculateBall() {
        int ans = 0;
        for (int i = 0; i < arrComputerNumbers.size(); i++) {
            if (arrComputerNumbers.get(i) != arrPlayerNumbers.get(i)) {
                if (!arrComputerNumbers.contains(arrPlayerNumbers.get(i))) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }

    /**
     * <p> 야구 게임 결과 반환 메서드 </p>
     * 설명 : 입력 받은 strike, ball 수로 결과 반환
     *
     * @param strike
     * @param ball
     * @return int
     */
    public static boolean compareResult(int strike, int ball) {

        if (strike == BASEBALL_NUMBER_LEN) {
            return true;
        }

        if (strike != 0) {
            System.out.print(strike + STRIKE_MESSAGE);
        }

        if (ball != 0) {
            System.out.print(ball + BALL_MESSAGE);
        }

        if (ball == 0 && strike == 0) {
            System.out.print(NOT_THING);
        }
        System.out.println();
        return false;
    }
}

