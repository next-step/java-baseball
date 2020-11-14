package view;

import domain.*;

import java.util.Scanner;

import static util.Printer.println;
import static view.GameViewMessage.*;

public class BaseBallGame {
    private Scanner scanner = new Scanner(System.in);
    private GameRound gameRound = GameRound.START;
    private BaseBallNumbers computer;

    BaseBallGame() {
        computer = new RandomableBaseBallNumbers();
    }

    public void play() {
        play(false);
    }

    public void play(boolean replay) {
        if(replay) {
            computer = new RandomableBaseBallNumbers();
            gameRound = GameRound.START;
        }
        round();
    }

    public void round() {
        while(gameRound != GameRound.WIN) {
            println(INPUT_MESSAGE);
            BaseBallNumbers user = new InputableBaseBallNumbers(scanner.nextLine());
            BaseBallCount count = BaseBallCount.of(computer, user);
            report(count);
        }
        chooseCommand();
    }

    public void report(BaseBallCount count) {
        println(count);
        if(count.isThreeStrike()) {
            gameRound = GameRound.WIN;
            println(WIN_MESSAGE);
        }
    }

    public void chooseCommand() {
        println(CHOOSE_COMMAND_MESSAGE);
        GameCommand command = GameCommand.get(scanner.nextLine());
        if(command == GameCommand.EXIT) return;
        play(true);
    }
}
