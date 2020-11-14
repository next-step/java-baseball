package domain;

public class RandomableBaseBallNumbers extends BaseBallNumbers {

    public RandomableBaseBallNumbers() {
        generateRandomBaseBallNumbers();
    }

    void setBaseBallNumber(BaseBallNumber number, int index) {
        numbers[index] = number;
        setBit(number);
    }

    private BaseBallNumber[] generateRandomBaseBallNumbers() {
        BaseBallNumber[] baseBallNumbers = new BaseBallNumber[DEFAULT_MAX_SIZE];
        for(int i = 0; i < DEFAULT_MAX_SIZE; i++) {
            BaseBallNumber baseBallNumber = new BaseBallNumber(generateRandomNumber());
            setBaseBallNumber(getOrReGenerateBaseBallNumber(baseBallNumber), i);
        }

        return baseBallNumbers;
    }

    private BaseBallNumber getOrReGenerateBaseBallNumber(BaseBallNumber baseBallNumber) {
        while(isMasked(baseBallNumber))
            baseBallNumber = new BaseBallNumber(generateRandomNumber());
        return baseBallNumber;
    }

    private int generateRandomNumber() {
        return BaseBallNumber.DEFAULT_MIN_NUMBER + (int)(Math.random() * ((BaseBallNumber.DEFAULT_MAX_NUMBER - BaseBallNumber.DEFAULT_MIN_NUMBER) + 1));
    }
}
