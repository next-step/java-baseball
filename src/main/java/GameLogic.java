import java.util.List;

public class GameLogic {

    public int compareSameIndex(List<Integer> initNum, List<Integer> input) {
        if (initNum.size() != input.size()) {
            throw new IllegalArgumentException("동일한 자리수의 List만 비교가 가능합니다.");
        }
        int sameCount = 0;
        for (int i = 0; i < initNum.size(); i++) {
            sameCount += compareSameNum(initNum.get(i), input.get(i));
        }
        return sameCount;
    }

    private int compareSameNum(int a, int b) {
        if (a == b) return 1;
        return 0;
    }

    public int compareDiffIndex(List<Integer> initNum, List<Integer> input) {
        int sameCount = 0;
        for (int i = 0; i < initNum.size(); i++) {
            sameCount += compareListNum(initNum.get(i), i, input);
        }
        return sameCount;
    }

    private int compareListNum(int a, int aIdx, List<Integer> b) {
        int sameCount = 0;
        for (int i = 0; i < b.size(); i++) {
            sameCount += compareSameNumWithIdx(a, aIdx, b.get(i), i);
        }
        return sameCount;
    }

    private int compareSameNumWithIdx(int a, int aIdx, int b, int bIdx) {
        if (aIdx == bIdx) return 0;
        if (a == b) return 1;
        return 0;
    }
}
