package jito.baseball.domain;

import jito.baseball.util.UserInterfaceUtils;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballStadium {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ComputerBaseBall computerBaseBall = new ComputerBaseBall();
    private static CompareBaseBall CompareBaseBall;
    private static int[] computerNumbers;

    public void init() {
        computerBaseBall.makeBaseBall();
        computerNumbers = computerBaseBall.getComputerNumbers();
        CompareBaseBall = new CompareBaseBall();
        UserInterfaceUtils.startMessage();
    }

    public void gameStart() {
        while (GameStatus.GAME.getStatus().equals("PLAY")) {
            playGame();
        }
        UserInterfaceUtils.endMessage();
    }

    private void playGame() {
        PlayerBaseBall playerBaseBall = new PlayerBaseBall(scanner.next());
        String gameResult = CompareBaseBall.getGameResult(computerNumbers, playerBaseBall.getPlayerNumbers());
        UserInterfaceUtils.printMessage(gameResult);
        if (CompareBaseBall.stopGame()) {
            GameStatus.GAME.setEnd();
        }
    }

}
