package baseball;

import features.NumberUtil;
import features.Validator;
import io.PrintInput;
import model.Result;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private boolean playing = true;
    private List<Integer> answer;
    private final Result result = new Result();
    private final PrintInput printInput = new PrintInput(new Scanner(System.in));

    public void play() {
        while (playing) {
            // Reset Strike and Ball count
            result.resetCount();
            // Generate Random number
            answer = NumberUtil.generateAnswer();
            doGuess();
            playing = false; // Test only Code
            // TODO: Quit when user got the answer
        }
    }

    private void doGuess() {
        while (result.getStrike() != 3) {
            getInput();
            System.out.println(String.format("%d Strike %d Ball", result.getStrike(), result.getBall()));
        }
    }

    private void getInput() {
        while(true) {
            String userInput = printInput.recieveUserNumber();
            if(!Validator.isCorrectInput(userInput)) {
                // TODO: print output error
                continue;
            }
            check(userInput);
            break;
        }
    }

    private void check(String userInput) {
        List<Integer> userList = NumberUtil.convertString(userInput);
        result.compare(answer, userList);
        // TODO: check user number and hidden answer
    }
}
