package baseball.service;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballService {
    private static final int BALL_COUNT = 3;
    private static int[] inputNums;
    private static Scanner sc;

    public BaseballService() {
        inputNums = new int[BALL_COUNT];
        sc = new Scanner(System.in);
    }

    public void start() {
        System.out.print("숫자를 입력해주세요 : ");
        divideInputNum(getInputNum());
    }

    private String getInputNum() {
        return sc.next();
    }

    public int[] divideInputNum(String strNum) {
        for (int i = 0; i < strNum.length(); i++) {
            inputNums[i] = strNum.charAt(i) - '0';
        }
        return inputNums;
    }
}
