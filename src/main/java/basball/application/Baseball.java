package basball.application;

import java.util.List;

public class Baseball {

    public List<Integer> questionSet;

    private static final NumberFactory factory = new NumberFactory();
    private static final Validator validator = new Validator();

    public void startGame() {
        do {
            questionSet = factory.createRandomNumber();
            //System.out.println("맞춰야하는 숫자" + questionSet.toString());
            play();
        } while (isContinue());
    }

    private boolean isContinue() {
        return validator.inputContinue() == 1;
    }

    private void play() {
        boolean isCorrect = false;
        while (!isCorrect) {
            List<Integer> playerSet = factory.createUserNumber(validator.input());
            //System.out.println("입력 숫자" + playerSet.toString());
            isCorrect = matching(playerSet);
        }
    }
    private boolean matching(List<Integer> numbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0 ; i < 3 ; i ++) {
            strike += findStrike(numbers.get(i), i);
            ball += findBall(numbers.get(i),i);
        }
        System.out.println(result(strike, ball));
        return strike == 3;
    }
    private int findStrike(int value, int position) {
        int ret = 0;
        for (int i = 0 ; i < 3 ; i ++) {
            ret += CountingStrike(questionSet.get(i), value, i, position);
        }
        return ret;
    }

    private int CountingStrike(int correctValue, int value, int correctPosition, int position) {
        if (correctValue == value && correctPosition == position) {
            return 1;
        }
        return 0;
    }

    private int findBall(int value, int position) {
        int ret = 0;
        for (int i = 0 ; i < 3 ; i ++) {
            ret += CountingBall(questionSet.get(i), value, i, position);
        }
        return ret;
    }

    private int CountingBall(int correctValue, int value, int correctPosition, int position) {
        if (correctValue == value && correctPosition != position) {
            return 1;
        }
        return 0;
    }

    private String result(int strike, int ball) {
        if (strike == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임종료";
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        if (ball != 0 && strike != 0) {
            return strike + " 스트라이크 " + ball + "볼";
        }

        if (strike != 0) {
            return strike + " 스트라이크";
        }

        return ball + "볼";

    }
}
