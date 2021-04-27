package com.syl.game.baseball.application;

import com.syl.game.baseball.domain.player.BaseBallMachine;
import com.syl.game.baseball.domain.player.BaseBallPerson;
import com.syl.game.baseball.domain.util.BaseBallGameManager;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

    private BaseBallGameManager manager;
    private BaseBallMachine machine;
    private BaseBallPerson person;
    private BaseBallGame baseBallGame;

    @Test
    public void play() {
        manager = new BaseBallGameManager();
        machine = new BaseBallMachine();
        person = new BaseBallPerson();
        baseBallGame = new BaseBallGame(manager, machine, person);

        baseBallGame.play();
    }

    @Test
    public void replay() {
    }
}