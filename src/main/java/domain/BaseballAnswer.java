package domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballAnswer {
    private Character[] answer;
    private int strikeCnt;
    private int ballCnt;

    public Character[] getAnswer() {
        return answer;
    }

    public void setAnswer(Character[] answer) {
        this.answer = answer;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void makeAnswer() {
        Set<Character> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() != 3) {
            numbers.add(Character.forDigit(random.nextInt(8) + 1, 10));
        }
        answer = new Character[numbers.size()];
        numbers.toArray(answer);
    }

    public void checkAnswer(char[] inputCharArray) {
        initCnt();
        checkStrike(inputCharArray);
        if (!isExatlyAnswer()) {
            checkBall(inputCharArray);
        }
        printHint();
    }

    private void initCnt() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    private void checkStrike(char[] inputCharArray) {
        if (inputCharArray[0] == answer[0]) {
            strikeCnt++;
        }
        if (inputCharArray[1] == answer[1]) {
            strikeCnt++;
        }
        if (inputCharArray[2] == answer[2]) {
            strikeCnt++;
        }
    }

    private void checkBall(char[] inputCharArray) {
        if (inputCharArray[0] != answer[0] && (inputCharArray[0] == answer[1] || inputCharArray[0] == answer[2])) {
            ballCnt++;
        }
        if (inputCharArray[1] != answer[1] && (inputCharArray[1] == answer[0] || inputCharArray[1] == answer[2])) {
            ballCnt++;
        }
        if (inputCharArray[2] != answer[2] && (inputCharArray[2] == answer[0] || inputCharArray[2] == answer[1])) {
            ballCnt++;
        }
    }

    private void printHint() {
        if (isNothing()) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(String.format("%d 스트라이크 %d 볼", strikeCnt, ballCnt));
    }

    public boolean isNothing() {
        return strikeCnt == 0 && ballCnt == 0;
    }

    public boolean isExatlyAnswer() {
        return strikeCnt == 3;
    }
}
