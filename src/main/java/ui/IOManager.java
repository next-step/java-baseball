package ui;

public class IOManager {
    private final Input input;
    private final Output output;

    public IOManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public Input input() {
        return input;
    }

    public Output output() {
        return output;
    }
}
