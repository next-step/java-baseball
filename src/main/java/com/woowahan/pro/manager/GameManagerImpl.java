package com.woowahan.pro.manager;

import com.woowahan.pro.opponent.Opponent;
import com.woowahan.pro.referee.GameStatus;
import com.woowahan.pro.referee.Referee;
import com.woowahan.pro.ui.UserInterface;

import java.util.Optional;

public class GameManagerImpl implements GameManager {
    private final Opponent opponent;
    private final Referee referee;
    private final UserInterface userInterface;

    public GameManagerImpl(Opponent opponent, Referee referee, UserInterface userInterface) {
        this.opponent = opponent;
        this.referee = referee;
        this.userInterface = userInterface;
    }

    @Override
    public void play() {
        doPlay(true, GameStatus.READY, null);
        userInterface.close();
    }

    private void doPlay(boolean playable, GameStatus status, String[] opponentNumbers) {
        while (playable) {
            opponentNumbers = getOpponentNumbers(status, opponentNumbers)
                    .orElseThrow(() -> new NullPointerException("상대방 랜덤 숫자가 생성되지 않았습니다."));
            String[] playerNumbers = userInterface.requireNumbers();

            status = referee.judge(opponentNumbers, playerNumbers);
            userInterface.outputScore(referee.getStrike(), referee.getBall());

            playable = isPlayable(status);
        }
    }

    private boolean isPlayable(GameStatus status) {
        boolean playable = true;

        if (status == GameStatus.SUCCESS) {
            userInterface.outputOnFinishGame();
            playable = isReTryAgain();
        }
        return playable;
    }

    private boolean isReTryAgain() {
        boolean retryAgain = true;

        if (userInterface.inputRetry().equals("2")) {
            retryAgain = false;
        }
        return retryAgain;
    }

    private Optional<String[]> getOpponentNumbers(GameStatus status, String[] opponentNumbers) {
        if (status == GameStatus.READY || status == GameStatus.SUCCESS) {
            opponentNumbers = opponent.createRandomNumber();
        }

        return Optional.ofNullable(opponentNumbers);
    }
}
