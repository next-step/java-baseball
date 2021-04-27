package baseball;

import baseball.model.Computer;
import baseball.view.Monitor;

public class Application {

    private Computer computer;

    public Application() {
        init();
    }

    private void init() {
        createComputer();
    }

    private void createComputer() {
        computer = new Computer();
        computer.generateBalls();
    }

    private void start() {

    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
