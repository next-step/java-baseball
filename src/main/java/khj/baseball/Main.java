package khj.baseball;

import khj.baseball.flow.Flow;

public class Main {
    public static void main(String[] args) {
        Flow flow = new Flow(new BaseBallGame());

        flow.start();
    }
}
