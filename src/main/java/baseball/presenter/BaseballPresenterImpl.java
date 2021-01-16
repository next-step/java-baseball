package baseball.presenter;

import baseball.presenter.judgment.BaseballJudgment;
import baseball.presenter.judgment.BaseballJudgmentImpl;
import baseball.model.InningsResult;
import baseball.view.BaseballView;

public class BaseballPresenterImpl implements BaseballPresenter {
    private final BaseballJudgment baseballJudgment = new BaseballJudgmentImpl();
    private BaseballView baseBallView;

    @Override
    public void setBaseBallView(BaseballView baseBallView) {
        this.baseBallView = baseBallView;
    }

    @Override
    public void play(){
        playNewGame();
        do {
            playInnings();
            playEndInnings();
            checkFinishGame(checkEndMatch());
        } while(isContinueGame());
    }

    private void playNewGame(){
        baseballJudgment.playNewGame();
    }

    private void playInnings(){
        baseBallView.printStartInnings();
        String oneInnings = baseBallView.inputOneInnings();
        baseballJudgment.putInningsResult(oneInnings);
    }

    private void playEndInnings(){
        InningsResult currentInningsResult = baseballJudgment.getCurrentInnings();
        baseBallView.printInningsResult(currentInningsResult);
    }

    private boolean checkEndMatch(){
        return baseballJudgment.getCurrentInnings().isEndMatch();
    }

    private void checkFinishGame(boolean isEndMatch){
        if(isEndMatch){
            baseBallView.printFinishInnings();
            boolean isFinishGame = baseBallView.inputIsFinishGame();
            baseballJudgment.nextMatch(isFinishGame);
        }
    }

    private boolean isContinueGame(){
        return baseballJudgment.isContinueGame();
    }
}