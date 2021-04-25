package service;

import java.util.Random;

public class GameService {
    private RuleService ruleService = new RuleService();

    int[] generateBotNumber(int len) {
        Random rand = new Random();
        int[] botNumber = new int[len];

        for (int i = 0; i < len; i++) {
            int newNumber;
            do {
                newNumber = rand.nextInt(9) + 1;
            } while (ruleService.isOverlap(botNumber, newNumber));
            botNumber[i] = newNumber;
        }
        return botNumber;
    }
}
