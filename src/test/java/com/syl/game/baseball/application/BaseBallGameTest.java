package com.syl.game.baseball.application;

import com.syl.game.baseball.domain.player.BaseBallMachine;
import com.syl.game.baseball.domain.player.BaseBallPerson;
import com.syl.game.baseball.ui.BaseBallGame;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

    private BaseBallMachine machine;
    private BaseBallPerson person;
    private BaseBallGame baseBallGame;

    @Test
    public void play() {
        machine = new BaseBallMachine();
        person = new BaseBallPerson();
        baseBallGame = new BaseBallGame(machine, person);

        baseBallGame.play();
    }

    @Test
    public void replay() {
    }
}