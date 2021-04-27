package controller;

import domain.Ball;
import domain.RandomNumber;
import domain.Strike;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameMain {

    public static void main(String[] args) {

        game_reset:
        while(true) {
            final List<Integer> randomNumber = RandomNumber.createRandomNumber();

            while (true) {
                int inputNum = InputView.readInt();

                if(inputNum > 999 || inputNum <= 0) {
                    continue;
                }
                List<Integer> input = new ArrayList<>();
                input.add(inputNum / 100);
                input.add((inputNum % 100) / 10);
                input.add(inputNum % 10);


                int strikeNum = Strike.checkStrike(input, randomNumber);
                int ballNum = Ball.checkBall(input, randomNumber);

                if (strikeNum == 0 && ballNum == 0) {
                    ResultView.fail();
                    continue;
                }

                if (strikeNum == 0) {
                    ResultView.printBall(ballNum);
                    continue;
                }

                if (ballNum == 0) {
                    ResultView.printStrike(strikeNum);
                    if (strikeNum == 3) {
                        ResultView.endGame();
                        int reset = InputView.resetGame();

                        if (reset == 1) {
                            continue game_reset;
                        } else {
                            break game_reset;
                        }
                    }
                    continue;
                }

                ResultView.printStrikeAndBall(strikeNum, ballNum);
            }
        }

    }
}
