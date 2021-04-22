package baseball.view.impl;

import baseball.model.BaseballResult;
import baseball.view.BaseballView;

import java.io.InputStream;
import java.util.Scanner;

public class BaseballViewImpl implements BaseballView {
    private Scanner scanner;

    public BaseballViewImpl() {
        this(System.in);
    }

    public BaseballViewImpl(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public void printInputPrompt() {
        System.out.println("숫자를 입력해주세요.");
    }

    @Override
    public String readInputPrompt() {
        return this.scanner.next();
    }

    @Override
    public void printBaseballResult(BaseballResult baseballResult) {
        System.out.println(baseballResult);
    }

    @Override
    public void printGameResult(BaseballResult baseballResult) {
        if (baseballResult.isComplete()) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", baseballResult.getStrike());
            return;
        }

        System.out.printf("%d개의 숫자를 맞히셨습니다... 미션 실패... 게임 종료\n", baseballResult.getStrike());
    }

    @Override
    public void printAskingReGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}