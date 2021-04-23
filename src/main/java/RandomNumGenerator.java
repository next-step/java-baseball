import java.util.Random;

public class RandomNumGenerator {
    private int maxLen;
    public RandomNumGenerator(){
        this(BaseballGame.DEFAULT_LEN);
    }
    public RandomNumGenerator(int maxLen){
        this.maxLen = maxLen;
    }

    public String generateRandomNum(){
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<maxLen; i++)
            builder.append(random.nextInt(9) + 1);
        return builder.toString();
    }
}
