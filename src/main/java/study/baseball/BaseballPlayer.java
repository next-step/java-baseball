package study.baseball;

import study.common.utils.NumberUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static study.common.Constants.*;
import static study.common.GameMessages.*;


/**
 * <p> 야구 플레이어 클래스  </p>
 */

public class BaseballPlayer {

    private static NumberUtils numberUtils = new NumberUtils();

    /**
     * <p> 숫자야구 게임 숫자 입력 메서드 </p>
     * 설명 : 사용자가 숫자를 입력 받는다.
     *
     * @param scanner
     * @return int
     */
    public static int inputNumber(Scanner scanner) {

        int input = 0;
        System.out.print(NUMBER_INPUT_MESSAGE);

        while (!askCorrectFormat(scanner)) {
            System.out.println(INVALID_FORMAT_MESSAGE);
        }

        do {
            input = scanner.nextInt();
        } while (checkValidNumber(input));

        return input;
    }

    /**
     * <p> 입력 값 포맷 확인 메서드 </p>
     * 설명 : 사용자가 숫자를 입력 받는지 확인
     *
     * @param scanner
     * @return boolean
     */
    public static boolean askCorrectFormat(Scanner scanner) {
        try {
            isNotNumber(scanner);
        } catch (InputMismatchException e) {
            return false;
        }
        return true;
    }


    /**
     * <p> 숫자 예외 발생 메서드 </p>
     * 설명 : 입력 값이 숫자가 아닐시 예외 발생
     *
     * @param scanner
     * @return void
     */
    public static void isNotNumber(Scanner scanner) {
        /** 정수가 아닐시 */
        if (!scanner.hasNextInt()) {
            scanner.next();
            throw new InputMismatchException();
        }
    }


    /**
     * <p> 숫자야구 게임 입력 숫자 범위 체크 메서드 </p>
     * 설명 : 범위를 초과할 시 예외처리
     *
     * @param input
     */
    public static void checkRange(int input) {
        /** 범위가 초과할시 */
        while ((input > MAX_BASEBALL_NUMBER_RANGE) || (input < MIN_BASEBALL_NUMBER_RANGE)) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * <p> 숫자야구 게임 계속 여부 메서드 </p>
     * 설명 : 게임을 계속할지 안할지 확인
     *
     * @return boolean
     * @Param scanner
     */
    public static boolean isContinueGame(Scanner scanner) {

        System.out.print(NUMBER_END_MESSAGE);
        while (!scanner.hasNextInt()) {
            throw new IllegalArgumentException();
        }

        int input = scanner.nextInt();

        while ((input > MAX_BASEBALL_IS_AGAIN_ANSWER) || (input < MIN_BASEBALL_IS_AGAIN_ANSWER)) {
            throw new IllegalArgumentException();
        }

        return gainAnsValue(input);
    }


    /**
     * <p> 입력 값 변환 </p>
     * 설명 : 계속 여부에 해당 되는 값을 치환
     *
     * @param ans
     * @return boolean
     */
    public static boolean gainAnsValue(int ans) {
        boolean isAgain = false;
        if (ans == MIN_BASEBALL_IS_AGAIN_ANSWER) {
            isAgain = true;
        }
        return isAgain;
    }

    /**
     * <p> 중복된 숫자가 들어오면 다시 입력 메서드 </p>
     * 설명 : 333 같은 중복된 숫자가 들어오면 다시 입력 받을 수 있게 true 반환
     *
     * @param input
     * @return boolean
     */
    public static boolean checkValidNumber(int input) {

        try {
            checkRange(input);
            NumberUtils.checkDuplicateNumber(input);


        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_NUMBER_MESSAGE);
            return true;
        }
        return false;
    }

}
