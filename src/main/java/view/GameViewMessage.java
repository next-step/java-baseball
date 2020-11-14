package view;

import domain.BaseBallNumbers;

public class GameViewMessage {
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String WIN_MESSAGE = BaseBallNumbers.DEFAULT_MAX_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String CHOOSE_COMMAND_MESSAGE = "게임을 새로 시작하려면 " + GameCommand.REPLAY.value() + ", 종료하려면 " + GameCommand.EXIT.value() + "를 입력하세요.";
}
