package view;

public class OutputView {
    private static final String JACKPOT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    private OutputView() {}

    public static void printResult(String result){
        System.out.println(result);
    }

    public static void printJackpot(){
        System.out.println(JACKPOT_MESSAGE);
    }
}
