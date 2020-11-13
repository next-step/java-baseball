package baseball;

import baseball.domain.GameNumberPackage;
import baseball.domain.InputNumbers;
import baseball.domain.TrialResult;
import baseball.service.GameNumberPackageGenerator;
import baseball.service.TrialResultCalculator;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGameProcessor {
    private final GameNumberPackageGenerator gameNumberPackageGenerator;

    public BaseballGameProcessor(GameNumberPackageGenerator gameNumberPackageGenerator) {
        this.gameNumberPackageGenerator = gameNumberPackageGenerator;
    }

    private static boolean doAnotherGame() {
        String command;
        do {
            command = InputView.getDoAnotherGameCommand();
            if (InputView.isStopCommand(command)) {
                return false;
            }
        } while (!InputView.isAnotherGameCommand(command));

        return true;
    }

    public void proceed() {
        do {
            GameNumberPackage gameNumberPackage = gameNumberPackageGenerator.generate();
            tryUntilFinish(gameNumberPackage);
        } while (doAnotherGame());
    }

    private void tryUntilFinish(GameNumberPackage gameNumberPackage) {
        while (doAnotherTrial(gameNumberPackage)) ;
    }

    private boolean doAnotherTrial(GameNumberPackage gameNumberPackage) {
        String inputNumbers = InputView.getInputNumbers();

        TrialResult trialResult = new TrialResult(
            new TrialResultCalculator(gameNumberPackage, InputNumbers.from(inputNumbers.toCharArray()))
        );

        ResultView.showResult(trialResult);
        return !trialResult.finished();
    }
}
