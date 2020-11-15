package com.coderhglee.game.domain;

import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.number.InputNumber;

public interface Game {
    void setGameUI();

    void sendMessageToUserInterface(String userMessage);

    void gameStart() throws GameException;

    void gameProcess(InputNumber inputNumber) throws GameException;

    String getGameResultMessage();

    void endGame();
}
