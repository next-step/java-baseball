package com.coderhglee.game.number;

public enum GameSettingNumbers {
    INPUT_MESSAGE_MAX_LENGTH(3),
    INPUT_MESSAGE_MIN_LENGTH(0),
    GAME_NUMBER_MIN_RANGE(1),
    GAME_NUMBER_MAX_RANGE(10),
    ADD_ONE_SCORE(1),
    ADD_ZERO_SCORE(0);


    public int value;

    GameSettingNumbers(int value) {
        this.value = value;
    }
}
