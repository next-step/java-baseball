package com.jaeeyeonling.baseball;

import com.jaeeyeonling.baseball.ball.Balls;
import com.jaeeyeonling.baseball.view.InputView;
import com.jaeeyeonling.baseball.view.OutputView;

public class EntryPoint {

    public static void main(final String... args) {
        try (final var inputView = InputView.ofSystem();
             final var outputView = OutputView.ofSystem()) {
            start(inputView, outputView);
        }
    }

    private static void start(final InputView inputView,
                              final OutputView outputView) {
        final var game = BaseballGame.random();
        while (game.notComplete()) {
            outputView.printInputBalls();

            final var balls = Balls.of(inputView.readBalls());
            game.pitch(balls);

            outputView.println(game.getReport());
        }

        outputView.printEnding();
        outputView.printRetry();

        startOrEnd(inputView, outputView);
    }

    private static void startOrEnd(final InputView inputView,
                                   final OutputView outputView) {
        final var command = inputView.getCommand();
        if (Command.isStart(command)) {
            start(inputView, outputView);
            return;
        }
        if (Command.isEnd(command)) {
            return;
        }

        startOrEnd(inputView, outputView);
    }
}
