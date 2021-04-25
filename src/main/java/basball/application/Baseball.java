package basball.application;

import java.util.List;

public class Baseball {

    List<Integer> questionSet;

    private static final NumberFactory factory = new NumberFactory();
    public void startGame() {
        questionSet = factory.createRandomNumber();
    }

}
