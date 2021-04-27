package com.syl.game;

import com.syl.game.baseball.application.BaseBallGame;
import com.syl.game.baseball.domain.player.BaseBallMachine;
import com.syl.game.baseball.domain.player.BaseBallPerson;
import com.syl.game.baseball.domain.util.BaseBallGameManager;

public class GameApplication {

    public static void main(String[] args) {
        BaseBallGameManager manager = new BaseBallGameManager();
        BaseBallMachine machine = new BaseBallMachine();
        BaseBallPerson person = new BaseBallPerson();

        BaseBallGame baseBallGame = new BaseBallGame(manager, machine, person);
        do {
            baseBallGame.play();
        } while (baseBallGame.replay());

    }
}
