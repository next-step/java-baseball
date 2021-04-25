package numberBaseball.view;

public class ConsoleOutput {

    public static final String MESSAGE_GAME_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printResult(String resultResponse) {
        System.out.println(resultResponse);
    }

    public static void printClearMessage() {
        System.out.println(MESSAGE_GAME_CLEAR);
    }

}
