package baseball.ui;

import baseball.domain.core.BaseballNos;

import java.util.Scanner;

import static baseball.ui.BaseballGameDisplay.display;

public class BaseballGamePlayerInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int RETRY_FLAG = 1;

    public static BaseballNos inputBaseballNos(){
        display("숫자를 입력해주세요 : ");
        String playerInputBaseballNos = scanner.next()
                .trim();
        return BaseballNos.formPlayerInputString(playerInputBaseballNos);
    }

    public static boolean inputRetryBaseballGame(){
        display("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return RETRY_FLAG == scanner.nextInt();
    }
}
