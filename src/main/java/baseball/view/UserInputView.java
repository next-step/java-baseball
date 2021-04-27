package baseball.view;

import baseball.type.ResultType;

import java.util.Scanner;

public class UserInputView {

    public static String inputNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextLine();
    }

    public static String inputRestart() {
        Scanner sc = new Scanner(System.in);
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
        return sc.nextLine();
    }

    public static void resultConfirm(ResultType resultType) {
        StringBuffer sb = new StringBuffer();

        strikeOutput(resultType.getStrikeCnt());
        ballOutput(resultType.getBallCnt());
        nothingOutPut(resultType.getStrikeCnt(), resultType.getBallCnt());
        System.out.println();
    }

    private static void strikeOutput(int strikeCnt) {
        if(strikeCnt > 0 && strikeCnt < 3) {
            System.out.print(strikeCnt + "스트라이크 ");
        }
    }

    private static void ballOutput(int ballCnt) {
        if(ballCnt > 0) {
            System.out.print(ballCnt + "볼");
        }
    }

    private static void nothingOutPut(int strikeCnt, int ballCnt) {
        if(ballCnt == 0 && strikeCnt ==0) {
            System.out.print("낫싱");
        }
    }
}
