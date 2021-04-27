package com.woowahan.service;

import com.woowahan.BaseballGame;
import com.woowahan.vo.Result;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;

import static com.woowahan.constants.MessageConstants.*;
import static com.woowahan.enums.EndType.END;
import static com.woowahan.enums.EndType.RETRY;
import static com.woowahan.enums.PlayType.*;

public class BaseballGameService {

    private static Scanner scanner;

    public static void init(){
        scanner = new Scanner(System.in);
    }

    public static void destory(){
        scanner.close();
    }

    public static boolean playGame() {
        Result result = calculateScore(getPlayerSet());
        int strike = result.getStrike();
        if (checkAllStrike(strike)) {
            return isExitGame();
        }
        printResult(result.getBall(), strike);
        return false;
    }

    public static LinkedHashSet<Integer> getComputerSet() {
        LinkedHashSet<Integer> computerSet = new LinkedHashSet<>();
        Random random = new Random();
        while (computerSet.size() < 3) {
            computerSet.add(random.nextInt(10));
        }
        return computerSet;
    }

    public static void printResult(int ball, int strike) {
        if (ball + strike == 0) {
            System.out.println(NOTHING.getName());
            return;
        }
        String result = ball > 0 ? String.format("%d %s ", ball, BALL.getName()) : "";
        result += strike > 0 ? String.format("%d %s ", strike, STRIKE.getName()) : "";
        System.out.println(result);
    }

    public static boolean checkAllStrike(int strike) {
        if (strike != 3) {
            return false;
        }
        System.out.println(GAME_END_MESSAGE);
        return true;
    }

    public static boolean isExitGame(){
        System.out.println(NOTICE_MESSAGE);
        try {
            if (isEnd()) return true;
            BaseballGame.computerSet = getComputerSet();
            return false;
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
            return isExitGame();
        }
    }

    public static boolean isEnd() throws InputMismatchException, NumberFormatException {
        String input = scanner.nextLine();
        System.out.println(input);
        int value = Integer.parseInt(input);
        if (!RETRY.isEqualTo(value) && !END.isEqualTo(value)) {
            throw new InputMismatchException();
        }
        return END.isEqualTo(value);
    }

    public static Result calculateScore(Set<Integer> playerSet) {
        Iterator<Integer> computerIterator = BaseballGame.computerSet.iterator();
        Iterator<Integer> playerIterator = playerSet.iterator();
        Result result = new Result();
        while (computerIterator.hasNext()) {
            getScore(computerIterator.next(), playerIterator.next(), result);
        }
        return result;
    }

    public static void getScore(int computerValue, int playerValue, Result result) {
        if (computerValue == playerValue) {
            result.setStrike(result.getStrike() + 1);
            return;
        }
        if (BaseballGame.computerSet.contains(playerValue)) {
            result.setBall(result.getBall() + 1);
        }
    }

    public static Set<Integer> getPlayerSet() throws NumberFormatException {
        System.out.println(INPUT_REQUIRE_MESSAGE);
        Set<Integer> playerSet = new LinkedHashSet<>();
        String[] splitValue = scanner.nextLine().split("");
        if (validateInput(playerSet, splitValue)) {
            return getPlayerSetRetry();
        }
        if (playerSet.size() != 3) {
            return getPlayerSetRetry();
        }
        return playerSet;
    }

    public static boolean validateInput(Set<Integer> playerSet, String[] splitValue) {
        try {
            for (String num : splitValue) {
                playerSet.add(Integer.parseInt(num));
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static Set<Integer> getPlayerSetRetry() {
        System.out.println(ERROR_MESSAGE);
        return getPlayerSet();
    }

}
