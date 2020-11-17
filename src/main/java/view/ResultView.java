package view;


import baseball.Score;

public class ResultView {
    private final String result;

    public ResultView(Score score) {
        result = score.calculateScore();
    }

    public void printResult() {
        System.out.println(result);
    }
}
