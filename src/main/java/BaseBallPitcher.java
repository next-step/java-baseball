import java.util.HashSet;
import java.util.Set;

public class BaseBallPitcher {

    /**
     * 1~9 숫자 배열에서 중복 되지 않게 랜덤 숫자 뽑기 (RANDOM_NUMBER_LENGTH 자릿수)
     *
     * @return number 중복 되지 않은 숫자
     */
    public Set<Integer> generateRandomNumber() {
        final int START_NUMBER = 1;
        final int END_NUMBER = 10;

        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() != PlayGame.RANDOM_NUMBER_LENGTH) {
            numberSet.add((int) (Math.random() * (END_NUMBER - START_NUMBER - 1)) + START_NUMBER);
        }
        return numberSet;
    }
}
