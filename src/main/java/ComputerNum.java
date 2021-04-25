import java.util.ArrayList;
import java.util.List;

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
}
