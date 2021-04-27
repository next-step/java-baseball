package generator;

import java.util.HashSet;
import java.util.Set;

public class NumGenerator {
    private final static int FIGURE = 3;
    private final static int MIN = 1;
    private final static int MAX = 9;

    /*
        서로 다른 숫자로 이루어진 3자리 숫자 반환
     */
    public static String numGenerator(){
        String numStr = "";
        int[] num = new int[FIGURE];
        Set<Integer> chkNum = new HashSet<Integer>();
        num[0] = (int)(Math.random()*(MAX - MIN + 1)) + 1;
        numStr = numStr.concat(Integer.toString(num[0]));
        chkNum.add(num[0]);
        for(int i=1 ; i<FIGURE ; i++){
            num[i] = newNum(num, chkNum);
            numStr = numStr.concat(Integer.toString(num[i]));
        }
        return numStr;
    }

    /*
        중복 체크 후 임의의 한자리 숫자 반환
     */
    private static int newNum(int[] num, Set<Integer> chkNum){
        int now = 0;
        do{
            now = (int)(Math.random()*(MAX - MIN + 1)) + 1;
        }while(chkNum.contains(now));
        chkNum.add(now);
        return now;
    }
}
