package domain;

import exception.InvalidGameStatusException;

import java.util.Scanner;

import static domain.BaseballCodeDefinition.*;

public class Game {
    private Player player;
    private int status;

    public Game() {
        init();
    }

    private void init() {
       this.player = new Player(new Number());
       this.status = START;
    }

    public boolean isOver() {
        return this.status == END;
    }

    public void play(Scanner scanner) {
        init();
        iterateEnterUserNumber(scanner);
        end(scanner);
    }

    private void iterateEnterUserNumber(Scanner scanner) {
        boolean isStrikeOut = false;

        while (!isStrikeOut) {
            System.out.print(ENTER_NUMBER_MESSAGE);
            GameResult result = player.result(new Number(scanner.nextInt()));
            System.out.println(result.toString());
            isStrikeOut = result.isStrikeOut();
        }
    }

    private void end(Scanner scanner) {
        System.out.println(GAME_END_MESSAGE);
        updateGameStatus(scanner.nextInt());
    }

    private void updateGameStatus(int status) {
        if (status == START || status == END) {
            this.status = status;
            return;
        }

        throw new InvalidGameStatusException();
    }
}
