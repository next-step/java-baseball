package baseball.domain.core;

import java.util.HashSet;
import java.util.List;

import static baseball.domain.core.BaseballNosException.newDuplicateBaseballNosException;
import static baseball.domain.core.ComparingOtherBaseballNo.ComparingProcess.registe;
import static baseball.domain.core.ComparingOtherBaseballNo.otherBaseballNo;

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

    BaseballNo getBaseballNo(int index){
        return baseballNos.get(index);
    }

    boolean isFoundIndex(BaseballNo baseballNo){
        return baseballNos.contains(baseballNo);
    }

    private boolean isStrike(int index, BaseballNo otherBaseballNo){
        return getBaseballNo(index).equals(otherBaseballNo);
    }

    private boolean isBall(int index, BaseballNo otherBaseballNo){
        final int foundIndex = baseballNos.indexOf(otherBaseballNo);
        return isFoundIndex(otherBaseballNo) && (index != foundIndex);
    }

    public BaseballResult compareTo(BaseballNos otherBaseballNos){
        BaseballResult baseballResult = new BaseballResult();
        for (int index = 0; index < MAX_BASEBALL_LIST_SIZE; index++) {
//            BaseballNo otherBaseballNo = otherBaseballNos.getBaseballNo(index);
//            if (isStrike(index, otherBaseballNo)){
//                baseballResult.incrementStrike();
//            }
//            if (isBall(index, otherBaseballNo)){
//                baseballResult.incrementBall();
//            }
            otherBaseballNo(index, otherBaseballNos.getBaseballNo(index))
                    .comparing(
                            registe(this::isStrike, baseballResult::incrementStrike),
                            registe(this::isBall, baseballResult::incrementBall)
                    );
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
