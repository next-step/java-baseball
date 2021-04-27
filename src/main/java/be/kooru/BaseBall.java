package be.kooru;

import java.util.Scanner;

public class BaseBall {

    public void start() {
        int[] cValue = Util.generateRandomNumber(3, 1, 9);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int[] uValue = Util.convertStringToIntArray(input.next());
            int result = scoreCalculator(cValue, uValue);
            if (result > 0) System.out.println(result / 10 + " 스트라이트 " + result % 10 + "볼");
            if (result == 0) System.out.println("낫싱");
            if (result == 30) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int next = input.nextInt();
                if (next == 1) cValue = Util.generateRandomNumber(3, 1, 9);
                if (next == 2) break;
            }
        }
        input.close();
    }


    protected int scoreCalculator(int[] cValue, int[] uValue) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < cValue.length; i++) {
            if (verifyStrike(cValue[i], i, uValue)) strike++;
            if (verifyBall(cValue[i], i, uValue)) ball++;
        }

        return strike * 10 + ball;
    }

    protected boolean verifyStrike(int cValue, int index, int[] uValue) {
        for (int i = 0; i < uValue.length; i++) {
            if (cValue == uValue[i] && index == i) {
                return true;
            }
        }
        return false;
    }

    protected boolean verifyBall(int cValue, int index, int[] uValue) {
        for (int i = 0; i < uValue.length; i++) {
            if (cValue == uValue[i] && index != i) {
                return true;
            }
        }
        return false;
    }

}
