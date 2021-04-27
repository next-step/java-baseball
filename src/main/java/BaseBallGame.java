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

    // TODO : pool에서 뽑고 지우기 반복 방식
    public String createTargetNumber(int range){
        Random random = new Random();
        int randomIndex = random.nextInt(range);
        int targetNumber = numberPool.get(randomIndex);
        numberPool.remove(randomIndex);
        return Integer.toString(targetNumber);
    }



}
