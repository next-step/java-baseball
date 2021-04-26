package baseball.domain.core;

import java.util.List;

import static baseball.domain.core.BaseballNos.MAX_BASEBALL_LIST_SIZE;

final class BaseballNosFactoryForComputer {
    static BaseballNos generate(){
        final List<BaseballNo> shuffleBaseballNos = BaseballNo.shuffleBaseballNos();

        return new BaseballNos(shuffleBaseballNos
                .subList(0, MAX_BASEBALL_LIST_SIZE));
    }
}
