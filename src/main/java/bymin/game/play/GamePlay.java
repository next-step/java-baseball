package bymin.game.play;

import java.util.*;

public class GamePlay {
    Scanner sc;
    public String run() {
        sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return sc.next();
    }

    public String play(Map<String, Integer> mapResult, String run, ArrayList<Integer> numList) {
        checkRule(numList, run.toCharArray(), mapResult);
        resultMessage1(mapResult);
        return result(mapResult);
    }

    public void checkRule(List<Integer> list, char[] chars, Map<String, Integer> mapResult) {
        for (int i = 0; i < list.size(); i++) {
            checkInsert(i, list.get(i), chars, mapResult);
        }
    }

    public void checkInsert(int numberCheck, int ball, char[] chars, Map<String, Integer> mapResult) {
        for (int i = 0; i < chars.length; i++) {
            checkStrike(numberCheck, i, Integer.parseInt(String.valueOf(chars[i])) == ball, mapResult);
        }
    }

    public void checkStrike(int numberCheck, int charCheck, boolean check, Map<String, Integer> mapResult) {
        if (numberCheck == charCheck && check) {
            mapResult.put("스트라이크", mapResult.get("스트라이크") + 1);
            return;
        }

        if (check) {
            mapResult.put("볼", mapResult.get("볼") + 1);
        }
    }

    public void resultMessage1(Map<String, Integer> mapResult){
        Set<String> resultSet = mapResult.keySet();
        for (String result : resultSet) {
            System.out.print(resultMessage2(mapResult.get(result), result));
        }
        System.out.println(" ");
    }

    public String resultMessage2(int a, String b) {
        if (a > 0) {
            return a + " " + b;
        }

        return " ";
    }

    public String result(Map<String, Integer> mapResult){
        if (mapResult.get("스트라이크") == 3){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            return sc.next();
        }
        return null;
    }

}
