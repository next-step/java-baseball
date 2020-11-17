package ui;

import static common.Constant.*;

public class Output {

    // 결과값 출력 메서드
    public static boolean printResultAndReturn(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        boolean result = true;
        if (strike != 3) {
            sb = setJudgePrint(sb, strike, ball);
        }
        if (strike == 3) {
            result = false;
        }
        System.out.println(sb.toString());

        return result;
    }



    // 스트라이크,볼 판단 출력용 : 출력 담당 메서드
    public static StringBuilder setJudgePrint(StringBuilder sb, int strike, int ball) {
        if (strike > 0) {
            sb.append(String.format(TEXT_STRIK, strike));
        }
        if (ball > 0) {
            sb.append(String.format(TEXT_BALL, ball));
        }
        if (strike == 0 && ball == 0) {
            sb.append((String.format(TEXT_NOTHING)));
        }
        return sb;
    }


}
