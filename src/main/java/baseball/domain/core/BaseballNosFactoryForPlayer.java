package baseball.domain.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.domain.core.BaseballNos.MAX_BASEBALL_LIST_SIZE;
import static baseball.domain.core.BaseballNosException.newNotCorrectBaseballNosException;

final class BaseballNosFactoryForPlayer {
    static BaseballNos generate(String baseballNos){
        if (isNotCorrectBaseballNos(baseballNos)){
            throw newNotCorrectBaseballNosException();
        }
        return new BaseballNos(toBaseballNos(baseballNos));
    }

    private static List<BaseballNo> toBaseballNos(String baseballNos) {
        final List<BaseballNo> temp = new ArrayList<>(MAX_BASEBALL_LIST_SIZE);
        for (char charNo : baseballNos.toCharArray()) {
            temp.add(BaseballNo.valueOf(charNo - '0'));
        }
        return Collections.unmodifiableList(temp);
    }

    private static boolean isNotCorrectBaseballNos(String baseballNos){
        return (null != baseballNos)
                && (!baseballNos.matches("^[1-9]{3}$"));
    }
}
