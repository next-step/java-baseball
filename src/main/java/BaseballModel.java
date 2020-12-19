import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballModel {

    private String ballNumber;
    private static final int LENGTH_OF_BALL_NUMBER = 3;

    public void initializeBallNumber() {
        Set<Integer> integerSet = new HashSet<>();
        Random random = new Random();

        while(integerSet.size() < LENGTH_OF_BALL_NUMBER){
            integerSet.add(random.nextInt(10));
        }

        StringBuilder sb = new StringBuilder();
        for(Integer integer: integerSet){
            sb.append(integer);
        }
        ballNumber = sb.toString();
    }

    public String getBallNumber(){
        return ballNumber;
    }
}
