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
        if(resultType.getStrikeCnt() > 0 && resultType.getStrikeCnt() < 3) {
            sb.append(resultType.getStrikeCnt());
            sb.append(" 스트라이크 ");
        }

        if(resultType.getBallCnt() > 0) {
            sb.append(resultType.getBallCnt());
            sb.append(" 볼");
        }

        if(resultType.getStrikeCnt() == 0 && resultType.getBallCnt() == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }
}
