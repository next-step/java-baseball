package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ui.Input.userInput;
import static ui.Output.printResultAndReturn;

public class BaseBallUtil {

    // 컴퓨터가 내는 숫자 만들기
    public static final int LIMIT_NUM_CNT = 3;
    // 1. 서로 다른 숫자로 이루어진 3자리 난수를 반환한다.
    public int[] generatorNumbers(){
        // 1~9까지의 숫자로 한정한다
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<Integer> ballNumbers = new ArrayList<>();
        for (int num : nums) {
            ballNumbers.add(num);
        }
        return shuffleNumber(ballNumbers);
    }

    private static int[] shuffleNumber(List<Integer> ballNumbers){
        // 1-2. 서로다른 숫자로 이루어져 있다
        Collections.shuffle(ballNumbers);
        // 1-3. 자리수는 3자리로 한정한다
        List<Integer> result = ballNumbers.subList(0,LIMIT_NUM_CNT);
        int[] rtn_int_array = new int[result.size()];
        for (int i = 0; i < rtn_int_array.length; i++){
            rtn_int_array[i] = result.get(i);
        }
        return rtn_int_array;
    }

    private static int strike = 0;
    private static int ball = 0;

    public void playGame(int[] computerNumbers) {
        boolean rtn_result = true;

        while (rtn_result) {
            int[] userNumbers = userInput();
            rtn_result = judgeStrikeBall(computerNumbers, userNumbers);
        }
    }

    // 스트라이크,볼 판단 메서드
    public Boolean judgeStrikeBall(int[] computerNumbers, int[] userNumbers) {
        boolean result;
        for (int i = 0; i < 3; i++) {
            strike = judgeStrike(computerNumbers[i], userNumbers[i]);
            ball = judgeBall(computerNumbers, userNumbers[i], i);
        }

        result = printResultAndReturn(strike, ball);
        resetCount();

        return result;


    }

    // 스트라이크 판단 메서드
    public int judgeStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            strike++;
        }
        return strike;
    }

    // 볼 판단 메서드
    public int judgeBall(int[] ComputerNumbers, int userNumber, int idx) {
        for (int i = 0; i < ComputerNumbers.length; i++) {
            if (i == idx) continue;
            if (ComputerNumbers[i] == userNumber) {
                ball++;
            }
        }
        return ball;
    }
    // 스트라이크, 볼 초기화 메서드
    private void resetCount() {
        strike = 0;
        ball = 0;
    }

}

