package baseball.models;

import baseball.ui.FastScanner;

public class BaseBallNumGame {


    private boolean isFinished;
    private Result isDone = Result.INITIALIZE;
    private final FastScanner fs = FastScanner.of();

    private final RandomNumGenerator randomNumGenerator;
    private final PrintGenerator printGenerator;


    public BaseBallNumGame(RandomNumGenerator randomNumGenerator, PrintGenerator printGenerator) {
        this.randomNumGenerator = randomNumGenerator;
        this.printGenerator = printGenerator;
    }

    public void play() {

        String random = randomNumGenerator.getThreeNumbers();
        do {
            String input = printGenerator.inputNumbers();
            Integer[] results = printGenerator.printAndGetStrikeOrBall(random, input);

            checkIfFinished(results[0]);
            random = randomShuffleIfRetry(random);
        } while (isDone != Result.EXIT);
    }


    private String randomShuffleIfRetry(String random) {
        if (isDone == Result.RESTART) {
            isDone = Result.INITIALIZE;
            return randomNumGenerator.getThreeNumbers();
        }
        return random;
    }

    private void checkIfFinished(int strike) {
        if (strike == 3) isFinished = true;

        if (isFinished) {
            printGenerator.Exited();
            isFinished = false;
            isDone = Result.valueOf(fs.nextInt());
        }
    }


}
