package baseball;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import static baseball.GameResult.*;

public class BaseBall {

    Scanner scanner = new Scanner(System.in);

    public void playGame() {
        String defenceNumber = getDefenceNumber();
        boolean isWinOrLose = true;

        while (isWinOrLose) {
            String attackNumber = setAttackNumber();
            HashMap<GameResult, Integer> gameResult = run(attackNumber, defenceNumber);
            printGameResult(gameResult);
            isWinOrLose = !confirmResult(gameResult);
        }
    }

    public String getDefenceNumber() {
        String defenceValue = null;
        boolean isValidateValue = true;

        while (isValidateValue) {
            defenceValue = String.valueOf((int) (Math.random() * 999 + 100));
            isValidateValue = !validateNumber(defenceValue);
        }

        return defenceValue;
    }

    public String setAttackNumber() {
        String inputAttackValue = null;
        boolean isValid = true;

        while (isValid) {
            System.out.print("숫자를 입력해주세요 : ");
            inputAttackValue = scanner.next();
            isValid = !validateNumber(inputAttackValue);
            printWrongValue(isValid);
        }

        return inputAttackValue;
    }

    public boolean validateNumber(String valueToCheck) {
        boolean isValidateYN = true;
        int i = 0, size = valueToCheck.length();

        if (!Pattern.matches("^[1-9]{3}", valueToCheck)) {
            return false;
        }

        while (isValidateYN && i < size - 1) {
            isValidateYN = checkDuplicateValue(i++, valueToCheck);
        }

        return isValidateYN;
    }

    private boolean checkDuplicateValue(int i, String valueToCheck) {
        boolean isDuplicate = true;
        int j = i + 1, size = valueToCheck.length();

        while (isDuplicate && j < size) {
            isDuplicate = valueToCheck.charAt(i) != valueToCheck.charAt(j++);
        }

        return isDuplicate;
    }

    private void printWrongValue(boolean isWrongValue) {
        if (isWrongValue) {
            System.out.println("올바른 입력값이 아닙니다.");
        }
    }

    public HashMap<GameResult, Integer> run(String attackNumber, String defenceNumber) {
        HashMap<GameResult, Integer> resultMap = new HashMap<>();
        int numberLength = attackNumber.length();

        for (int i = 0; i < numberLength; i++) {
            GameResult key = getResultForPlate(i, attackNumber, defenceNumber);
            resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
        }
        
        return resultMap;
    }

    private GameResult getResultForPlate(int i, String attack, String defence) {
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

    public boolean confirmResult(HashMap<GameResult, Integer> resultGameMap) {
        boolean confirmResult = false;
        if (resultGameMap.containsKey(STRIKE) && resultGameMap.get(STRIKE) == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            confirmResult = true;
        }

        return confirmResult;
    }

    public boolean askContinue() {
        boolean isContinue = true;
        String finishValue = null;

        while (isContinue) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            finishValue = scanner.next();
            isContinue = checkFinishValue(finishValue);
        }

        return "1".equals(finishValue);
    }

    public boolean checkFinishValue(String finishValue) {
        try {
            validateFinishValue(finishValue);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private void validateFinishValue(String finishValue) {
        switch (finishValue) {
            case "1":
            case "2":
                break;
            default:
                throw new IllegalArgumentException("올바른 입력값이 아닙니다. 1 혹은 2 를 입력해주세요.");
        }
    }

}
