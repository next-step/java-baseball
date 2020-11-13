package baseball;

import baseball.service.GameNumberPackageGenerator;
import baseball.service.RandomGameNumberPackageGenerator;

public class BaseballGameLauncher {
    public static void main(String[] args) {
        GameNumberPackageGenerator randomGenerator = new RandomGameNumberPackageGenerator();
        BaseballGameProcessor gameProcessor = new BaseballGameProcessor(randomGenerator);
        gameProcessor.proceed();
    }
}
