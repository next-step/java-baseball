package me.nimkoes.baseball.view;

import java.util.Scanner;

import me.nimkoes.baseball.MainLauncher;
import me.nimkoes.baseball.util.Validation;

public class CommandLine implements PlayerInterface {

    private static CommandLine commandLine = new CommandLine();
    private static final Scanner sc = new Scanner(System.in);

    private CommandLine() {}

    public static CommandLine getInstance() {
        return commandLine;
    }

    @Override
    public String inputNumber() {
        String inputValue;

        do {
            System.out.print(Message.USER_INPUT.getMsg());
            inputValue = sc.nextLine();
        } while (!Validation.isNumberData(inputValue)
                || !Validation.isCorrectLength(inputValue, MainLauncher.LENGTH_OF_NUMBER)
                || Validation.isContainDuplicateNumber(inputValue));

        return inputValue;
    }

    @Override
    public void printCountMessage(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        getStrikeMessage(strikeCount, sb);
        getBallMessage(ballCount, sb);
        getNothingMessage(sb);

        System.out.println(sb.toString());
    }

    /*
     * strike 에 해당하는 경우가 있을 경우 메시지 생성
     */
    private void getStrikeMessage(int strikeCount, StringBuilder sb) {
        if (strikeCount > 0) {
            sb.append(strikeCount).append(Message.STRIKE.getMsg());
        }
    }

    /*
     * ball 에 해당하는 경우가 있을 경우 메시지 생성
     */
    private void getBallMessage(int ballCount, StringBuilder sb) {
        if (ballCount > 0) {
            sb.append(ballCount).append(Message.BALL.getMsg());
        }
    }

    /*
     * strike 와 ball 아무것도 없는 경우 '낫싱' 메시지 생성
     */
    private void getNothingMessage(StringBuilder sb) {
        if (sb.length() == 0) {
            sb.append(Message.NOTHING.getMsg());
        }
    }

    @Override
    public void printEndingMessage(int numberLength) {
        System.out.println(numberLength + Message.ENDING.getMsg());
    }

    @Override
    public boolean checkContinue() {
        String inputValue;

        do {
            System.out.println(Message.RESTART.getMsg());
            inputValue = sc.nextLine();
        } while (!Validation.checkEndingValue(inputValue));

        return "1".equals(inputValue);
    }

}
