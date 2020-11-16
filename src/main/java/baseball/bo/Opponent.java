package baseball.bo;

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
        
        while (numberSet.size()<3) {
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
        if (strikeNumber.charAt(idx)==inputNumber.charAt(idx)) {
            strike++;
        }

        int indexOf = strikeNumber.indexOf(inputNumber.charAt(idx));
        if(indexOf != -1 && indexOf != idx) {
            ball++;
        }
    }

    public String getMessage() {
        if (strike==3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
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
        return strike == 3;
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
