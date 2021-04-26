package view;

public class OutputDevice {

    private static final String MIX_RESULT_MESSAGE = "%d 스트라이크 %d 볼";
    private static final String STRIKE_RESULT_MESSAGE = "%d 스트라이크";
    private static final String BALL_RESULT_MESSAGE = "%d 볼";
    private static final String NOTHING_RESULT_MESSAGE = "낫싱";

    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_CONFIRMATION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printInputNumbersMessage(){
        System.out.println(INPUT_NUMBERS_MESSAGE);
    }

}
