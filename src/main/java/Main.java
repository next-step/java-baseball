import app.InputValidator;

import java.util.Scanner;

public class Main {

    public static final String INPUT_VALID_MESSAGE = "입력값은 3자리의 숫자여야 합니다.";

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (!InputValidator.isValid(input)) {
            System.out.println(INPUT_VALID_MESSAGE);
        }
    }
}
