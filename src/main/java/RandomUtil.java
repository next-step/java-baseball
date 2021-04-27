import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    private Random random=new Random();

    public int getRandom(int min,int max){
        return random.nextInt(max-min+1)+min;
    }

    public boolean IsDuplicatedNumList(List<Integer> numList){
        List<Integer> temp=new ArrayList<>(new HashSet<>(numList));
        return temp.size()!=numList.size();
    }

}
