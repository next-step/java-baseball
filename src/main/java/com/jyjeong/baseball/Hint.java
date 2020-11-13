package com.jyjeong.baseball;

public class Hint {

    public int[] hint(int[] computerNumber, int[] userNumber){
        int[] hintCount = new int[2];

        hintCount[0] = strikeCount(computerNumber,userNumber);
        hintCount[1] = ballCount(computerNumber,userNumber);

        return hintCount;
    }

    /**
     * 힌트의 개수를 확인하여 게임 종료여부 반환
     */
    public boolean hintCheck(int[] hint){
        if(hint[0] == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        printStrike(hint);
        printBall(hint);
        printNothing(hint);
        System.out.println();
        return false;
    }

    /**
     * 스트라이크 개수 메세지 출력
     */
    private void printStrike(int[] hint){
        if(hint[0] != 0) {
            System.out.print(hint[0] + "스트라이크");
        }
    }

    /**
     * 볼 개수 메세지 출력
     */
    private void printBall(int[] hint){
        if(hint[1] != 0) {
            System.out.print(hint[1] + "볼");
        }
    }

    /**
     * 낫싱 메세지 출력
     */
    private void printNothing(int[] hint){
        if(hint[0] == 0 && hint[1] == 0) {
            System.out.print("낫싱");
        }
    }

    /**
     * 랜덤한 숫자와 사용자가 입력한 숫자를 비교하여 strike 개수 반환
     */
    private int strikeCount(int [] computerNumber, int[] userNumber){
        int strike = 0;

        if(computerNumber[0] == userNumber[0]){
            strike++;
        }
        if(computerNumber[1] == userNumber[1]){
            strike++;
        }
        if(computerNumber[2] == userNumber[2]){
            strike++;
        }

        return strike;
    }

    /**
     * 랜덤한 숫자와 사용자가 입력한 숫자를 비교하여 ball 개수 반환
     */
    private int ballCount(int [] computerNumber, int[] userNumber){
        int ball = 0;
        if(computerNumber[0] == userNumber[1] || computerNumber[0] == userNumber[2]){
            ball++;
        }
        if(computerNumber[1] == userNumber[0] || computerNumber[1] == userNumber[2]){
            ball++;
        }
        if(computerNumber[2] == userNumber[0] || computerNumber[2] == userNumber[1]){
            ball++;
        }
        return ball;
    }
}
