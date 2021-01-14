package baseball;

public interface JudgmentBehavior {
    InningsResult getInningsResult(String oneInnings); //1이닝이 들어오면, 결과를 돌려주는 함수입니다.
    boolean isContinueGame();
    void checkFinishGame(InningsResult inningsResult, boolean isFinishGame);
    void startNewGame();
}