package study.baseball.service;

public class OutputSupplier {
    private ResultChecker checker;

    public OutputSupplier(ResultChecker checker) {
        this.checker = checker;
    }

    public void printResult() {
        System.out.print(this.checker.getStrikeCount() + "스트라이크 ");
        System.out.println(this.checker.getBallCount() + "볼");
    }
}
