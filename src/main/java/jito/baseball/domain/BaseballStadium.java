package jito.baseball.domain;

import jito.baseball.util.UserInterfaceUtils;

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
    }

    public void gameStart() {
        while (GameStatus.GAME.getStatus().equals("PLAY")) {
            UserInterfaceUtils.startMessage();
            playGame();
        }
        UserInterfaceUtils.endMessage();
    }

    private void playGame() {
        PlayerBaseBall playerBaseBall = new PlayerBaseBall(scanner.next());
        String gameResult = CompareBaseBall.getGameResult(computerNumbers, playerBaseBall.getPlayerNumbers());
        UserInterfaceUtils.printMessage(gameResult);
        playerSelectGameStatus();
    }

    private void playerSelectGameStatus() {
        if (CompareBaseBall.stopGame()) {
            if (scanner.nextInt() == 2) {
                GameStatus.GAME.setEnd();
                return;
            }
            init();
        }
    }

}
