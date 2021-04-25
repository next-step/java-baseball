package baseball.view;

import baseball.application.BaseballService;
import baseball.domain.BaseballNumbers;

import java.util.Scanner;

public class BaseballView {
    private final BaseballService baseballService;
    private final Scanner sc;

    public BaseballView() {
        baseballService = new BaseballService();
        sc = new Scanner(System.in);
    }

    public void start() {
        boolean isContinued = true;
        while (isContinued){
            BaseballNumbers answer = this.baseballService.generateAnswer();
            isContinued = false;
        }
    }


}
