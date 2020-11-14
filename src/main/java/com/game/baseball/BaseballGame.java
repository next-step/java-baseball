package com.game.baseball;

import com.game.code.ErrorCode;
import com.game.code.OptionCode;
import com.game.common.Game;
import com.game.exception.GameException;
import com.game.util.EnumUtil;
import com.game.util.NumberUtil;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame implements Game<String> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        String target = generateNumber();
        BaseballGameResult result = new BaseballGameResult();

        while (result.getStrike() != 3) {
            String input = getInput();
            isValidInput(input);
            result = play(target, input);
            System.out.println(result.toString());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restart();
    }

    @Override
    public void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String option = scanner.next();

        if (EnumUtil.isEqual(option, OptionCode.RESTART_GAME))
            start();
        if (EnumUtil.isEqual(option, OptionCode.EXIT_GAME))
            exit();
        restart();
    }

    @Override
    public void exit() {
        scanner.close();
        System.exit(0);
    }

    @Override
    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.next();
    }

    @Override
    public boolean isValidInput(String input) {
        Set<Integer> integerSet = new HashSet<>();

        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            isValidNumber(number);
            integerSet.add(number);
        }
        if (integerSet.size() == 3)
            return true;
        throw new GameException(ErrorCode.INVALID_INPUT);
    }

    /**
     * 숫자 유효성 검사
     * @param number 검사할 숫자
     */
    private void isValidNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER)
            throw new GameException(ErrorCode.INVALID_BASEBALL_NUMBER);
    }

    /**
     * 서로 다른 수로 이루어진 세자리 수 생성
     * @return 세자리 수 문자열
     */
    public String generateNumber() {
        Set<Integer> integerSet = new LinkedHashSet<>();
        while (integerSet.size() < 3) {
            int number = NumberUtil.randomNumber(MIN_NUMBER, MAX_NUMBER);
            integerSet.add(number);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : integerSet) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }

    /**
     * 세 자리수를 맞추기 위한 플레이
     * @param target 찾아야할 문자열
     * @param input 입력한 문자열
     * @return 플레이 결과
     */
    public BaseballGameResult play(String target, String input) {
        int strike = 0;
        int ball = 0;

        char[] numbers = target.toCharArray();
        for (int targetIndex = 0; targetIndex < numbers.length; targetIndex++) {
            int inputIndex = input.indexOf(numbers[targetIndex]);
            strike += countStrike(targetIndex, inputIndex);
            ball += countBall(targetIndex, inputIndex);
        }
        return new BaseballGameResult(strike, ball);
    }

    /**
     * 스트라이크 수 세기
     * @param targetIndex 찾아야할 숫자의 인덱스
     * @param inputIndex 입력한 숫자의 인덱스
     * @return 결과 값
     */
    private int countStrike(int targetIndex, int inputIndex) {
        if (targetIndex == inputIndex)
            return 1;
        return 0;
    }

    /**
     * 볼 수 세기
     * @param targetIndex 찾아야할 숫자의 인덱스
     * @param inputIndex 입력한 숫자의 인덱스
     * @return 결과 값
     */
    private int countBall(int targetIndex, int inputIndex) {
        if (inputIndex == -1)
            return 0;
        if (targetIndex != inputIndex)
            return 1;
        return 0;
    }
}
