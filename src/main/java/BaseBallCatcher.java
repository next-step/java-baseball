class BaseBallCatcher {
    private int[] baseBallNumbers;
    private int[] pitchingNumbers;
    private int baseBallNumberLength;
    int strikeCount;
    int ballCount;

    BaseBallCatcher (int baseBallNumberLength) {
        this.baseBallNumberLength = baseBallNumberLength;
        baseBallNumbers = new int[this.baseBallNumberLength];
        setBaseBallNumber();
    }

    private void setBaseBallNumber() {
        final int MIN_NUM = 1;
        final int MAX_NUM = 10;

        for (int i = 0; i < baseBallNumbers.length; i++) {
            baseBallNumbers[i] = (int) ((Math.random() * (MAX_NUM - MIN_NUM)) + MIN_NUM);
        }
    }

    public void setScore(int[] pitchingNumbers) {
        for (int i = 0; i < baseBallNumberLength; i++) {
            calStrikeCount(pitchingNumbers[i], baseBallNumbers[i]);
            calBallCount(pitchingNumbers, baseBallNumbers, i);
        }
    }

    public void calStrikeCount(int pitchingNumber, int baseBallNumber) {
        if (pitchingNumber == baseBallNumber) {
            strikeCount++;
        }
    }

    private void calBallCount(int[] pitchingNumbers, int[] baseBallNumbers, int pitchingIdx) {
        for (int i = 0; i < baseBallNumberLength; i++) {
            calBallCountByIdx(pitchingNumbers, baseBallNumbers, pitchingIdx, i);

        }
    }

    private void calBallCountByIdx(int[] pitchingNumbers, int[] baseBallNumbers, int pitchingIdx, int baseBallIdx) {
        if (pitchingIdx != baseBallIdx && pitchingNumbers[pitchingIdx] == baseBallNumbers[baseBallIdx]) {
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