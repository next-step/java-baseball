import domain.BaseballGame;
import domain.RandomNumberGenerator;
import domain.RandomNumbersGenerator;
import ui.IOManager;
import ui.StandardInput;
import ui.StandardOutput;

public class Application {
    public static void main(String[] args) {
        IOManager ioManager = new IOManager(new StandardInput(), new StandardOutput());
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator(randomNumberGenerator);

        BaseballGame game = new BaseballGame(ioManager, randomNumbersGenerator);
        game.run();
    }
}
