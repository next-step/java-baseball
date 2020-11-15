package util;

public class BaseBallGameUtil {

    public static int STRIKE = 0;
    public static int BALL = 0;


    // 스트라이크,볼 판단 메서드
    public void judgeStrikeBall(int[] computerNumbers, int[] userNumbers) {
        for (int i = 0; i < 3; i++) {
            judgeStrike(computerNumbers[i], userNumbers[i]);
            judgeBall(computerNumbers,userNumbers[i], i);
        }

        printResult();
    }

    // 스트라이크 판단 메서드
    private void judgeStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            STRIKE++;
        }
    }

    // 볼 판단 메서드
    private void judgeBall(int[] ComputerNumbers, int userNumber, int idx) {
        for (int i = 0; i < ComputerNumbers.length; i++) {
            if (i==idx) continue;

            if (ComputerNumbers[i] == userNumber){
                BALL++;
            }
        }
    }


    // 결과값 출력 메서드
    private void printResult(){



    }


}
