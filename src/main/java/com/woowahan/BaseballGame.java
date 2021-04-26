package com.woowahan;

import com.woowahan.vo.ResultVo;

import java.util.*;

import static com.woowahan.constants.MessageConstants.*;
import static com.woowahan.enums.EndType.END;
import static com.woowahan.enums.EndType.RETRY;
import static com.woowahan.enums.PlayType.*;

public class BaseballGame {

    static Scanner scanner;
    static Set<Integer> computerSet;

    public static void main(String[] args) {
        System.out.println(GREETING_MESSAGE);
        scanner = new Scanner(System.in);
        boolean isContinue = true;
        computerSet = getComputerSet();
        while (isContinue) {
            isContinue = playGame();
        }
        System.out.println(END_MESSAGE);
        scanner.close();
    }

    private static boolean playGame() {
        return false;
    }

    private static LinkedHashSet<Integer> getComputerSet() {
        LinkedHashSet<Integer> computerSet = new LinkedHashSet<>();
        Random random = new Random();
        while (computerSet.size() < 3) {
            computerSet.add(random.nextInt(10));
        }
        return computerSet;
    }

}
