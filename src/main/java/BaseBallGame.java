import java.util.*;


public class BaseBallGame {

    public static final int LIMIT_NUM_CNT = 3;



    public static void main(String args[]) {

        BaseBallGame baseball = new BaseBallGame();

        List<Integer> rtn_result = baseball.createRandomValue();

        System.out.println(rtn_result);

    }

    // 1. 서로 다른 숫자로 이루어진 3자리 난수를 반환한다.
    public List<Integer> createRandomValue() {

        // 1~9까지의 숫자로 한정한다
        int nums[] = {1,2,3,4,5,6,7,8,9};

        List<Integer> ballNumbers = new ArrayList<Integer>();

        for(int i = 0; i<nums.length; i++){
            ballNumbers.add(nums[i]);
        }

        // 1-2. 서로다른 숫자로 이루어져 있다
        Collections.shuffle(ballNumbers);

        List<Integer> result = ballNumbers.subList(0,LIMIT_NUM_CNT);

        return result;


    }


}
