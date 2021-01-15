package baseball;

import features.NumberUtil;
import features.Validator;
import io.PrintInput;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private boolean playing = true;
    private final PrintInput printInput = new PrintInput(new Scanner(System.in));

    public void play() {
        while (playing) {
            getInput();
            break; // Test only Code
            // TODO: Quit when user got the answer
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
        // TODO: check user number and hidden answer
    }
}
