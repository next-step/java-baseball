import java.util.*;

public class ComputerNum {
    private static final Integer START = 1;
    private static final Integer END = 10;
    private static final Integer PICK = 3;

    public String getComputerNum(){
        StringBuilder computerNum = new StringBuilder();
        List<Integer> defaultNum = setDefaultNum();

        for(int p = 0; p < PICK; p++) {
            Integer randomNum = pickRandomNum(defaultNum);
            computerNum.append(defaultNum.get(randomNum).toString());
            defaultNum = outNumInList(defaultNum, randomNum);
        }
        return computerNum.toString();
    }

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
