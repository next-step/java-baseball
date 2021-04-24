package utils;

import static enumType.SystemNumberType.MIN;
import static enumType.SystemNumberType.MAX;

public class RandomNumberUtil {
    
    ValidationUtil validationUtil = new ValidationUtil();
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 각 자리의 숫자가 겹치지 않는 난수를 생성한다.
     */
    public int generateRandomNumber() {
        
        Boolean isTrue       = true;
        int     randomNumber = 0;
        
        do {
            // 난수를 생성한다.
            randomNumber = createRandomNumber();
            
            // 위에서 만든 난수의 각 자릿수 숫자들이 서로 다른지 확인한다. 각각 다른 숫자가 나올때까지 반복.
            isTrue = validationUtil.digitValidation(randomNumber, (int) (Math.log10(randomNumber) + 1));
        } while (!isTrue);
        
        return randomNumber;
        
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 난수를 생성한다. (각 자릿수 동일한지 아직 확인되지 않은 숫자가 만들어짐)
     */
    private int createRandomNumber() {
        return (int) ((Math.random() * (MAX.getNumber() - MIN.getNumber() + 1)) + MIN.getNumber());
    }
    
}
