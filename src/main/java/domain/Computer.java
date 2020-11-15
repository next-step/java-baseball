package domain;

public class Computer {

    private final Numbers numbers;

    public Computer(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public Result matches(Numbers userNumbers) {
        Result result = new Result();
        if (checkNothing(userNumbers, result)) return result;
        result = numbers.match(userNumbers);
        return result;
    }

    private boolean checkNothing(Numbers userNumbers, Result result) {
        boolean isContain = numbers.isContain(userNumbers);
        if (!isContain) {
            result.put(Score.NOTHING);
            return true;
        }
        return false;
    }
}
