package utils;


public class ValidationUtil {

    /**
     * @author      : jeeyong.park
     * @date        : 2021.04.25
     * @description : 생성된 난수의 각 자릿수 분해하여 같은 숫자가 존재하는지 비교한다.
     */
    protected boolean digitValidation(int number, int digit) {
        
        boolean isTrue     = true;           // 각 자릿수 비교시, 같은 숫자가 존재하면 false
        int     divisor    = 0;              // 제수
        int[]   eachNumber = new int[digit]; // 자릿수 만큼의 int형 동적배열 선언
        
        // 배열에 각 자리의 숫자들을 하나씩 넣는다.
        for (int i = 0; i < digit; i++) {
            divisor       = (int) Math.pow(10, digit - i - 1);
            eachNumber[i] = number / divisor;
            number        = number % (eachNumber[i] * divisor);
        }
        
        // 각 자릿수를 비교하여 같은 숫자가 있는지 없는지 return한다.
        for (int i = 0; i < digit; i++) {
            isTrue = eachNumberCompare(i, eachNumber, digit, isTrue);
        }
        
        return isTrue;
    }


    /**
     * @author      : jeeyong.park
     * @date        : 2021.04.25
     * @description : 같은 수가 발견된 적이 있는지 확인한다.
     */
    private boolean eachNumberCompare(int sequence, int[] eachNumber, int digit, boolean isTrue) {
        
        int sameNumberCnt = 0;
        
        // 한 번이라도 같은 수가 발견된 적이 있으면 바로 false로 판단하여 바로 return한다.
        if (!isTrue) {
            return false;
        }
        
        // 같은 숫자가 있는지 반복문을 통해 판별한다.
        for (int i = sequence + 1; i < digit; i++) {
            sameNumberCnt = isSameNumber(eachNumber[sequence], eachNumber[i], sameNumberCnt);
        }
        
        // 같은 수가 1개이상 발견되면 false로 return한다.
        if (sameNumberCnt > 0) {
            return false;
        }
        
        return true;
    }


    /**
     * @author      : jeeyong.park
     * @date        : 2021.04.25
     * @description : 같은 숫자인지 판별한다.
     */
    private int isSameNumber(int number, int compareNumber, int sameNumberCnt) {
        
        if (number == compareNumber) {
            sameNumberCnt++;
        }
        
        return sameNumberCnt;
    }

}