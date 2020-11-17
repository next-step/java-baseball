package baseballgame.component;

import baseballgame.domain.Result;

public class MessagePrinter {

    private static final String REQ_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String GAME_CLEAR_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력값입니다. 1부터 9까지의 서로 다른 3자리의 수를 입력해주세요.";

    /**
     * 결과값에 따라 메시지 출력
     * @param result : 사용자 입력값 체크 결과
     */
    public static void printResult(Result result){
        StringBuffer sb = new StringBuffer();
        if (result.getStrikeCount() > 0) {
            printStrike(result, sb);
        }
        if (result.getBallCount() > 0) {
            printBall(result, sb);
        }
        if(result.getStrikeCount() == 3){
            printClear(sb);
        }
        if(result.getStrikeCount() == 0 && result.getBallCount() == 0 ){
            printNothing(sb);
        }
        System.out.println(sb.toString());
    }

    private static void printStrike(Result result, StringBuffer sb){
        sb.append(result.getStrikeCount() + " 스트라이크 ");
    }

    private static void printBall(Result result, StringBuffer sb){
        sb.append(result.getBallCount() + " 볼");
    }

    private static void printNothing(StringBuffer sb){
        sb.append(NOTHING_MESSAGE);
    }

    private static void printClear(StringBuffer sb){
        sb.append(GAME_CLEAR_MESSAGE);
    }

    public static void requestInputMessage(){
        System.out.print(REQ_INPUT_MESSAGE);
    }

    public static void restartMessage(){
        System.out.println(GAME_RESTART_MESSAGE);
    }

    public static void printInvalidInput() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

}
