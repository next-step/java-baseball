package util;

import java.util.List;

public class Validator {

    public static final int LIMIT_NUM_CNT = 3;

   public boolean overNumber(List<Integer> input){
       if(input.size() > LIMIT_NUM_CNT){
           throw new IllegalArgumentException("입력 가능한 숫자를 초과하였습니다.");
       }


       return false;



   }

}
