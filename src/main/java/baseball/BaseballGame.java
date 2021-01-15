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

    public void play() {
        while (playing) {
            // Reset Strike and Ball count
            result.resetCount();
            // Generate Random number
            answer = NumberUtil.generateAnswer();
            doGuess();
            printOutput.printComplete();
            playing = false; // Test only Code
            // TODO: Quit when user got the answer
        }
    }

    private void doGuess() {
        while (result.getStrike() != 3) {
            getInput();
            PrintResult.checkResult(result.getStrike(), result.getBall(), printOutput);
        }
    }

    private void getInput() {
        while(true) {
            String userInput = printInput.recieveUserNumber();
            if(!Validator.isCorrectInput(userInput)) {
                printOutput.printError();
                continue;
            }
            check(userInput);
            break;
        }
    }

    private void check(String userInput) {
        List<Integer> userList = NumberUtil.convertString(userInput);
        result.compare(answer, userList);
    }
}
