package baseball;

import java.util.ArrayList;
import java.util.List;

class Catcher {
    final int MIN_NUM = 1;
    final int MAX_NUM = 10;

    private int[] pitchingNumbers;
    private int baseBallNumberLength;
    int strikeCount;
    int ballCount;

    List<Integer> standardNumbers;

    Catcher(int baseBallNumberLength) {
        standardNumbers = new ArrayList<>();
        this.baseBallNumberLength = baseBallNumberLength;
        setStandardNumbers();
    }

    private void setStandardNumbers() {
        while (standardNumbers.size() < baseBallNumberLength) {
            addStandardNumber((int) ((Math.random() * (MAX_NUM - MIN_NUM)) + MIN_NUM));
        }
    }

    private void addStandardNumber(int randomNumber) {
        if (standardNumbers.contains(randomNumber)) {
            return;
        }

        standardNumbers.add(randomNumber);
    }

    public void setScore(int[] pitchingNumbers) {
        for (int i = 0; i < baseBallNumberLength; i++) {
            calStrikeCount(pitchingNumbers[i], standardNumbers.get(i));
            calBallCount(pitchingNumbers, standardNumbers, i);
        }
    }

    public void calStrikeCount(int pitchingNumber, int standardNumber) {
        if (pitchingNumber == standardNumber) {
            strikeCount++;
        }
    }

    private void calBallCount(int[] pitchingNumbers, List<Integer> standardNumbers, int pitchingIdx) {
        for (int i = 0; i < baseBallNumberLength; i++) {
            calBallCountByIdx(pitchingNumbers, standardNumbers, pitchingIdx, i);

        }
    }

    private void calBallCountByIdx(int[] pitchingNumbers, List<Integer> standardNumbers, int pitchingIdx, int baseBallIdx) {
        if (pitchingIdx != baseBallIdx && pitchingNumbers[pitchingIdx] == standardNumbers.get(baseBallIdx)) {
            ballCount++;
        }
    }

    public boolean is3Strike() {
        return strikeCount == 3;
    }

    public void printScore() {
        if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }
}