package baseball;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInputScanner implements InputScanner {

    final Scanner scanner;

    public ConsoleInputScanner(){
        this.scanner = new Scanner(System.in);
    }

    public String inputNumberLength3() {
        String input;
        do {
            System.out.print("숫자를 입력해주세요: ");
            input = scanner.next();
        } while(!Validator.isNumber(input) || !Validator.isLength3(input));

        return input;
    }
}
