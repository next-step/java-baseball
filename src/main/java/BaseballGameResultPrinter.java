public class BaseballGameResultPrinter {

    public String convertBaseballGameResult(int[] res) {
        return isNothing(res) ? "낫싱" : res[0] + " 스트라이크";
    }
    private boolean isNothing(int[] res) {
        return res[0] == 0 && res[1] == 0;
    }

}
