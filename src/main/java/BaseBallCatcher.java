class BaseBallCatcher {
    private int[] baseBallNumbers;

    BaseBallCatcher (int baseBallNumberLength) {
        baseBallNumbers = new int[baseBallNumberLength];
        createBaseBallNumber();
    }

    private void createBaseBallNumber() {
        final int MIN_NUM = 1;
        final int MAX_NUM = 10;

        for (int i = 0; i < baseBallNumbers.length; i++) {
            baseBallNumbers[i] = (int) ((Math.random() * (MAX_NUM - MIN_NUM)) + MIN_NUM);
        }
    }

    public boolean is3Strike() {
        return false;
    }

    public void setPitchingNumber(int[] pitchingNumber) {
    }

    public void printScore() {
    }
}
