package baseball.model.random;

import baseball.model.InningsResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BaseballNumberImpl implements BaseballNumber {
    private final static int ANSWER_LENGTH = 3;
    private final Random random = new Random(System.currentTimeMillis());
    private final Map<Integer, Integer> baseballNumberMap = new HashMap<>();

    @Override
    public void makeRandomAnswer() {
        baseballNumberMap.clear();
        while (baseballNumberMap.size() < 3) {
            int randomCount = random.nextInt(10);
            if (!baseballNumberMap.containsValue(randomCount)) {
                baseballNumberMap.put(baseballNumberMap.size(), randomCount);
            }
        }
    }

    @Override
    public InningsResult solveAnswer(String oneInnings) {
        InningsResult inningsResult = new InningsResult();
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            int oneCount = oneInnings.charAt(i) - '0';
            int answerCount = baseballNumberMap.get(i);

            if(answerCount == oneCount){
                inningsResult.addStrikeCount();
            }else if(baseballNumberMap.containsValue(oneCount)){
                inningsResult.addBallCount();
            }else{
                inningsResult.addOutCount();
            }
        }
        return inningsResult;
    }
}
