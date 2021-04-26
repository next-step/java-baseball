import java.util.*;

public class ComputerNum {
    private static final Integer START = 1;
    private static final Integer END = 10;


    public List<Integer> setDefaultNum(){
        List<Integer> defaultNum = new ArrayList<>();

        for(Integer i = START; i < END; i++){
            defaultNum.add(i);
        }
        return defaultNum;
    }

    public static Integer pickRandomNum(List<Integer> defaultNum){
        double random = Math.random();
        return (int)(random * defaultNum.size());
    }

    public static List<Integer> outNumInList(List<Integer> defaultNum, int randomNum) {
        defaultNum.remove(randomNum);
        return defaultNum;
    }
}
