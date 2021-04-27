package baseball.ui;

import java.util.Map;
import java.util.Scanner;
import baseball.core.GameNumber;
import baseball.core.GameStatus;
import baseball.core.Round;

public class Program {
    private Scanner sc;

    public Program(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        boolean firstPlayFlag = true;
        while (isStart(firstPlayFlag)) {
            int computerNum = new GameNumber().getRandom(3);
            Round round = new Round(computerNum);
            play(round);

            firstPlayFlag = false;
        }
    }

    private boolean isStart(boolean firstPlayFlag) {
        if (firstPlayFlag) {
            return true;
        }

        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return (Integer.parseInt(sc.nextLine()) == 1);
    }

    private void play(Round round) {
        int num = receiveNum();

        Map<GameStatus, Integer> countMap = round.getGameStatusCountMap(num);
        printGameStatus(countMap);

        if (countMap.get(GameStatus.STRIKE) == Round.MAX_DIGITS) {
            System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Round.MAX_DIGITS));
            return;
        }
        play(round);
    }

    private int receiveNum() {
        System.out.print(String.format("%d자리 숫자를 입력해주세요 : ", Round.MAX_DIGITS));
        String line = sc.nextLine();
        if (line.length() != Round.MAX_DIGITS) {
            return receiveNum();
        }
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return receiveNum();
        }
    }

    private static void printGameStatus(Map<GameStatus, Integer> countMap) {
        if (countMap.get(GameStatus.STRIKE) > 0) {
            System.out.println(countMap.get(GameStatus.STRIKE) + GameStatus.STRIKE.toString());
        }
        if (countMap.get(GameStatus.BOLL) > 0) {
            System.out.println(countMap.get(GameStatus.BOLL) + GameStatus.BOLL.toString());
        }
        if (countMap.get(GameStatus.STRIKE) == 0 && countMap.get(GameStatus.BOLL) == 0) {
            System.out.println(GameStatus.NONE);
        }
    }
}
