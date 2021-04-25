package basball.application;

import java.util.List;

public class Baseball {

    List<Integer> questionSet;

    private static final NumberFactory factory = new NumberFactory();
    private static final Validator validator = new Validator();

    public void startGame() {

        questionSet = factory.createRandomNumber();
        //System.out.println("맞춰야하는 숫자" + questionSet.toString());
        play();
    }

    private void play() {

        List<Integer> playerSet = factory.createUserNumber(validator.input());
        System.out.println("입력 숫자" + playerSet.toString());
    }
}
