import java.util.Random;

public class RandomGenerator {

    private int maxLen;

    public RandomGenerator(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public RandomGenerator(int maxLen){
        this.maxLen = maxLen;
    }

    public String generateBalls() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<maxLen; i++)
            builder.append(random.nextInt(9) + 1);
        return builder.toString();
    }
}
