package baseball.judgment;

import baseball.model.InningsResult;
import baseball.model.random.BaseballNumber;
import baseball.model.random.BaseballNumberImpl;

public class BaseballJudgmentImpl implements BaseballJudgment {
    private final BaseballNumber baseballNumber = new BaseballNumberImpl();
    private InningsResult currentInningsResult;

    private boolean isContinueGame = true;

    @Override
    public void playNewGame() {
        baseballNumber.makeRandomAnswer();
    }

    @Override
    public void putInningsResult(String oneInnings) {
        currentInningsResult = baseballNumber.solveAnswer(oneInnings);
    }

    @Override
    public InningsResult getCurrentInnings() {
        return currentInningsResult;
    }

    @Override
    public boolean isContinueGame() {
        return isContinueGame;
    }

    @Override
    public void nextMatch(boolean isFinishGame) {
        if(isFinishGame){
            finishGame();
        }else{
            playNewGame();
        }
    }

    private void finishGame(){
        isContinueGame = false;
    }
}