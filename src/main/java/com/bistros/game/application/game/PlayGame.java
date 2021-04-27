package com.bistros.game.application.game;

import com.bistros.game.application.BallNumbersFactory;
import com.bistros.game.application.cli.PlayerInputs;
import com.bistros.game.domain.ball.BallNumbers;
import com.bistros.game.domain.game.GameReferee;
import com.bistros.game.domain.game.InningReport;

import java.util.List;
import java.util.Random;

public class PlayGame {

    private final Random random;
    private final BallNumbersFactory numberFactory;
    private final PlayerInputs inputs;


    public PlayGame() {
        random = new Random();
        numberFactory = new BallNumbersFactory(random);
        inputs = new PlayerInputs();
    }

    public void start() {
        do {
            run();
        } while (inputs.rerun());
    }


    private void run() {
        BallNumbers gameBallNumbers = numberFactory.generate();
        GameReferee referee = new GameReferee(gameBallNumbers);
        System.out.println(">> 새 게임을 시작합니다. 게임 정답 : " + gameBallNumbers);

        InningReport report;
        do {
            List<Integer> raw = inputs.fromGameInputByUser();
            report = referee.check(raw);

            System.out.println(report.getHint());
        } while (!report.isSuccessGame());
    }


}
