package baseball;

import java.util.Scanner;
import baseball.ui.Program;

public class Application {

    public static void main(String[] args) {
        Program program = new Program(new Scanner(System.in));
        program.run();
    }
}
