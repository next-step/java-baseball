package utils;

import static enumType.SystemNumberType.*;

public class NumberUtil {
    
    
    public int makeRandomNumber() {
        return (int) ((Math.random() * (MAX.getNumber() - MIN.getNumber() + 1)) + MIN.getNumber());
    }
    
    
    public Integer[] splitIntegerToArray(int number) {
        int divisor = 1;
        int digit   = DIGIT.getNumber();
        
        Integer[] eachNumber = new Integer[digit];
        
        for (int i = 0; i < digit; i++) {
            divisor       = (int) Math.pow(10, digit - i - 1);
            eachNumber[i] = number / divisor;
            number        = number % (eachNumber[i] * divisor);
        }
        
        return eachNumber;
    }
    
    
}
