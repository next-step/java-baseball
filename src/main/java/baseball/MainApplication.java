package baseball;

/**
 * Java Baseball Game
 * MainApplication
 * 2020.11.15
 * parksangdonews
 */
public class MainApplication {

    public static void main(String[] args) {
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy());
        System.out.println(dealersNumber);
    }

}
