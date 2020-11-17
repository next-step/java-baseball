package edu.example.numberbaseball.console;

import edu.example.numberbaseball.common.Ball;
import edu.example.numberbaseball.common.Inning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * `Player`가 `Computer`와 야구게임을 진행하기 위한 입력 콘솔
 */
public class InputConsole {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요:";

    private InputConsole() {
    }

    public static Inning readInputString() {
        out.println(INPUT_MESSAGE);
        return toPitchedInning(readString());
    }

    private static Inning toPitchedInning(String inputString) {
        return new Inning(toPitchedBallList(inputString.toCharArray()));
    }

    private static List<Ball> toPitchedBallList(char[] inputCharArr) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < inputCharArr.length; i++) {
            ballList.add(new Ball(inputCharArr[i]));
        }
        return ballList;
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
