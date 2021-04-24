import java.util.Random;

public class BaseBallGame {

    private String generateThreeNumbers() {
        Random random = new Random();
        String num1 = String.valueOf(random.nextInt(9) + 1);
        String num2 = String.valueOf(random.nextInt(9) + 1);
        String num3 = String.valueOf(random.nextInt(9) + 1);

        return num1+num2+num3;
    }

    private void start() {
        System.out.println("야구 게임 시작");
        String threeNumbers = generateThreeNumbers();
    }

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();
    }
}
