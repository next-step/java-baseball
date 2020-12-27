import java.util.Random;

public class BaseballGame {
    private final String randomNumber;

    public BaseballGame(){
        randomNumber = generateRandomNumber();
    }

    public void start(){
        boolean isNotMatched = true;
        while(isNotMatched){
            System.out.print("숫자를 입력해주세 : ");
            checkInput(InputReader.getNumberInput());
        }
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

    private boolean checkInput(int input){
        return true;
    }
}
