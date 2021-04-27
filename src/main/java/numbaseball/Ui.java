package numbaseball;

import java.util.Map;
import java.util.Scanner;

public class Ui {

    private static Scanner sc = new Scanner(System.in);

    public static void startPlayGame() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void judgePlayGame(Map<String,Object> playResult) {
        String ballCount = String.valueOf(playResult.get("ball"));
        String strikeCount = String.valueOf(playResult.get("strike"));
        String judgeMessage = "";
        if ( !"0".equals(strikeCount) ) {
            judgeMessage += strikeCount+"스트라이크 ";
        }
        if ( !"0".equals(ballCount) ) {
            judgeMessage += ballCount+"볼 ";
        }
        judgeMessage = "".equals(judgeMessage) ? "낫싱" : judgeMessage;
        System.out.println(judgeMessage);
    }

    public static void endPlayGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
