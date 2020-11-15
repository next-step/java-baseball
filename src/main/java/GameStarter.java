import baseball.Game;
import baseball.NumberGenerator;
import baseball.Referee;

public class GameStarter {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        Referee referee = new Referee(numberGenerator.getNotDuplicatedEachHundredNumber());
        Game game = new Game(referee, numberGenerator);
        game.start();

    }
}
