package baseballgame;

public class NumberMatcher {
    int strikeCount = 0;
    int ballCount = 0;

    public ResultType match(RandomNumber random, InputNumber input) {
        for(int i = 0; i < input.size(); i++) {
            Integer number = input.getNumber(i);
            checkRule(random, number, i);
        }
        return createResult();
    }

    private ResultType createResult() {
        return ResultType.getResultTypeOfCount(strikeCount, ballCount);
    }

    private void checkRule(RandomNumber random, Integer number, Integer index) {
        if(random.getNumber(index) == number) {
            strikeCount++;
            return;
        }
        if(random.contains(number)) {
            ballCount++;
        }
    }

    private String createResultString() {
        if(strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        return strikeResult() + " " +
                "" + ballResults();
    }

    private String ballResults() {
        if(ballCount == 0) return " ";
        return ballCount +" 볼";
    }

    private String strikeResult() {
        if(strikeCount == 0) return "";
        return strikeCount +" 스트라이크";
    }
}
