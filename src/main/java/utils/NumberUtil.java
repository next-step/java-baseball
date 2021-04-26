package utils;

import static enumType.SystemNumberType.*;

public class NumberUtil {
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 난수를 생성한다. (각 자릿수 동일한지 아직 확인되지 않은 숫자가 만들어짐)
     */
    public int makeRandomNumber() {
        return (int) ((Math.random() * (MAX.getNumber() - MIN.getNumber() + 1)) + MIN.getNumber());
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : int형 변수를 받아 한자리씩 split 한 후 배열에 넣어 return 한다.
     */
    public Integer[] splitIntegerToArray(int number) {
        
        int       divisor    = 0;                              //제수
        Integer[] eachNumber = new Integer[DIGIT.getNumber()]; // 자릿수 만큼의 int형 동적배열 선언
        
        // 배열에 각 자리의 숫자들을 하나씩 넣는다.
        for (int i = 0; i < DIGIT.getNumber(); i++) {
            divisor       = (int) Math.pow(10, DIGIT.getNumber() - i - 1);
            eachNumber[i] = number / divisor;
            number        = number % (eachNumber[i] * divisor);
        }
        
        return eachNumber;
    }
    
}
