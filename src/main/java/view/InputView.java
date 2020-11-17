package view;


import util.GameScanner;

public class InputView {

    InputView(String message) {
        print(message);
    }

    public static InputView request(String message) {
        return new InputView(message);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public int inputNumber() {
        return GameScanner.inputNumber();
    }

    public String inputString() {
        return GameScanner.inputString();
    }
}
