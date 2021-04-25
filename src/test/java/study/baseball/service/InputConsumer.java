package study.baseball.service;

import study.baseball.status.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputConsumer {
    private Scanner scanner = new Scanner(System.in);
    private GameStatus gameStatus = GameStatus.PLAY;

    public List<Integer> getInput() {
        gameStatus.printMessage();
        return this.parseUserInput(scanner.nextLine());
    }

    private List<Integer> parseUserInput(String userNumber) {
        // TODO : 사용자가 중복되는 숫자를 입력 못하게 막아야 함.
        // TODO : 반드시 세자리 숫자를 입력받도록 체크 해야함
        List<Integer> userNumbers = new ArrayList<>();
        for (String s : userNumber.trim().split("")) {
            userNumbers.add(Integer.parseInt(s));
        }

        return userNumbers;
    }

    public void changeGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
