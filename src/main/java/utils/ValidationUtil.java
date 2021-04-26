package utils;

import static enumType.SystemNumberType.MAX;
import static enumType.SystemNumberType.MIN;
import static enumType.SystemNumberType.DIGIT;

import static enumType.ErrorType.ERROR_1010_INPUT_LENGTH_ERROR;
import static enumType.ErrorType.ERROR_2000_NUMBER_LENGTH_ERROR;
import static enumType.ErrorType.ERROR_2010_DIGIT_LENGTH_ERROR;

public class ValidationUtil {
    
    NumberUtil numberUtil = new NumberUtil();
    
    
    public void systemStartingValidation() {
        if (DIGIT.getNumber() != String.valueOf(MAX.getNumber()).length()) {
            throw new IllegalArgumentException(ERROR_2010_DIGIT_LENGTH_ERROR.getErrorMessage());
        }
        if (String.valueOf(MAX.getNumber()).length() != String.valueOf(MIN.getNumber()).length()) {
            throw new IllegalArgumentException(ERROR_2000_NUMBER_LENGTH_ERROR.getErrorMessage());
        }
    }
    
    
    public boolean digitValidation(int number, int digit) {
        boolean   isTrue = true;
        Integer[] eachNumber;
        
        eachNumber = numberUtil.splitIntegerToArray(number);
        
        for (int i = 0; i < digit; i++) {
            isTrue = eachNumberCompare(i, eachNumber, digit, isTrue);
        }
        
        return isTrue;
    }
    
    
    private boolean eachNumberCompare(int sequence, Integer[] eachNumber, int digit, boolean isTrue) {
        int sameNumberCnt = 0;
        
        // 한 번이라도 같은 수가 발견된 적이 있으면 바로 false로 판단하여 바로 return한다.
        if (!isTrue) {
            return false;
        }
        for (int i = sequence + 1; i < digit; i++) {
            sameNumberCnt += isSameNumber(eachNumber[sequence], eachNumber[i]);
        }
        if (sameNumberCnt > 0) {
            return false;
        }
        return true;
    }
    
    
    private int isSameNumber(int number, int compareNumber) {
        if (number == compareNumber) {
            return 1;
        }
        return 0;
    }
    
    
    public void playerInputValidation(int inputNumber) {
        if (DIGIT.getNumber() != String.valueOf(inputNumber).length()) {
            throw new IllegalArgumentException(ERROR_1010_INPUT_LENGTH_ERROR.getErrorMessage());
        }
    }
    
}