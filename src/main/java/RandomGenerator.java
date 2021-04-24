public class RandomGenerator {

    private int maxLen;

    public RandomGenerator(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public RandomGenerator(int maxLen){
        this.maxLen = maxLen;
    }

    public String generateBalls() {
        return "123";
    }
}
