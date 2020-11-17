package edu.example.numberbaseball;

import edu.example.numberbaseball.computer.Computer;
import edu.example.numberbaseball.console.GameStatus;
import edu.example.numberbaseball.console.InputConsole;
import edu.example.numberbaseball.console.OutputConsole;
import edu.example.numberbaseball.player.Player;
import edu.example.numberbaseball.player.PlayerStatus;

import java.util.List;

/**
 * 숫자야구게임 애플리케이션 로직을 담당하는 컴포넌트
 */
public class NumberBaseball {
    private final Computer computer = new Computer();
    private Player player;

    public void run() {
        boolean isContinued = true;
        while (isContinued) {
            player = new Player(InputConsole.readInputString());
            int strikeCount = countStrike();
            OutputConsole.printStrikeAndBall(strikeCount, countBall());
            isContinued = isContinued(strikeCount);
        }
    }

    private boolean isContinued(int strike) {
        if (strike == computer.getNumberOfBalls()) {
            OutputConsole.printWinningMessage();
            computer.reset();
            return isNewGame();
        }
        return true;
    }

    private boolean isNewGame() {
        GameStatus gameStatus = InputConsole.readNewOrQuitGameNumber();
        return gameStatus == GameStatus.NEW;
    }

    private int countStrike() {
        int strike = 0;
        for (int i = 0; i < computer.getNumberOfBalls(); i++) {
            strike = strike + matchStrike(i);
        }
        return strike;
    }

    private int matchStrike(int index) {
        if (isStrike(index)) {
            return 1;
        }
        return 0;
    }

    private boolean isStrike(int index) {
        checkPlayerState();
        int computerBallNumber = computer.getBallNumber(index);
        int playerBallNumber = player.getBallNumber(index);
        return computerBallNumber == playerBallNumber;
    }

    private int countBall() {
        int ball = 0;
        for (int i = 0; i < computer.getNumberOfBalls(); i++) {
            ball = ball + matchBall(i);
        }
        return ball;
    }

    private int matchBall(int index) {
        if (!isStrike(index) && isBall(index)) {
            return 1;
        }
        return 0;
    }

    private boolean isBall(int index) {
        checkPlayerState();
        List<Integer> computerBallNumberList = computer.getBallNumberList();
        int playerBallNumber = player.getBallNumber(index);
        return computerBallNumberList.contains(playerBallNumber);
    }

    private void checkPlayerState() {
        if (player.getStatus() == PlayerStatus.INACTIVE) {
            throw new IllegalArgumentException("Player 정보가 존재하지 않습니다.");
        }
    }
}
