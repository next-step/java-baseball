package game.baseball.number.input;

import game.baseball.number.exceptions.InvalidUserInputTypingException;
import java.util.Scanner;

public class InputManager implements AutoCloseable {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String input(HelperTexts helperTexts) {
        System.out.println(helperTexts.getHelperMessage());
        try {
            return SCANNER.nextLine();
        } catch (RuntimeException e) {
            throw new InvalidUserInputTypingException(e);
        }
    }

    @Override
    public void close() {
        SCANNER.close();
    }
}