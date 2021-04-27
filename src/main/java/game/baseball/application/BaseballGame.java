package game.baseball.application;

import game.Game;
import game.GameOption;
import game.baseball.domain.Answer;
import game.baseball.domain.rule.BaseballGameRule;
import game.baseball.domain.Result;
import game.baseball.domain.role.BasicPlayer;
import game.baseball.domain.role.BasicReferee;
import game.baseball.domain.role.Player;
import game.baseball.domain.role.Referee;
import utils.InputUtil;

import java.util.List;

public class BaseballGame implements Game {

    private static final GameOption gameOption = new GameOption();

    private static BaseballGameRule rule;
    private static Player player;
    private static Referee referee;

    private Answer answer;

    private boolean playing;
    private int runningCount;

    public BaseballGame(BaseballGameRule rule) {
        this.rule = rule;
        this.player = new BasicPlayer();
        this.referee = new BasicReferee(rule);
    }

    @Override
    public void start() {
        System.out.println(">> 숫자야구 게임 시작");
        this.init();
    }

    @Override
    public void run() {
        String inputString = inputAnswerByPlayer();

        // 입력값 유효성 검증
        if (!rule.isValidInput(inputString)) {
            return;
        }

        // 심판 판단
        Result result = referee.judge(getInputList(inputString), answer.getAnswers());

        // 결과 출력
        referee.sayResult(result);

        // 정답 여부 확인
        if (rule.isSuccess(result)) {
            rule.printSuccessMsg();
            this.selectContinueOrExitGame();
            return;
        }
    }

    private List<Integer> getInputList(String playerInput) {
        List<Integer> inputList = InputUtil.transferStringToIntegerList(playerInput);
        return inputList;
    }

    @Override
    public boolean isPlaying() {
        return playing;
    }


    @Override
    public void restart() {
        this.init();
    }

    @Override
    public void exit() {
        this.playing = false;
    }

    @Override
    public void end() {
        System.out.println(">> 숫자야구 게임 종료");
    }

    private void init() {
        initGameStatus(); // 게임 상태 초기화
        initAnswer(); // 정답 초기화
    }

    private void initGameStatus() {
        this.playing = true;
        this.runningCount = 0;
    }

    private void initAnswer() {
        this.answer = rule.generateAnswers();
    }

    private void selectContinueOrExitGame() {
        System.out.println("게임을 새로 시작하려면 " + gameOption.getContinueHotKey() + ", 종료하려면 " + gameOption.getExitHotKey() + "를 입력하세요.");

        String input = "";

        while (!(gameOption.isExit(input) || gameOption.isContinue(input))) {
            input = player.inputNumber();
        }

        if (gameOption.isContinue(input)) {
            this.restart();
            return;
        }

        if (gameOption.isExit(input)) {
            this.exit();
            return;
        }
    }

    private String inputAnswerByPlayer() {
        System.out.print("숫자를 입력해주세요 : ");

        // 사용자 숫자 입력
        return player.inputNumber();
    }

}
