import baseball.Main;
import baseball.NumberGenerator;
import baseball.Referee;

public class GameStarter {

    public static void main(String[] args) {
        Referee referee = new Referee();
        NumberGenerator numberGenerator = new NumberGenerator();
        Main main = new Main(referee,numberGenerator);
        main.start();

    }
}
