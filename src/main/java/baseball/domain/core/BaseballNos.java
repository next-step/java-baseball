package baseball.domain.core;

import baseball.domain.BaseballResult;

import java.util.HashSet;
import java.util.List;

import static baseball.domain.core.BaseballNosException.newDuplicateBaseballNosException;

public class BaseballNos {

    public static final int MAX_BASEBALL_LIST_SIZE = 3;
    private final List<BaseballNo> baseballNos;

    BaseballNos(List<BaseballNo> baseballNos) {
        if (isDuplicateBaseballNos(baseballNos)){
            throw newDuplicateBaseballNosException();
        }
        this.baseballNos = baseballNos;
    }

    public static BaseballNos formComputer(){
        return BaseballNosFactoryForComputer.generate();
    }

    public static BaseballNos formPlayerInputString(String baseballNos){
        return BaseballNosFactoryForPlayer.generate(baseballNos);
    }

    boolean isDuplicateBaseballNos(List<BaseballNo> baseballNos){
        return MAX_BASEBALL_LIST_SIZE != new HashSet<>(baseballNos).size();
    }

    int size(){
        return baseballNos.size();
    }

    BaseballNo get(int index){
        return baseballNos.get(index);
    }

    private boolean isStrike(int index, BaseballNos otherBaseballNos){
        final BaseballNo currentBaseballNo = baseballNos.get(index);
        final BaseballNo opponentBaseballNo = otherBaseballNos.get(index);

        return currentBaseballNo.equals(opponentBaseballNo);
    }

    private boolean isBall(int index, BaseballNos otherBaseballNos){
        final BaseballNo opponentBaseballNo = otherBaseballNos.get(index);
        final int NOT_FOUND_INDEX = -1;
        final int foundIndex = baseballNos.indexOf(opponentBaseballNo);

        return (NOT_FOUND_INDEX != foundIndex) && (index != foundIndex);
    }

    public BaseballResult compareTo(BaseballNos otherBaseballNos){
        BaseballResult baseballResult = new BaseballResult();
        for (int i = 0; i < MAX_BASEBALL_LIST_SIZE; i++) {
            if (isStrike(i, otherBaseballNos)){
                baseballResult.incrementStrike();
            }
            if (isBall(i, otherBaseballNos)){
                baseballResult.incrementBall();
            }
        }
        return baseballResult;
    }

    @Override
    public String toString() {
        return "BaseballNos{" +
                "baseballNos=" + baseballNos +
                '}';
    }
}
