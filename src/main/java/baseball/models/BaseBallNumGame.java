package baseball.models;

import baseball.ui.FastScanner;

public class BaseBallNumGame {


    private boolean isFinished;
    private RESULT isDone = RESULT.INITIALIZE;
    private final FastScanner fs = FastScanner.of();

    private final RandomNumGenerator randomNumGenerator;
    private final PrintGenerator printGenerator;


    public BaseBallNumGame(RandomNumGenerator randomNumGenerator, PrintGenerator printGenerator) {
        this.randomNumGenerator = randomNumGenerator;
        this.printGenerator = printGenerator;
    }

    public void play() {

        //getRandomNumber();
        String random = randomNumGenerator.getThreeNumbers();
        do {


            // TODO 지우기
            System.out.println("현재 랜덤 숫자는 : " + random + " 입니다");

            String input = printGenerator.inputNumbers();
            Integer[] results = printGenerator.printAndGetStrikeOrBall(random, input);

            checkIfFinished(results[0]);

            random = randomShuffleIfRetry(random);

            // TODO 지우기
            System.out.println("현재 랜덤 숫자는 : " + random + " 입니다");

        } while (isDone != RESULT.EXIT);
    }


    private String randomShuffleIfRetry(String random) {
        if (isDone == RESULT.RESTART) {
            isDone = RESULT.INITIALIZE;
            return randomNumGenerator.getThreeNumbers();
        }
        return random;
    }

    private void checkIfFinished(int strike) {
        if (strike == 3) isFinished = true;

        if (isFinished) {
            printGenerator.Exited();
            isFinished = false;
            isDone = RESULT.valueOf(fs.nextInt());
        }
    }


}
