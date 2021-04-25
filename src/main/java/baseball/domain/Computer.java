package baseball.domain;

import java.util.*;

public class Computer {
    private static final int INIT = 0;

    private final BallNumbers numbers;

    public Computer(BallNumbers numbers) {
        this.numbers = numbers;
    }

    public Result match(BallNumbers ballNumbers) {
        Result result = new Result();
        if (isNothing(ballNumbers)) {
            return result.put(Collections.singletonList(Record.NOTHING));
        }
        return result.put(decideRecords(ballNumbers));
    }

    private List<Record> decideRecords(BallNumbers ballNumbers) {
        List<Record> records = new ArrayList<>();
        int checkCount = ballNumbers.size();
        for (int i = INIT; i < checkCount; i++) {
            records.add(checkRecord(ballNumbers, i));
        }
        return records;
    }

    private Record checkRecord(BallNumbers ballNumbers, int index) {
        int matchPoint = INIT;
        matchPoint += checkContains(ballNumbers, index);
        matchPoint += checkEqualPosition(ballNumbers, index);
        return Record.findRecord(matchPoint);
    }

    private int checkContains(BallNumbers ballNumbers, int index) {
        int matchPoint = INIT;
        if (isContains(ballNumbers, index)) {
            matchPoint++;
        }
        return matchPoint;
    }

    private int checkEqualPosition(BallNumbers ballNumbers, int index) {
        int matchPoint = INIT;
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
