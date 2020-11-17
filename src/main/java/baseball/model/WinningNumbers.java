package baseball.model;

public class WinningNumbers {
    private final Numbers winningNumbers;

    public WinningNumbers(final Numbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getStrike(Numbers numbers) {
        return winningNumbers.countSamPosiAndNum(numbers);
    }

    public int getBall(Numbers numbers) {
        return winningNumbers.countSamNum(numbers) - winningNumbers.countSamPosiAndNum(numbers);
    }
}
