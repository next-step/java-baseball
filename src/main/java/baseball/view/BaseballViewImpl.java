package baseball.view;

import baseball.model.InningsResult;

import java.util.Scanner;

public class BaseballViewImpl implements BaseballView {
    private static final String FINISH_GAME_CONDITION = "2";
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void printStartInnings() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    @Override
    public String inputOneInnings() {
        return scanner.next();
    }

    @Override
    public void printInningsResult(InningsResult inningsResult) {
        System.out.println(inningsResult.toString());
    }

    @Override
    public void printFinishInnings() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public boolean inputIsFinishGame() {
        return scanner.next().equals(FINISH_GAME_CONDITION);
    }
}