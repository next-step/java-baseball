import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    /**
     * 1~9 사이의 랜덤 숫자를 얻는 메소드
     */
    public static int makeRandomSingleDigit() {
        int randomNumber = (int) (Math.random() * 10);
        return randomNumber != 0 ? randomNumber : 1;
    }

    /**
     * 세 자리수를 생성하는 메소드. 각 자리수는 같은 숫자가 존재하지 않음
     */
    public static int makeRandomThreeDigit() {
        StringBuilder result = new StringBuilder();
        while (true) {
            if (result.length() == 3)
                return Integer.parseInt(result.toString());

            int randomSingleDigit = makeRandomSingleDigit();

            if (result.toString().contains(randomSingleDigit + "") != true)
                result.append(randomSingleDigit);
        }
    }

    /**
     * 자리수를 한 글자씩 분리하여 배열로 리턴하는 메소드
     */
    public static List<Integer> toSingleDigitArray(int number) {
        List<Integer> result = new ArrayList<>();
        while (number != 0) {
            result.add(number % 10);
            number /= 10;
        }
        return result;
    }

    /**
     * 올바른 데이터인지 확인하는 메소드
     * @param number
     * @return
     */
    public static boolean checkRightData(int number) {
        List<Integer> singleDigits = toSingleDigitArray(number);
        return checkRightData(singleDigits);
    }

    /**
     * 올바른 데이터인지 확인하는 메소드
     * @param singleDigits
     * @return
     */
    public static boolean checkRightData(List<Integer> singleDigits) {
        // 길이가 3인지 확인
        if (singleDigits.size() != 3) return false;
        // 전부 1~9 사이의 숫자인지 확인
        for (int digit : singleDigits)
            if (0 >= digit || digit >= 10) return false;
        // 같은 수가 존재하는지 확인
        for (int i = 0; i < singleDigits.size(); i++)
            for (int k = i + 1; k < singleDigits.size(); k++)
                if (singleDigits.get(i).equals(singleDigits.get(k))) return false;
        return true;
    }
}
