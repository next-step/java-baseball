package baseballgame.io;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Messages {
    REQUEST_NUMBER("숫자를 입력해주세요 : "),
    GAME_CLEAR("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    STRIKE(" 스트라이크 "),
    BALL(" 볼"),
    NOTHING("낫싱"),
    INVALID_INPUT("잘못된 입력입니다.")
    ;

    private final String message;

}
