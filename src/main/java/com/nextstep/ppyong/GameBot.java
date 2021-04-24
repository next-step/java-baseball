package com.nextstep.ppyong;

import com.nextstep.ppyong.service.CheckMatchNumberService;
import com.nextstep.ppyong.utils.RandomNumberUtil;
import com.nextstep.ppyong.validator.Validator;
import java.util.List;
import java.util.Scanner;

public class GameBot {
    private static final int MAX_NUMBER_SIZE = 3;
    private static final String REPLAY_NUMBER = "1";
    private static final String STOP_NUMBER = "2";

    private Scanner scanner;
    private RandomNumberUtil randomNumberUtil;
    private CheckMatchNumberService checkMatchNumberService;
    private List<Validator> validatorList;

    public GameBot(List<Validator> validatorList) {
        scanner = new Scanner(System.in);
        randomNumberUtil = new RandomNumberUtil(MAX_NUMBER_SIZE);
        this.validatorList = validatorList;
    }

    public void run() {
        boolean continued = true;
        while(continued) {
            checkMatchNumberService = new CheckMatchNumberService(randomNumberUtil.createRandomNumber());
            inputNumber();
            continued = !isQuit();
        }
    }

    private boolean isQuit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return !input.equals(REPLAY_NUMBER);
    }

    private void inputNumber() {
        boolean continued = true;
        while (continued) {
            System.out.print("숫자를 입력해주세요: ");
            String input = scanner.nextLine();

            continued = !checkMatchNumber(input);
        }
    }

    private boolean checkMatchNumber(String input) {
        try{
            valid(input);
        }catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        if(input.length() != MAX_NUMBER_SIZE) {
            System.out.println("유효한 숫자가 아닙니다. 1-9의 '3자리' 정수를 입력해주세요.");
            return false;
        }
        return true;
    }

    private void valid(String input) {
        for(Validator validator : validatorList) {
            validator.valid(input);
        }
        checkMatchNumberService.valid(input);
    }
}

