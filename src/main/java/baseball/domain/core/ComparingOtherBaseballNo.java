package baseball.domain.core;

import java.util.function.BiPredicate;
import java.util.function.IntSupplier;

final class ComparingOtherBaseballNo {
    private final int index;
    private final BaseballNo otherBaseballNo;

    private ComparingOtherBaseballNo(int index, BaseballNo otherBaseballNo) {
        this.index = index;
        this.otherBaseballNo = otherBaseballNo;
    }

    static ComparingOtherBaseballNo otherBaseballNo(int index, BaseballNo otherBaseballNo) {
        return new ComparingOtherBaseballNo(index, otherBaseballNo);
    }

    static final class ComparingProcess {
        private final BiPredicate<Integer, BaseballNo> predicateOperate;
        private final IntSupplier increment;

        private ComparingProcess(BiPredicate<Integer, BaseballNo> predicateOperate, IntSupplier increment) {
            this.predicateOperate = predicateOperate;
            this.increment = increment;
        }

        static ComparingProcess registe(BiPredicate<Integer, BaseballNo> predicateOperate, IntSupplier increment) {
            return new ComparingProcess(predicateOperate, increment);
        }

        private boolean test(int index, BaseballNo otherBaseballNo) {
            return predicateOperate.test(index, otherBaseballNo);
        }

        private int increment() {
            return increment.getAsInt();
        }
    }

    void comparing(ComparingProcess... comparingProcesses) {
        for (ComparingProcess comparingProcess : comparingProcesses) {
            if (comparingProcess.test(index, otherBaseballNo)) {
                comparingProcess.increment();
            }
        }
    }
}
