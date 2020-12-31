package com.kakaocorp.baseball;

import com.kakaocorp.baseball.ui.UserInterface;
import com.kakaocorp.baseball.utils.GameLogicManager;
import com.kakaocorp.baseball.utils.NumWithNoOverlappingDigitGenerator;

public class BullsAndCows {
    private boolean endGame;
    private boolean roundInProgress;
    private GameLogicManager gameLogicManager;
    private NumWithNoOverlappingDigitGenerator randomNumGenerator;
    private UserInterface userInterface;

    public void start() {
        initialize();
        gameStart();
    }

    private void initialize() {
        endGame = false;
        gameLogicManager = new GameLogicManager();
        randomNumGenerator = new NumWithNoOverlappingDigitGenerator();
        userInterface = new UserInterface();
    }

    private void gameStart() {
        while (!playerWantsToEnd()) {
            startNewRound();
            proceedGame();
            checkPlayerWantsToFinishGame();
        }
    }

    private boolean playerWantsToEnd() {
        return endGame;
    }

    private void startNewRound() {
        startRound();
        pickNewNumForComputer();
    }

    private void proceedGame() {
        while (roundInProgress) {
            scanUserNum();
            checkRoundFinished();
            printCurrentGameStatus();
        }
    }

    private void checkPlayerWantsToFinishGame() {
        userInterface.printFinishGameAskingMessage();

        endGame = userInterface.scanPlayerWantsToEnd();
    }

    private void startRound() {
        roundInProgress = true;
    }

    private void pickNewNumForComputer() {
        gameLogicManager.setComputerPick(randomNumGenerator.generate());
    }

    private void scanUserNum() {
        userInterface.printNextPlayerPickMessage();

        gameLogicManager.setPlayerPick(userInterface.scanNextGuessingNum());
    }

    private void checkRoundFinished() {
        roundInProgress = !gameLogicManager.hasRoundFinished();
    }

    private void printCurrentGameStatus() {
        userInterface.printStatusMessageStrikesBalls(
                gameLogicManager.getStrikes(),
                gameLogicManager.getBalls()
        );
    }
}
