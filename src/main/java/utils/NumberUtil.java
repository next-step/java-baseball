package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static enumType.SystemNumberType.*;

public class NumberUtil {
    
    
    public int makeRandomNumber() {
        return (int) ((Math.random() * (MAX.getNumber() - MIN.getNumber() + 1)) + MIN.getNumber());
    }
    
    
    public Integer[] splitIntegerToArray(int number) {
        List<Integer> list = new ArrayList<>();
        
        while(number != 0) {
            list.add(number % 10);
            number /= 10;
        }
        Collections.reverse(list);
        
        Integer[] array = list.toArray(new Integer[list.size()]);
        
        return array;
    }
    
    
}
