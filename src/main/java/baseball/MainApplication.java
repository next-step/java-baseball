package baseball;

public class MainApplication {

    public static void main(String[] args) {
        BallNumberRandom computerNumber = new BallNumberRandom();
        do {
            String result = InputNumber.inputBallNumbers();
            System.out.println(result);

        } while (InputNumber.restart());

    }
}
