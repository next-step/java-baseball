package baseball.view;

import baseball.application.BaseballService;
import baseball.domain.BaseballNumbers;
import baseball.domain.Score;
import baseball.domain.enums.ScoreStatus;

import java.util.Scanner;

public class BaseballView {
    private final BaseballService baseballService;
    private final Scanner sc;
    private final String MESSAGE_ENTER_NUMERIC = "숫자를 입력해주세요 : ";
    private final String MESSAGE_RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private final int ANSWER_RE_GAME = 1;
    private final int ANSWER_EXIT = 2;

    public BaseballView() {
        baseballService = new BaseballService();
        sc = new Scanner(System.in);
    }

    public void start() {
        boolean isContinued = true;
        while (isContinued){
            BaseballNumbers answer = this.baseballService.generateAnswer();
            deduceNumber(answer);
            isContinued = askAboutReGame();
        }
    }

    private void deduceNumber(BaseballNumbers answer) {
        boolean isContinued = true;
        while (isContinued){
            String playerInput = enterPlayerInput();
            Score score = baseballService.scorePlayerInput(answer, playerInput);
            printScore(score);
            isContinued = ! score.isPassed();
        }
    }

    private String enterPlayerInput() {
        System.out.print(MESSAGE_ENTER_NUMERIC);
        return sc.next();
    }

    private void printScore(Score score) {
        if (! score.getScoreStatus().equals(ScoreStatus.ERROR)) {
            System.out.println(score.getJudgeMessage());
        }
    }

    private boolean askAboutReGame() {
        System.out.println(MESSAGE_RE_GAME);

        boolean result = false;
        int playerAnswer = sc.nextInt();
        if (playerAnswer == ANSWER_RE_GAME)
            result = true;
        else if (playerAnswer == ANSWER_EXIT)
            result = false;

        return result;
    }

}
