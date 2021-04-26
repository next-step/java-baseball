package baseballgame;

import baseballgame.io.Messages;
import baseballgame.number.AnswerNumber;
import baseballgame.number.BaseballNumber;
import baseballgame.number.InputNumber;
import baseballgame.result.BaseballResult;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

import static baseballgame.io.Console.print;
import static baseballgame.io.Console.println;
import static baseballgame.util.TypeCastHelper.stringToList;

@RequiredArgsConstructor
public class GameCenter {

    private final Scanner scanner;

    public void startGame() {
        BaseballNumber answerNumber = new AnswerNumber();
        boolean isClear = false;
        do {
           isClear = playGame(answerNumber);
        } while (!isClear);
        clearGame();
    }

    private boolean playGame(BaseballNumber answerNumber) {
        BaseballResult baseballResult = null;
        try {
            BaseballNumber inputNumber = requestInput();
            baseballResult = new BaseballResult(inputNumber, answerNumber);
            println(baseballResult.getMessage());
            return baseballResult.isClear();
        } catch (IllegalArgumentException e) {
            println(Messages.INVALID_INPUT.getMessage());
            return false;
        }
    }

    private BaseballNumber requestInput() throws IllegalArgumentException {
        print(Messages.REQUEST_NUMBER.getMessage());
        List<String> input = stringToList(scanner.next());
        return new InputNumber(input);
    }

    private void clearGame() {
        println(Messages.GAME_CLEAR.getMessage());
        println(Messages.GAME_RESTART.getMessage());
        String input = scanner.next();
        if ("1".equals(input)) {
            startGame();
        }
    }

}
