package baseball;

import baseball.dto.BaseballGameJudgeDto;

import java.util.Random;

public class BaseballGameStarter {

    private BaseballGameIO gameIO = new BaseballGameIO();
    private BaseballGameJudgeService judgeService = new BaseballGameJudgeService();

    private String computerNumber;

    public void start() {
        boolean isReplay;

        do {
            playGame();
            gameIO.printRegame();
            isReplay = gameIO.scanReplay();
        } while (isReplay);
    }

    private void playGame() {
        BaseballGameJudgeDto judge;
        init();

        do {
            gameIO.printInputComment();
            String inputNumber = gameIO.scanInputNumber();
            judge = judgeService.judge(computerNumber, inputNumber);
            gameIO.printJudgeResult(judge);
        } while (!judgeService.isEnd(judge));

        gameIO.printBye();
    }


    private void init() {
        computerNumber = makeComputerNumber();
        // test
        System.out.println("computerNumber=" + computerNumber);
    }

    String makeComputerNumber() {
        Random random = new Random();
        boolean[] checked = new boolean[10];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0 ; i < 3 ; i++) {
            stringBuilder.append(getDistinctRandomInt(random, checked));
        }

        return stringBuilder.toString();
    }

    private int getDistinctRandomInt(Random random, boolean[] checked) {
        int randomInt = random.nextInt(9) + 1; // 1 ~ 9 랜덤한 수
        if (!checked[randomInt]) {
            checked[randomInt] = true;
            return randomInt;
        }

        return getDistinctRandomInt(random, checked);
    }
}
