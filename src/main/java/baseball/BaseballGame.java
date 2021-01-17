package baseball;

import features.NumberUtil;
import features.PrintResult;
import features.Validator;
import io.PrintInput;
import io.PrintOutput;
import model.Result;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private boolean playing = true;
    private List<Integer> answer;
    private final Result result = new Result();
    private final PrintInput printInput = new PrintInput(new Scanner(System.in));
    private final PrintOutput printOutput = new PrintOutput();

    /**
     * Playing game and generate hidden number.
     */
    public void play() {
        while (playing) {
            // Reset Strike and Ball count
            result.resetCount();
            // Generate Random number
            answer = NumberUtil.generateAnswer();
            doGuess();
            printOutput.printComplete();
            askExit();
        }
    }

    /**
     * Ask user to quit or continue the game.
     */
    private void askExit() {
        String option = printInput.askUserOption();
        // When option is not validate, print error message and ask again.
        while(!Validator.isCorrectOption(option)) {
            printOutput.printError();
            option = printInput.askUserOption();
        }
        if (Integer.parseInt(option) == 2) {
            playing = false;
        }
    }

    /**
     * Playing game and generate hidden number.
     */
    private void doGuess() {
        // If strike count is 3, quit one game.
        while (result.getStrike() != 3) {
            getInput();
            PrintResult.checkResult(result.getStrike(), result.getBall(), printOutput);
        }
    }

    /**
     * Getting guess number from the user.
     */
    private void getInput() {
        while(true) {
            String userInput = printInput.receiveUserNumber();
            // When userInput is not validate, print error message and ask again.
            if(!Validator.isCorrectInput(userInput)) {
                printOutput.printError();
                continue;
            }
            check(userInput);
            break;
        }
    }

    /**
     * Compare user number and the hidden number.
     * @param userInput String of user input.
     */
    private void check(String userInput) {
        List<Integer> userList = NumberUtil.convertString(userInput);
        result.compare(answer, userList);
    }
}
