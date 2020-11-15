package baseball;

/**
 * Java Baseball Game
 * MainApplication
 * 2020.11.15
 * parksangdonews
 */
public class MainApplication {

    public static void main(String[] args) {
        // dealer
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy());
        // player
        BallNumber playerInputNumber = new BallNumber(new BallNumbersPlayerInputStrategy());

        System.out.println(dealersNumber);
        System.out.println(playerInputNumber);
    }

}
