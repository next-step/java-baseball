package domain;

public class BaseballGame {
    private final BaseballNumbers baseballNumbers;

    BaseballGame(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballGame init(BaseballNumbersGenerator generator) {
        return new BaseballGame(generator.generate());
    }

    int getSizeOfBaseballNumbers() {
        return baseballNumbers.size();
    }
}
