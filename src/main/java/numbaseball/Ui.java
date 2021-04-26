package numbaseball;

import java.util.Map;
import java.util.Scanner;

public class Ui {

    private static Scanner sc = new Scanner(System.in);

    public static void startPlayGame() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void judgePlayGame(Map<String, Object> playResult) {
        String ballCount = String.valueOf(playResult.get("ball"));
        String strikeCount = String.valueOf(playResult.get("strike"));
        if ( "0".equals(ballCount) && "0".equals(strikeCount) ){
            System.out.print("낫싱");
        }

        if ( !"0".equals(strikeCount) ){
            System.out.print(playResult.get("strike")+"스트라이크 ");
        }

        if ( !"0".equals(ballCount) ){
            System.out.print(playResult.get("ball")+"볼 ");
        }
        System.out.println("");

    }

}
