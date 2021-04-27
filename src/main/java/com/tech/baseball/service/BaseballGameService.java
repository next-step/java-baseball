package com.tech.baseball.service;

import com.tech.baseball.validator.BaseballGameValidator;
import com.tech.baseball.view.BaseballGameView;
import com.tech.baseball.vo.BaseballGameResult;

import java.util.HashSet;

public class BaseballGameService {

    private final BaseballGameView gameView = new BaseballGameView();
    private final NumberService numberService = new NumberService();
    private static final BaseballGameValidator validator = new BaseballGameValidator();

    HashSet<Integer> set = null;

    //게임 시작 로직
    public boolean baseballGameStart() {
        int[] computerGameNumber = numberService.makeComputerGameNumber();
        setComputerGameNumberHashSet(computerGameNumber);
        boolean finishGame;

        do {
            finishGame = progressGame(computerGameNumber);
        } while (!finishGame);

        return restartGame();
    }

    public void setComputerGameNumberHashSet(int[] computerGameNumber) {
        set = new HashSet<>();
        for(int i : computerGameNumber) {
            set.add(i);
        }
    }

    //게임 종료 후 재시작 유무 질의
    public boolean restartGame() {
        String input = gameView.getGameRestart().trim();
        boolean isValid = validator.checkRestartValid(input);

        while (!isValid){
            gameView.printGameResult("1 또는 2가 입력되지 않았습니다. 다시 입력해 주세요");
            input = gameView.getGameRestart().trim();
            isValid = validator.checkRestartValid(input);
        }

        return input.equals("1");
    }

    //게임 진행 로직
    public boolean progressGame(int[] computerGameNumber) {
        int[] userNumber = getUserNumber();

        BaseballGameResult result = checkBaseballGameResult(computerGameNumber, userNumber);

        if(isFinish(result)) return true;

        gameView.printGameResult(isNothing(result)? "낫싱":result.toString());
        return false;
    }

    public BaseballGameResult checkBaseballGameResult(int[] computerGameNumber, int[] userNumber) {
        BaseballGameResult result = new BaseballGameResult();

        result.setStrike(getStrike(computerGameNumber, userNumber));
        result.setBall(getBall(computerGameNumber, userNumber));

        return result;
    }

    public int[] getUserNumber() {
        String input = gameView.getUserNumber().trim();
        boolean isValid = validator.checkNumberValid(input);

        while (!isValid) {
            gameView.printGameResult("서로 다른 3자리 숫자가 입력되지 않았습니다.");
            input = gameView.getUserNumber().trim();
            isValid = validator.checkNumberValid(input);
        }

        return numberService.parseUserNumber(input);
    }

    public int getBall(int[] computerGameNumber, int[] userNumber) {
        int ball = 0;
        int idx = 0;

        while (idx < 3) {
            ball = set.contains(userNumber[idx])? ball+1:ball;
            ball = computerGameNumber[idx]==userNumber[idx]? ball-1:ball;
            idx++;
        }

        return ball;
    }

    public int getStrike(int[] computerGameNumber, int[] userNumber) {
        int strike = 0;
        int idx = 0;

        while (idx < 3) {
            strike = computerGameNumber[idx]==userNumber[idx]? strike+1:strike;
            idx++;
        }

        return strike;
    }

    public boolean isNothing(BaseballGameResult result){
        return result.getStrike() == 0 && result.getBall() == 0;
    }

    public boolean isFinish(BaseballGameResult result){
        return result.getStrike() == 3;
    }

}
