package baseball;

import java.util.*;

public class JudgmentBehaviorImpl implements JudgmentBehavior {
    private final Random random = new Random(System.currentTimeMillis());
    private final Map<Integer, Integer> answer = new HashMap<>();
    private boolean isContinueGame = true;

    @Override
    public InningsResult getInningsResult(String oneInnings) {
        InningsResult inningsResult = new InningsResult();
        for (int i = 0; i < oneInnings.length(); i++) {
            int oneCount = oneInnings.charAt(i) - '0';
            int answerCount = answer.get(i);

            if(answerCount == oneCount){
                inningsResult.addStrikeCount();
            }else if(answer.containsValue(oneCount)){
                inningsResult.addBallCount();
            }else{
                inningsResult.addOutCount();
            }
        }

        return inningsResult;
    }

    @Override
    public boolean isContinueGame() {
        return isContinueGame;
    }

    @Override
    public void checkFinishGame(InningsResult inningsResult, boolean isFinishGame) {
        this.isContinueGame = isFinishGame;
        if(inningsResult.isEndMatch() && isContinueGame){
            startNewGame();
        }
    }

    @Override
    public void startNewGame() {
        clearAnswer();
        makeRandomNumber();
    }

    private void clearAnswer(){
        answer.clear();
    }

    private void makeRandomNumber() {
        while (answer.size() < 3) {
            int randomCount = random.nextInt(10);
            if (!answer.containsValue(randomCount)) {
                answer.put(answer.size(), randomCount);
            }
        }
    }
}