package edu.example.numberbaseball;

import edu.example.numberbaseball.computer.Computer;
import edu.example.numberbaseball.player.Player;
import edu.example.numberbaseball.player.PlayerStatus;

/**
 * 숫자야구게임 애플리케이션 로직을 담당하는 컴포넌트
 */
public class NumberBaseball {
    private final Computer computer = new Computer();
    private Player player;

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

    private void checkPlayerState() {
        if (player.getStatus() == PlayerStatus.INACTIVE) {
            throw new IllegalArgumentException("Player 정보가 존재하지 않습니다.");
        }
    }
}
