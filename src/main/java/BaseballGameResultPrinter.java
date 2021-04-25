public class BaseballGameResultPrinter {

    public String convertBaseballGameResult(int[] res) {
        int strikesCnt = res[0], ballsCnt = res[1];

        if (isNothing(res))
            return "낫싱";
        if(isUnitStrikes(res))
            return strikesCnt + " 스트라이크";
        if (isUnitBalls(res))
            return ballsCnt + " 볼";
        return strikesCnt + " 스트라이크 " + ballsCnt + " 볼";
    }
    private boolean isNothing(int[] res) {
        return res[0] == 0 && res[1] == 0;
    }
    private boolean isUnitStrikes(int[] res) {
        return res[0] > 0 && res[1] == 0;
    }
    private boolean isUnitBalls(int[] res) {
        return res[0] == 0 && res[1] > 0;
    }

}
