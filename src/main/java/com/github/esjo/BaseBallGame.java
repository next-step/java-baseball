package com.github.esjo;

import com.github.esjo.domain.Computer;
import com.github.esjo.domain.Player;
import com.github.esjo.domain.Status;

import static com.github.esjo.domain.Message.*;
import static com.github.esjo.domain.Rule.*;

public class BaseBallGame {

    static NumberGenerator numberGenerator
            = NumberGenerator.createNumberGenerator(MIN.getValue(), MAX.getValue(),
            NUMBER_OF_DIGITS.getValue());
    static BaseBallIO baseBallIO = BaseBallIO.createBaseBallIO(System.in);
    static Computer computer;
    static Player player;

    /**
     * 플레이어의 입력값에 따라, 플레이어의 상태값을 변경한다.
     * */
    public static void askPlayOrQuit(Player player) {
        String input = readValidValueByInput();
        if (Status.PLAY.getValue().equals(input)) { // PLAY(1) 선택시, 플레이어 상태 (재)시작으로 변경
            player.setStatus(Status.INIT);
        } else if (Status.QUIT.getValue().equals(input)) { // QUIT(2) 선택시, 플레이어 상태 게임중단으로 변경
            player.setStatus(Status.QUIT);
        }
    }

    /**
     * 유효한값이 될때까지, 사용자로 부터 입력을 받는다.
     * @return String 플레이어의 유효한(PLAY(1) 또는 QUIT(2)) 입력값.
     * */
    private static String readValidValueByInput() {
        String input = null;
        do {
            input = readValueByInput();
        } while (input == null);
        return input;
    }

    /**
     * 플레이어로 부터 입력을 받는다.
     * @return String 플레이어의 입력값. PLAY(1) 또는 QUIT(2) 이외의 값은 null 처리.
     * */
    private static String readValueByInput() {
        try {
            System.out.print(RESTART_MSG.getValue());
            return baseBallIO.readPlayOrQuit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        do {
            if (player == null || player.getStatus() == Status.INIT) { // (재)시작 직후 컴퓨터(상대방)의 숫자를 생성
                computer = Computer.createNumberSet(numberGenerator);
            }
            player = Player.createNumberSet(numberGenerator, baseBallIO);
            computer.matchWith(player); // 컴퓨터(상대방)과 플레이어의 수를 비교
            if (player.getStatus() == Status.PASS) {
                askPlayOrQuit(player); // 컴퓨터(상대방)의 수를 맞추면, 재시작 여부를 묻는다
            }
        } while (player.getStatus() != Status.QUIT); // 플레이어가 게임중단(QUIT)전 까지 게임반복
        System.out.println("**GAME OVER**");
    }
}
