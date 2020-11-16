package com.coderhglee.game.baseball;

import com.coderhglee.game.Game;
import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.number.UserInputNumber;

import java.util.Scanner;

public class BaseballGameUI {

    private static boolean gameEndFlag = true;
    private static final Scanner scanner = new Scanner(System.in);

    public static void executeGame() {
        while (gameEndFlag) {
            executeBaseballGame();
        }
    }

    private static void executeBaseballGame() {
        try {
            BaseballGame baseballGame = new BaseballGame();
            executeGameRound(baseballGame);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            endGame(scanner.nextLine());
        } catch (GameException e) {
            System.out.println(e.getClass().toString());
        }
    }

    private static void executeGameRound(Game game) throws GameException {
        while (!game.getGameStatus().equals(BaseballGameStatus.WIN)) {
            System.out.print("숫자를 입력해주세요: ");
            game.gameProcess(new UserInputNumber(scanner.nextLine()));
            System.out.println(game.getGameResultMessage());
        }
    }

    private static void endGame(String message) {
        if (message.equals("2")) {
            gameEndFlag = false;
            return;
        }
        executeGame();
    }
}
