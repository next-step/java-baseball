import baseball.model.Numbers;
import baseball.model.WinningNumbers;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;

public class Application {
    public static void main(final String... args){
        final WinningNumbers inputWinningNumbers = ConsoleInputView.readWinningNumbers();

        int strikeCount = 0;
        int ballCount = 0;

        do {
            while(strikeCount < 3) {
                Numbers gameNumbers = ConsoleInputView.readNumbers();
                strikeCount = inputWinningNumbers.getStrike(gameNumbers);
                ballCount = inputWinningNumbers.getBall(gameNumbers);
                ConsoleOutputView.printGameResult(strikeCount, ballCount);
            }

            ConsoleOutputView.printEndGame();
            ConsoleOutputView.newline();
        } while (ConsoleInputView.readRestart() == 1);
    }
}
