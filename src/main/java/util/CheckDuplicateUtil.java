package util;

import java.util.HashSet;
import java.util.List;

public class CheckDuplicateUtil {

    public static boolean checkDuplicateNumber(List<Integer> baseBallNumber){

        HashSet<Integer> baseBallNumberSet = new HashSet<>();
        for(int i = 0; i < baseBallNumber.size(); i++){
            baseBallNumberSet.add(baseBallNumber.get(i));
        }

        if(baseBallNumberSet.size() < 3){
            return false;
        }
        return true;
    }

}
