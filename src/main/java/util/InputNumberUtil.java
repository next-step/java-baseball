package util;

import java.util.ArrayList;
import java.util.List;

public class InputNumberUtil {
   
    public static boolean checkInputNumber(String numberString) {
        if(!numberString.matches("^[1-9]+$")){
            return false;
        }
        return true;
    }

    public static List<Integer> toIntegerList(String numberString) {
        List<Integer> answer = new ArrayList<>(3);

        for(int i=0; i < numberString.length(); i++) {
            answer.add(Integer.parseInt(numberString.substring(i, i+1)));
        }
        System.out.println(answer);
        
        return answer;
    }
}
