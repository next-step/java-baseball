package baseball;

import baseball.domain.Adversary;
import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Player;
import baseball.enums.ApplicationOption;
import baseball.exception.IncorrectInputException;
import baseball.exception.IncorrectNumbersException;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            new Application().start();
        } catch (IncorrectInputException | IncorrectNumbersException e) {
            System.err.println(e.getMessage());
        }
    }

    public void start() {
        Adversary adversary = new Computer();
        Player player = new Player();
        do {
            Game game = new Game(adversary, player);
            game.play();
        } while (isRestart());
    }

    private boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = scanner.nextLine();
        if (!ApplicationOption.containsValue(inputValue)) {
            throw new IncorrectInputException("잘못된 옵션값을 입력하였습니다.");
        }
        return ApplicationOption.RESTART.getValue().equals(inputValue);
    }
}
