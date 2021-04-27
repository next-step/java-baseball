package baseball.domain;

import java.util.List;

public class Referee {

    private int strike = 0;
    private int ball = 0;

    private Hitter hitter;
    private List<Number> hitterNumberList;

    public Referee(Hitter hitter) {
        this.hitter = hitter;
        hitterNumberList = hitter.numbers().numbers();
    }

    public boolean check(Numbers inputNumbers) {
        this.strike = 0;
        this.ball = 0;
        List<Number> inputNumberList = inputNumbers.numbers();
        compareExactlyNumber(inputNumberList);

        return strike == 3 ? true : false;
    }

    public int strike() {
        return this.strike;
    }

    public int ball() {
        return this.ball;
    }

    private void compareExactlyNumber(List<Number> inputNumberList) {

        for (int i = 0; i < inputNumberList.size(); i++) {
            inspectSamNumber(inputNumberList.get(i), i);
        }

    }

    private void inspectSamNumber(Number inputNumber, int i) {
        for (int j = 0; j < hitterNumberList.size(); j++) {
            extractCompareResult(inputNumber, i, j);
        }
    }

    private void extractCompareResult(Number inputNumber, int i, int j) {
        if (inputNumber.number() == hitterNumberList.get(j).number() && i == j) {
            strike++;
        }

        if (inputNumber.number() == hitterNumberList.get(j).number() && i != j) {
            ball++;
        }

    }


}
