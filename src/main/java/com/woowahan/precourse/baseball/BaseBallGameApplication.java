package com.woowahan.precourse.baseball;

import com.woowahan.precourse.baseball.domain.BaseBallGame;
import com.woowahan.precourse.baseball.view.GameMessage;


import java.util.Scanner;

public class BaseBallGameApplication {

    static boolean gameContinue;
    static BaseBallGame baseBallGame;

    static {
        gameContinue = true;
        baseBallGame = new BaseBallGame();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(gameContinue) {
            runningGame(sc);
        }
    }

    private static void runningGame(Scanner sc) {
        System.out.println(GameMessage.ENTER_NUMBER);

        String userGameNumber = sc.nextLine();

        GameResult gameResult = baseBallGame.execute(userGameNumber.split(""));
        System.out.println(gameResult.getMessage());

        if (isVictory(gameResult)) {
            victoryGame(sc);
        }
    }

    private static boolean isVictory(GameResult gameResult) {
        return gameResult.getVictory();
    }

    private static void victoryGame(Scanner sc) {
        String endAnswer = sc.nextLine();

        if (endAnswer.equals(GameStatus.RESTART.getValue())) {
            baseBallGame = new BaseBallGame();
        }

        if (endAnswer.equals(GameStatus.END.getValue())) {
            gameContinue = false;
        }
    }
}


