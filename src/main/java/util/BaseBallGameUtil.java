package util;

import common.Constant.*;

import static common.Constant.*;


public class BaseBallGameUtil {

    private static int strike = 0;
    private static int ball = 0;


    // 결과 리턴 메서드

    public boolean baseBallGameUtil(int[] computerNumbers, int[] userNumbers) {

        judgeStrikeBall(computerNumbers, userNumbers);

        boolean rtn_result = printResultAndReturn();


        return rtn_result;
    }


    // 스트라이크,볼 판단 메서드
    public void judgeStrikeBall(int[] computerNumbers, int[] userNumbers) {
        for (int i = 0; i < 3; i++) {
            judgeStrike(computerNumbers[i], userNumbers[i]);
            judgeBall(computerNumbers, userNumbers[i], i);
        }
    }

    // 스트라이크 판단 메서드
    private void judgeStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            strike++;
        }
    }

    // 볼 판단 메서드
    private void judgeBall(int[] ComputerNumbers, int userNumber, int idx) {
        for (int i = 0; i < ComputerNumbers.length; i++) {
            if (i == idx) continue;

            if (ComputerNumbers[i] == userNumber) {
                ball++;
            }
        }
    }


    // 결과값 출력 메서드
    private boolean printResultAndReturn() {

        StringBuilder sb = new StringBuilder();

        boolean result = true;
        if (strike != 3) {
            if (strike > 0) {
                sb.append(String.format(TEXT_STRIK, strike));
            }
            if (ball > 0 ){
                sb.append(String.format(TEXT_BALL, ball));
            }
            if (strike == 0 && ball == 0) {
                sb.append((String.format(TEXT_NOTHING)));
            }
        } else {
            result = false;
        }
        System.out.println(sb.toString());

        resetCount();

        return result;
    }

    private void resetCount(){

        strike = 0;
        ball = 0;


    }


}
