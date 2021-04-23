package baseball.constants;

import lombok.Getter;

public enum MessageKey {
    inputPrompt("inputPrompt"),
    successGameResultFormat("successGameResultFormat"),
    failedGameResultFormat("failedGameResultFormat"),
    askingReGamePrompt("askingReGamePrompt"),
    noStrikeNoBallResultFormat("noStrikeNoBallResultFormat"),
    strikeAndBallResultFormat("strikeAndBallResultFormat"),
    onlyStrikeResultFormat("onlyStrikeResultFormat"),
    onlyBallResultFormat("onlyBallResultFormat");

    MessageKey(String key) {
        this.key = key;
    }

    @Getter
    private String key;
}
