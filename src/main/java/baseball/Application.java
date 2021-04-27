package baseball;

import baseball.config.BaseballConfig;
import baseball.model.Computer;
import baseball.view.Monitor;

public class Application {

    private Computer computer;
    private Monitor monitor;

    public Application() {
        init();
    }

    private void init() {
        createComputer();
        createMonitor();
    }

    private void createComputer() {
        computer = new Computer();
        computer.generateBalls();
    }

    private void createMonitor() {
        monitor = new Monitor();
    }

    private void start() {
        int answer = monitor.askAnswer();
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}