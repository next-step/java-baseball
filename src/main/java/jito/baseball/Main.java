package jito.baseball;

import jito.baseball.domain.BaseballStadium;

public class Main {
    public static void main(String[] args) {
        BaseballStadium baseballStadium = new BaseballStadium();
        baseballStadium.init();
        baseballStadium.gameStart();
    }
}
