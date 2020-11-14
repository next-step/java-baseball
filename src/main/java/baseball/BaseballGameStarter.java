package baseball;

import baseball.dto.BaseballGameJudgeDto;

import java.util.Random;

public class BaseballGameStarter {

    private BaseballGameScanner gameScanner = new BaseballGameScanner();
    private BaseballGameJudgeService judgeService = new BaseballGameJudgeService();

    private String computerNumber;

    public void start() {
        BaseballGameJudgeDto judge;

        init();
        do {
            printInputComment();
            String inputNumber = gameScanner.scan();
            judge = judgeService.judge(computerNumber, inputNumber);
            judgeService.printJudgeResult(judge);

        } while (!judgeService.isEnd(judge));

        printBye();
    }


    private void init() {
        computerNumber = makeComputerNumber();
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

    ////////////
    private void printBye() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printInputComment() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printRegame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
