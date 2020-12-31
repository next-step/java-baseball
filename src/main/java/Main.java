import game.BaseballGame;
import game.InputManager;
import validators.BaseballNumberValidator;
import validators.EndNumberValidator;

public class Main {
    public static void main(String[] args){
        new BaseballGame()
                .setEndingInputChecker(new EndNumberValidator())
                .setInputManager(new InputManager())
                .setNumberChecker(new BaseballNumberValidator())
                .play();
    }
}
