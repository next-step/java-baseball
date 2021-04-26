package utils;

import static enumType.SystemNumberType.MAX;
import static enumType.SystemNumberType.MIN;
import static enumType.SystemNumberType.DIGIT;

import static enumType.ErrorType.ERROR_1010_INPUT_LENGTH_ERROR;
import static enumType.ErrorType.ERROR_2000_NUMBER_LENGTH_ERROR;
import static enumType.ErrorType.ERROR_2010_DIGIT_LENGTH_ERROR;

public class ValidationUtil {
    
    NumberUtil numberUtil = new NumberUtil();
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : 게임 시작 전 숫자 설정을 확인한다. 
     */
    public void systemStartingValidation() {
        if (DIGIT.getNumber() != String.valueOf(MAX.getNumber()).length()) {
            throw new IllegalArgumentException(ERROR_2010_DIGIT_LENGTH_ERROR.getErrorMessage());
        }
        if (String.valueOf(MAX.getNumber()).length() != String.valueOf(MIN.getNumber()).length()) {
            throw new IllegalArgumentException(ERROR_2000_NUMBER_LENGTH_ERROR.getErrorMessage());
        }
    }
    
    
    /**
     * @author      : jeeyong.park
     * @date        : 2021.04.25
     * @description : 생성된 난수의 각 자릿수 분해하여 같은 숫자가 존재하는지 비교한다.
     * =================================================================== 
     * DATE          AUTHOR         NOTE 
     * ------------------------------------------------------------------- 
     * 2021.04.25    jeeyong.park   init.
     * 2021.04.26    jeeyong.park   split 하여 배열에 넣는 로직을 공통화하여 NumberUtil로 이관.
     */
    public boolean digitValidation(int number, int digit) {
        
        boolean   isTrue     = true; // 각 자릿수 비교시, 같은 숫자가 존재하면 false
        Integer[] eachNumber;        // 자릿수 만큼의 int형 동적배열 선언
        
        // 한자리씩 배열에 넣는다
        eachNumber = numberUtil.splitIntegerToArray(number);
        
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
    private boolean eachNumberCompare(int sequence, Integer[] eachNumber, int digit, boolean isTrue) {
        
        int sameNumberCnt = 0;
        
        // 한 번이라도 같은 수가 발견된 적이 있으면 바로 false로 판단하여 바로 return한다.
        if (!isTrue) {
            return false;
        }
        
        // 같은 숫자가 있는지 반복문을 통해 판별한다.
        for (int i = sequence + 1; i < digit; i++) {
            sameNumberCnt += isSameNumber(eachNumber[sequence], eachNumber[i]);
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
    private int isSameNumber(int number, int compareNumber) {
        if (number == compareNumber) {
            return 1;
        }
        return 0;
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 사용자 입력값이 3자리인지 유효성을 검사한다. 
     */
    public void playerInputValidation(int inputNumber) {
        if (DIGIT.getNumber() != String.valueOf(inputNumber).length()) {
            throw new IllegalArgumentException(ERROR_1010_INPUT_LENGTH_ERROR.getErrorMessage());
        }
    }
    
}