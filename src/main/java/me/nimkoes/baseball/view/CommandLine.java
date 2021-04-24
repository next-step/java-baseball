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
        String inputValue = "";

        while (!Validation.checkNumberData(inputValue)
                || !Validation.checkNumberLength(inputValue, MainLauncher.LENGTH_OF_NUMBER)
                || Validation.checkContainDuplicateNumber(inputValue)) {
            System.out.print(Message.USER_INPUT.getMsg());
            inputValue = sc.nextLine();
        }

        return inputValue;
    }

    @Override
    public void printCountMessage(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if (strikeCount > 0) {
            sb.append(String.valueOf(strikeCount)).append(Message.STRIKE.getMsg());
        }
        if (ballCount > 0) {
            sb.append(String.valueOf(ballCount)).append(Message.BALL.getMsg());
        }
        if (sb.length() == 0) {
            sb.append(Message.NOTHING.getMsg());
        }

        System.out.println(sb.toString());
    }

    @Override
    public void printEndingMessage(int numberLength) {
        System.out.println(numberLength + Message.ENDING.getMsg());
    }

    @Override
    public boolean checkContinue() {
        String inputValue = "";

        while (!Validation.checkEndingValue(inputValue)) {
            System.out.println(Message.RESTART.getMsg());
            inputValue = sc.nextLine();
        }

        return "1".equals(inputValue);
    }
}
