package baseball;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import static baseball.GameResult.*;

public class BaseBall {

    Scanner scanner = new Scanner(System.in);

    public void playGame() {
        String defenceNumber = getRandomValue();
        boolean isWinOrLose;

        do {
            String attackNumber = inputAttackNumber();
            HashMap<GameResult, Integer> gameResult = run(attackNumber, defenceNumber);
            isWinOrLose = judgeGameResult(gameResult);
        } while (!isWinOrLose);
    }

    public String getRandomValue() {
        String randomValue;
        boolean validateValue;

        do {
            randomValue = String.valueOf((int) (Math.random() * 999 + 100));
            validateValue = !validateNumber(randomValue);
        } while (validateValue);

        return randomValue;
    }

    public String inputAttackNumber() {
        String inputNumber = null;
        boolean isValid = true;

        while (isValid) {
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = scanner.next();
            isValid = !validateNumber(inputNumber);
            printValidate(isValid);
        }

        return inputNumber;
    }

    public boolean validateNumber(String validateToData) {
        boolean isValidateNumber = true;
        int i = 0, size = validateToData.length();

        if (!Pattern.matches("^[1-9]{3}", validateToData)) {
            return false;
        }

        while (isValidateNumber && i < size - 1) {
            isValidateNumber = validateInLoop(i++, validateToData);
        }

        return isValidateNumber;
    }

    private boolean validateInLoop(int i, String validateToData) {
        boolean checkDuplicateData = true;
        int j = i + 1, size = validateToData.length();

        while (checkDuplicateData && j < size) {
            checkDuplicateData = validateToData.charAt(i) != validateToData.charAt(j++);
        }

        return checkDuplicateData;
    }

    private void printValidate(boolean validate) {
        if (validate) {
            System.out.println("올바른 입력값이 아닙니다.");
        }
    }

    public HashMap<GameResult, Integer> run(String attack, String defence) {
        HashMap<GameResult, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < attack.length(); i++) {
            GameResult key = getGameResult(i, attack, defence);
            resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
        }

        printGameResult(resultMap);
        return resultMap;
    }

    private GameResult getGameResult(int i, String attack, String defence) {
        if (attack.charAt(i) == defence.charAt(i)) {
            return STRIKE;
        }

        if (defence.contains("" + attack.charAt(i))) {
            return BALL;
        }

        return NOTHING;
    }

    private void printGameResult(HashMap<GameResult, Integer> resultMap) {
        StringBuilder sb = new StringBuilder();
        if (resultMap.containsKey(STRIKE)) {
            sb.append(resultMap.get(STRIKE));
            sb.append(" 스트라이크 ");
        }
        if (resultMap.containsKey(BALL)) {
            sb.append(resultMap.get(BALL));
            sb.append(" 볼");
        }

        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }

    public boolean judgeGameResult(HashMap<GameResult, Integer> resultGameMap) {
        boolean gameResult = false;
        if (resultGameMap.containsKey(STRIKE) && resultGameMap.get(STRIKE) == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameResult = true;
        }

        return gameResult;
    }

    public boolean requestContinue() {
        boolean isContinue = true;
        String processValue = null;
        while (isContinue) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            processValue = scanner.next();
            isContinue = validateProcessValue(processValue);
        }

        return "1".equals(processValue);
    }

    public boolean validateProcessValue(String processValue) {
        try {
            isFinish(processValue);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private void isFinish(String processValue) {
        switch (processValue) {
            case "1":
            case "2":
                break;
            default:
                throw new IllegalArgumentException("올바른 입력값이 아닙니다. 1 혹은 2 를 입력해주세요.");
        }
    }

}
