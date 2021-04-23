package nextstep.baseball.di;

import nextstep.baseball.service.BaseballGame;
import nextstep.baseball.service.BaseballGameService;
import nextstep.baseball.service.BaseballGameServiceImpl;

public class Injection {
    public static BaseballGameService provideBaseballGameService(){
        return new BaseballGameServiceImpl();
    }

    public static BaseballGame provideBaseballGame(){
        return new BaseballGame(provideBaseballGameService());
    }
}
