import java.util.*;

public class MakeNumber {

    /**
     * 임의 숫자 생성
     * @param digit
     * @return
     */
    public List<Integer> makeRandomNumberOld(int digit) {
        Set<Integer> numberSet = new LinkedHashSet<>();

        while (numberSet.size() < digit) {
            Double d = Math.random() * 9 + 1;
            numberSet.add(d.intValue());
        }
        return new ArrayList(numberSet);
    }

    /**
     * 임의 숫자 생성
     * @param digit
     * @return
     */
    public String makeRandomNumber(int digit) {
        String numberStr = "";
        Set<Integer> numberSet = new LinkedHashSet<>();

        while (numberSet.size() < digit) {
            Double d = Math.random() * 9 + 1;
            numberSet.add(d.intValue());
        }

        Iterator<Integer> numberIt = numberSet.iterator();

        while (numberIt.hasNext()) {
            numberStr += numberIt.next();
        }
        return numberStr;
    }

    /**
     * 입력값에서 숫자만 추출
     * @param inputStr
     * @return
     */
    public String extractNumber(String inputStr) {
        return inputStr.replaceAll("[^0-9]", "");
    }
}