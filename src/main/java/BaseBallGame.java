import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BaseBallGame {

    List<String> targetNumberList = new ArrayList<>();
    ArrayList<Integer> numberPool;
    CheckResultModel checkResultModel = new CheckResultModel();
    int isEnd = 0;

    // TODO : 1-9 numberPool 생성
    public void createNumberPool(){
        numberPool = new ArrayList<>();
        for(int i=1; i<10; i++){
            numberPool.add(i);
        }
    }



}
