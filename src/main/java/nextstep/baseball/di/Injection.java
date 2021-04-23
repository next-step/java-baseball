package nextstep.baseball.di;

import nextstep.baseball.service.*;

public class Injection {
    public static BaseballGameNumberService provideBaseballNumberService(){
        return new BaseballGameNumberServiceImpl();
    }

    public static BaseballGameCheckService provideBaseballGameCheckService(){
        return new BaseballGameCheckServiceImpl();
    }

    public static BaseballGame provideBaseballGame(){
        return new BaseballGame(provideBaseballNumberService(), provideBaseballGameCheckService());
    }
}
