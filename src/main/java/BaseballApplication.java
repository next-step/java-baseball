import domain.BaseballGame;
import util.RandomNumberGenerator;
import view.ViewLayerImpl;

public class BaseballApplication {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(RandomNumberGenerator.makeBaseballNumber(), new ViewLayerImpl(),true);
        baseballGame.init();
    }
}
