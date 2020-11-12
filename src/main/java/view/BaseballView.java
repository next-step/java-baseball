package view;

import application.BaseballService;
import domain.BaseballNumbers;

import java.util.Scanner;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description :
 **/
public class BaseballView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUIRE_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    private static BaseballService baseballService;

    public static void start() {
        baseballService = new BaseballService();
        BaseballNumbers answer = baseballService.generateAnswer();
        String playerBaseballNumber = requirePlayerBaseballNumber();
        BaseballNumbers baseballNumbers = new BaseballNumbers(playerBaseballNumber);
    }

    private static String requirePlayerBaseballNumber() {
        System.out.print(REQUIRE_NUMBER_MESSAGE);
        return scanner.next();
    }
}
