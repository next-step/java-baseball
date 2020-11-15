package com.ssabae.woowahantech.presentation;

import com.ssabae.woowahantech.domain.baseballnumber.BaseballNumbers;
import com.ssabae.woowahantech.validator.BaseballNumberValidator;

import java.util.Scanner;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-11
 */
public class UserInputHelper {

    public static final String GAME_CONTINUE = "1";
    public static final String GAME_QUIT = "2";

    private static final String INVALID_USER_INPUT = "잘못된 값을 입력하였습니다. 다시 입력해주세요.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final UserInputNumberParser parser;
    private final BaseballNumberValidator validator;

    public UserInputHelper(UserInputNumberParser parser, BaseballNumberValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public BaseballNumbers getInputBaseBallNumber() {
        String userInput = inputBaseballNumber();
        BaseballNumbers baseballNumbers = parser.parse(userInput);
        if (!validator.validate(baseballNumbers.getBaseballNumberList())) {
            print(INVALID_USER_INPUT, true);
            return null;
        }
        return baseballNumbers;
    }

    public boolean getInputContinueGame() {
        String continueGameInput = inputContinueGame();
        return continueGameInput.equals(GAME_CONTINUE);
    }

    private String inputBaseballNumber() {
        return scanningNextLine(USER_INPUT_MESSAGE);
    }

    private String inputContinueGame() {
        return scanningNextLine(CONTINUE_GAME_MESSAGE);
    }

    private String scanningNextLine(String message) {
        Scanner scanner = new Scanner(System.in);
        print(message);
        return scanner.nextLine();
    }

    private void print(String message) {
        print(message, false);
    }

    private void print(String message, boolean newLine) {
        if (newLine) {
            message = message + "\n";
        }
        System.out.print(message);
    }

}
