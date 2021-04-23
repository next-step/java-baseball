package com.game.baseball;

import com.game.global.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGame implements Game {

    private final int QUESTION_LENGTH = 3;

    private Question question;
    private Score score;
    private Scanner scanner;

    public BaseballGame() {
        question = new Question();
        score = new Score(question);
        scanner = new Scanner(System.in);
    }

    @Override
    public void setup() {
        question.make(QUESTION_LENGTH);
    }

    @Override
    public void play() {
        Result result = getResult();
        if (result != null && result.getStrike() == QUESTION_LENGTH) {
            return;
        }

        this.play();
    }

    private Result getResult() {
        Result result = null;
        try {
            score.setAnswer(makeAnswer());
            result = score.calculate();
        } catch (InputMismatchException ime) {
            scanner = new Scanner(System.in);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        return result;
    }

    @Override
    public void replay() {
        int input = inputIntegerValue("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (input == 1) {
            this.setup();
            this.play();
        } else if (input == 2) {
            return;
        }

        this.replay();
    }

    private Answer makeAnswer() {
        int input = inputIntegerValue("숫자를 입력해주세요 : ");

        Answer answer = new Answer();
        for (int digit : getNumberOfDigitsByInteger(input)) {
            answer.add(digit);
        }

        return answer;
    }

    private int inputIntegerValue(String s) {
        System.out.print(s);
        return scanner.nextInt();
    }

    private int[] getNumberOfDigitsByInteger(Integer integer) {
        String integerToString = Integer.toString(integer);
        int[] integerArray = new int[integerToString.length()];
        for (int i = 0; i < integerToString.length(); i++) {
            integerArray[i] = integerToString.charAt(i) - '0';
        }
        return integerArray;
    }

}
