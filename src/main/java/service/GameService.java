package service;

import model.Score;
import support.ConvertUtils;

import java.util.Random;
import java.util.Scanner;

public class GameService {
    private RuleService ruleService = new RuleService();

    public void initGame(int len) {
        Score score = new Score();
        int[] botNumber = generateBotNumber(len);

        while (score.getStrike() != len) {
            score = ruleService.checkScore(botNumber, getUserNumber(len));
            System.out.println(score.toString());
        }
        System.out.println(len +"자리 숫자를 모두 맞히셨습니다!");
    }

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

    private int[] getUserNumber(int len) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = scan.next();

            if(isValidInput(input,len)){
                return ConvertUtils.convertIntToArray(Integer.parseInt(input));
            }
            System.out.println(len + "자리 숫자만 입력 가능합니다.");
        }
    }

    boolean isValidInput(String input, int len){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            return false;
        }
        return input.length() == len;
    }
}
