package baseball.bo;

import baseball.constant.AppConstant;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Opponent {

    private String strikeNumber;
    private int strike;
    private int ball;

    public Opponent() {
        this.resetStrikeNumber();
    }

    public void resetStrikeNumber() {
        this.strikeNumber = this.generateStrikeNumber();
    }

    private String generateStrikeNumber() {
        Set<Integer> numberSet = new LinkedHashSet<>();
        Random random = new Random();
        
        while (numberSet.size() < AppConstant.STRIKE_NUMBER) {
            int i = random.nextInt(9) + 1;
            numberSet.add(i);
        }

        StringBuilder strikeNumber = new StringBuilder();
        for (Integer integer : numberSet) {
            strikeNumber.append(integer);
        }

        return strikeNumber.toString();
    }

    public void calculateStrike(String inputNumber) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < inputNumber.length(); i++) {
            increaseBall(strikeNumber, inputNumber, i);
        }
    }

    private void increaseBall(String strikeNumber, String inputNumber, int idx) {
        // strike: 입력문자열의 index 위치 문자값과 strike 기준값의 index 위치 문자값이 같을 때
        if (strikeNumber.charAt(idx)==inputNumber.charAt(idx)) {
            strike++;
        }
        // ball: 입력문자열의 index 위치 문자값이 strike 문자열에 존재하나 위치가 같지 않을 때
        int indexOf = strikeNumber.indexOf(inputNumber.charAt(idx));
        if (indexOf != -1 && indexOf != idx) {
            ball++;
        }
    }

    public String getMessage() {
        if (strike==AppConstant.STRIKE_NUMBER) {
            return AppConstant.STRIKE_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (strike==0 && ball==0) {
            return "낫싱";
        }
        String ballMessage = "";
        if (ball>0) {
            ballMessage = " " + ball + " 볼";
        }
        return strike + " 스트라이크" + ballMessage;
    }

    public boolean isLose() {
        return strike == AppConstant.STRIKE_NUMBER;
    }

    public String getStrikeNumber() {
        return strikeNumber;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
