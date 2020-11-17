package baseball;

import java.util.ArrayList;
import java.util.Random;

/**
 * 1부터 9까지 서로 다른 3자리 임의의 수 생성 클래스
 */
public class BaseballNumberMaker {

    public final int MIN_VALUE = 1;     // 최소값
    public final int MAX_VALUE = 9;     // 최대값
    public final int NUMBER_SIZE = 3;   // 숫자 크기

    /**
     * 최소값, 최대값에 해당하는 램덤 숫자 생성
     * @return 랜덤 숫자
     */
    public Integer makeRandomNumber() {
        Random random = new Random();
        return random.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
    }

    /**
     * 중복되지 않은 숫자를 리스트에 추가
     * @param numbers 중복되지 않은 숫자 리스트
     * @param random 랜덤 숫자
     */
    private void addNonDuplicateNumber(ArrayList<Integer> numbers, int random) {
        if (!numbers.contains(random)) {
            numbers.add(random);
        }
    }

    /**
     * 1부터 9까지 서로 다른 3자리 랜덤 숫자 리스트 생성
     * @return 랜덤 숫자 리스트
     */
    public ArrayList<Integer> makeNonDuplicateRandomNumber() {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_SIZE) {
            int random = makeRandomNumber();
            addNonDuplicateNumber(numbers, random);
        }
        return numbers;
    }

}
