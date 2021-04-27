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

}
