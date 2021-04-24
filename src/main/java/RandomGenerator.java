import java.util.Random;

public class RandomGenerator {

    private int maxLen;

    public RandomGenerator(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public RandomGenerator(int maxLen){
        this.maxLen = maxLen;
    }

    public void isAvailableUnique(StringBuilder builder, String appendStr) {
        if(!builder.toString().contains(appendStr))
            builder.append(appendStr);
    }
    public String generateBalls() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        while(builder.length() != BaseballGame.DEFAULT_LEN) {
            int randomNum = random.nextInt(9) + 1;
            isAvailableUnique(builder, randomNum + "");
        }
        return builder.toString();
    }
}
