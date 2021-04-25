package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Computer {

    private final BallNumbers numbers;

    public Computer(BallNumbers numbers) {
        this.numbers = numbers;
    }

    public Result match(BallNumbers ballNumbers) {
        Result result = new Result();
        if (isNothing(ballNumbers)) {
            return result.put(Arrays.asList(Record.NOTHING));
        }
        return result.put(decideRecords(ballNumbers));
    }

    private List<Record> decideRecords(BallNumbers ballNumbers) {
        List<Record> records = new ArrayList<>();
        int checkCount = ballNumbers.size();
        for (int i = 0; i < checkCount; i++) {
            records.add(checkRecord(ballNumbers, i));
        }
        return records;
    }

    private Record checkRecord(BallNumbers ballNumbers, int index) {
        int matchPoint = 0;
        matchPoint += checkContains(ballNumbers, index);
        matchPoint += checkEqualPosition(ballNumbers, index);
        return Record.findRecord(matchPoint);
    }

    private int checkContains(BallNumbers ballNumbers, int index) {
        int matchPoint = 0;
        if (isContains(ballNumbers, index)) {
            matchPoint++;
        }
        return matchPoint;
    }

    private int checkEqualPosition(BallNumbers ballNumbers, int index) {
        int matchPoint = 0;
        if (isEqualPosition(ballNumbers, index)) {
            matchPoint++;
        }
        return matchPoint;
    }

    private boolean isEqualPosition(BallNumbers ballNumbers, int index) {
        return Objects.equals(numbers.getIndexNumber(index), ballNumbers.getIndexNumber(index));
    }

    private boolean isContains(BallNumbers ballNumbers, int index) {
        return numbers.contains(ballNumbers, index);
    }

    private boolean isNothing(BallNumbers ballNumbers) {
        return !numbers.hasContains(ballNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(numbers, computer.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
