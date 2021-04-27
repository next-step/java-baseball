package baseball;

import baseball.config.BaseballConfig;
import baseball.model.Computer;
import baseball.value.Result;
import baseball.view.Monitor;

public class Application {

    private int remainChance;
    private Computer computer;
    private Monitor monitor;

    public Application() {
        init();
    }

    private void init() {
        remainChance = BaseballConfig.CHANCES;
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
        while (remainChance > 0) {
            int answer = monitor.askAnswer();
            Result result = computer.validate(answer);
            monitor.showResult(result);

            if (result.getStrike() == BaseballConfig.BALL_COUNT) {
                monitor.showWin();
                break;
            }
            remainChance--;
        }
    }

    private boolean restart() {
        int restart = monitor.askRestart();
        if (restart == 1) {
            init();
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Application app = new Application();

        do {
            app.start();
        } while (app.restart());
    }
}