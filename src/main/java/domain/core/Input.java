package domain.core;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    protected String in(){
        return scanner.next();
    }
}
