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
        
        while (true) {

            int i = random.nextInt(9) + 1;
            if(numberSet.contains(i)) {
                continue;
            }

            numberSet.add(i);

            if(numberSet.size()==3) {
                StringBuilder strikeNumber = new StringBuilder();
                for (Integer integer : numberSet) {
                    strikeNumber.append(integer);
                }
                return strikeNumber.toString();
            }
        }
    }

    public void calculateStrike(String inputNumber) {

        strike = 0;
        ball = 0;

        String[] inputNumbers = inputNumber.split("");
        String[] strikeNumbers = strikeNumber.split("");

        for (int i = 0; i < inputNumbers.length; i++) {
            if(inputNumbers[i].equals(strikeNumbers[i])) {
                strike++;
                continue;
            }
            if(strikeNumber.contains(inputNumbers[i])) {
                ball++;
            }
        }
    }

    public String getMessage() {
        if(strike==3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if(strike==0 && ball==0) {
            return "낫싱";
        }
        String ballMessage = "";
        if(ball>0) {
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
