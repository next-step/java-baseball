package jbh.numberbaseball;

public class BaseballGameApplication {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        while (game.isPlayGame()) {
            game.playGame();
        }
    }
}
