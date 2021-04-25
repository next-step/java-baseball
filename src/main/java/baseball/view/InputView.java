package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }
    public void print(String printString) {
        System.out.print(printString);
    }

    public String question(String questionString) {
        this.print(questionString);
        return this.scanner.nextLine();
    }

    public List<Integer> questionToList(String questionString) {
        this.print(questionString);
        String inputString = this.scanner.nextLine();

        char[] inputNumbersChars = inputString.toCharArray();
        List<Integer> input = new ArrayList<>();
        for (char inputNumbersChar : inputNumbersChars) {
            input.add(Integer.parseInt(String.valueOf(inputNumbersChar)));
        }
        return input;
    }
}
