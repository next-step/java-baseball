package baseball;

import java.util.Scanner;

public class ConsoleInputScanner implements InputScanner {

    final Scanner scanner;

    public ConsoleInputScanner(){
        this.scanner = new Scanner(System.in);
    }

    public String inputNumberLength3() {
        String input;
        do {
            System.out.print(GameResource.TEXT_INPUT_NUMBER);
            input = scanner.next();
        } while(!Validator.isNumber(input) || !Validator.isLength3(input));

        return input;
    }

    @Override
    public String inputNumber1Or2(){
        return null;
    }
}
