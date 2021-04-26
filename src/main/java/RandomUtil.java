import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    private Random random=new Random();

    public int getRandom(int min,int max){
        return random.nextInt(min+max)+min;
    }

}
