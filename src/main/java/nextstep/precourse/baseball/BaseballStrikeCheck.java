package nextstep.precourse.baseball;

import java.util.Scanner;

public class BaseballStrikeCheck {

    public static final String GAME_START = "1";
    public static final String GAME_OVER = "2";

    /**
     * @param  strike strike결과값
     * @return strike가 0이면 true, 3이면 false를 리턴
     */
    public Boolean baseballStrikeLoopCheck(int strike) {
        if(strike == 0) {
            return true;
        }

        return !gameRestartCheck();
    }

    /**
     * @return 사용자에게 입력받은 숫자와 GAME_OVER 상수를 비교
     */
    public Boolean gameRestartCheck() {
        return GAME_OVER.equals(gemeRestartPrint());
    }

    /**
     * @return 사용자에게 받은 입력값을 리턴
     */
    public String gemeRestartPrint() {
        Scanner sc = new Scanner(System.in);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return sc.nextLine();
    }

}
