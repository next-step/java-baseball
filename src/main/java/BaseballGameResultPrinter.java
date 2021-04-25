public class BaseballGameResultPrinter {

    public String convertBaseballGameResult(int[] res) {
        if (isNothing(res))
            return "낫싱";
        if(isUnitStrikes(res))
            return res[0] + " 스트라이크";
        if (isUnitBalls(res))
            return res[1] + " 볼";
        return "";
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
