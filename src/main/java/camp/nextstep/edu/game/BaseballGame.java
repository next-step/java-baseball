package camp.nextstep.edu.game;

public class BaseballGame implements Game {

    @Override
    public void start() {
        BaseballNumber baseballNumber = BaseballNumber.generateBaseballNumber();
        System.out.println("baseballNumber = " + baseballNumber.getNumberList());
    }
}
