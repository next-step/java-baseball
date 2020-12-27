import java.util.Random;

public class BaseballGame {
    private final String randomNumber;

    public BaseballGame(){
        randomNumber = generateRandomNumber();
    }

    public void start(){
        // TODO: 2020/12/27  
    }

    private String generateRandomNumber(){
        Random rand = new Random();
        return String.format(
                "%d%d%d",
                rand.nextInt(10),
                rand.nextInt(10),
                rand.nextInt(10)
        );
    }
}
