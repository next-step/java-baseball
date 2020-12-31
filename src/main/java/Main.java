import game.BaseballGame;
import game.InputManager;
import validators.BaseballNumberValidator;
import validators.EndNumberValidator;

public class Main {
    public static void main(String[] args){
        new BaseballGame(
                new BaseballNumberValidator(),
                new EndNumberValidator(),
                new InputManager()
        ).play();
    }
}
