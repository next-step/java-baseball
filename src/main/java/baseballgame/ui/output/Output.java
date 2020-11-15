package baseballgame.ui.output;

import baseballgame.dto.CompareResult;

public interface Output {
    void demandingUserScore();
    void gameScore(CompareResult result);
    void gameFinish();
    void demandingWhetherWantToRestartGame();
    void errorInvalidInputValue();
}
