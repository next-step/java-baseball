package baseball;

import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.ThreeNumberGenerator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        NumberGenerator generator = new ThreeNumberGenerator();
        String userInput = scanner.nextLine();

        BaseballGameModel model = new BaseballGameModel(userInput, generator);
        int[] ints = model.guessNumber();
        System.out.println(model.printBallCountMessages(ints[0], ints[1]));
    }
}
