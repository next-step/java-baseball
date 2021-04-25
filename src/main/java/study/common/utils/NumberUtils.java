package study.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static study.common.Constants.BASEBALL_NUMBER_LEN;
import static study.common.Constants.MAX_BASEBALL_NUMBER;

/**
 * <p> 숫자 관련 Utils</p>
 *
 */
public class NumberUtils {

    private static final Random random = new Random();

    /**
     * <p> 범위 안에서 랜덤 함수 반환 메서드 </p>
     *
     * @return the random integer
     */
    public static Integer nextInt() {
        int[] randomNumbers = new int[BASEBALL_NUMBER_LEN];
        boolean[] checked = new boolean[MAX_BASEBALL_NUMBER + 1];
        checked[0] = true;

        int count = 0;
        while (count < BASEBALL_NUMBER_LEN) {
            int number = random.nextInt(MAX_BASEBALL_NUMBER);
            if (checked[number]) {
                continue;
            }

            randomNumbers[count++] = number;
            checked[number] = true;
        }

        return changeListToInt(randomNumbers);
    }

    /**
     * <p> 입력 받은 int 형 리스트를 Integer 으로 변환해서 반환하는 메서드 </p>
     *
     * @param arr
     * @return Integer
     */
    public static Integer changeListToInt(int[] arr) {
        int ans = 0;
        int len = 100;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i] * len;
            len = len / 10;
        }
        return ans;
    }


    /**
     * <p> 입력 받은 숫자를 List<Integer> 으로 변환해서 반환하는 메서드 </p>
     *
     * @param calNumber
     * @return the random List<Integer>
     */
    public static List<Integer> convertNumberToList(int calNumber) {

        int idx = BASEBALL_NUMBER_LEN;
        int multiple = 100;

        List<Integer> numbers = new ArrayList<>();

        while (idx > 0) {
            int tmpNumber = calNumber / multiple;
            numbers.add(tmpNumber);
            calNumber = calNumber - (tmpNumber * multiple);
            multiple = multiple / 10;
            idx--;
        }
        return numbers;

    }

    /**
     * <p> 구성 숫자 중복 확인 메서드 </p>
     *
     * @param num
     */
    public static void checkDuplicateNumber(int num) {

        List<Integer> compositionNumber = convertNumberToList(num);
        boolean[] checkNumbers = new boolean[MAX_BASEBALL_NUMBER + 1];

        for (int i = 0; i < compositionNumber.size(); i++) {
            int tmpNumber = compositionNumber.get(i);
            if (checkNumbers[tmpNumber]) {
                throw new IllegalArgumentException();
            }
            checkNumbers[tmpNumber] = true;
        }

    }

}
