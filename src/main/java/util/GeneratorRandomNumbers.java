package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratorRandomNumbers {

    public static final int LIMIT_NUM_CNT = 3;

    // 1. 서로 다른 숫자로 이루어진 3자리 난수를 반환한다.
    public static int[] generatorNumbers(){

        // 1~9까지의 숫자로 한정한다
        int nums[] = {1,2,3,4,5,6,7,8,9};

        List<Integer> ballNumbers = new ArrayList<Integer>();

        for(int i = 0; i<nums.length; i++){
            ballNumbers.add(nums[i]);
        }

        // 1-2. 서로다른 숫자로 이루어져 있다
        Collections.shuffle(ballNumbers);

        // 1-3. 자리수는 3자리로 한정한다
        List<Integer> result = ballNumbers.subList(0,LIMIT_NUM_CNT);

        int[] rtn_int_array = new int[result.size()];
        for (int i = 0; i < rtn_int_array.length; i++){

            rtn_int_array[i] = result.get(i).intValue();
        }


        return rtn_int_array;


    }




}
