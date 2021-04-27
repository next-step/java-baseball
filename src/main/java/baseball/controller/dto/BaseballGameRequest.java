package baseball.controller.dto;

public class BaseballGameRequest {

    private final String pitchNumbers;

    public BaseballGameRequest(String pitchNumbers) {
        this.pitchNumbers = pitchNumbers;
    }

    public String getPitchNumbers() {
        return pitchNumbers;
    }
}
