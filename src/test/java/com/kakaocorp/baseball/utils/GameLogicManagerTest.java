package com.kakaocorp.baseball.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class GameLogicManagerTest {
    private GameLogicManager gameLogicManager;

    @BeforeEach
    void setUp() {
        gameLogicManager = new GameLogicManager();
    }

    @ParameterizedTest
    @CsvSource({"123,143,2", "123,456,0", "432,333,1", "432,432,3"})
    void correctNumberOfStrikes(int computerPick, int playerPick, int expected) {
        checkStrikesBallsComputerPlayer(computerPick, playerPick);

        assertThat(gameLogicManager.getStrikes()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"123,143,0", "123,314,2", "432,333,2", "432,243,3"})
    void correctNumberOfBalls(int computerPick, int playerPick, int expected) {
        checkStrikesBallsComputerPlayer(computerPick, playerPick);

        assertThat(gameLogicManager.getBalls()).isEqualTo(expected);
    }

    @Test
    void playerWins() {
        gameLogicManager.setComputerPick(123);
        gameLogicManager.setPlayerPick(123);

        assertThat(gameLogicManager.hasRoundFinished()).isTrue();
    }

    @Test
    void incorrectGuess() {
        gameLogicManager.setComputerPick(123);
        gameLogicManager.setPlayerPick(143);

        assertThat(gameLogicManager.hasRoundFinished()).isFalse();
    }

    private void checkStrikesBallsComputerPlayer(int computerPick, int playerPick) {
        gameLogicManager.setComputerPick(computerPick);
        gameLogicManager.setPlayerPick(playerPick);
        gameLogicManager.checkBallsAndStrikes();
    }
}
