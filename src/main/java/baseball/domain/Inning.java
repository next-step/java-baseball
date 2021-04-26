package baseball.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inning {

    private int[] answer;
    private int strike;
    private int ball;

    private Inning(int[] pickedNum) {
        this.answer = pickedNum;
    }

    public static Inning newInning(){

        int[] pickedNumbers = pickNumbers();

        return new Inning(pickedNumbers);
    }

    private static int[] pickNumbers() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,7,6,8,9}));
        int[] pickedNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int pick = (int) (Math.random()*(9-i));
            pickedNumbers[i] = numbers.get(pick);
            numbers.remove(pick);
        }

        return pickedNumbers;
    }


    public boolean pitch(String guess) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < guess.length(); i++) {
            countPitch(answer,guess.charAt(i) - '0', i);
        }
        printMessage();

        return checkInningOver();
    }

    private boolean checkInningOver() {
        return strike == 3;
    }

    private void printMessage() {
        if (checkInningOver()){
            System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임종료 %n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return;
        }
        if (checkNothing()){
            System.out.println("낫싱");
            return;
        }
        System.out.printf("%d 스트라이크 %d 볼 %n", strike, ball);
    }

    private boolean checkNothing() {
        return strike == 0 && ball ==0;
    }

    private void countPitch(int[] answer, int guess, int ball) {
        for (int i = 0; i < answer.length; i++) {
            checkBall(answer[i], guess, i == ball);
        }
    }

    private void checkBall(int answer, int guess, boolean samePosition) {
        if (answer != guess){
            return;
        }
        if (samePosition){
            strike++;
            return;
        }
        ball++;
    }
}
