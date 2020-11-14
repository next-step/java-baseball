package baseball.dto;

public class BaseballGameJudgeDto {
    private int strike;
    private int boll;

    public BaseballGameJudgeDto(int strike, int boll) {
        this.strike = strike;
        this.boll = boll;
    }

    @Override
    public String toString() {
        return "BaseballGameJudgeDto{" +
                "strike=" + strike +
                ", boll=" + boll +
                '}';
    }

    public int getStrike() {
        return strike;
    }

    public int getBoll() {
        return boll;
    }

    /////////////////////

    public void merge(BaseballGameJudgeDto dto) {
        this.strike += dto.strike;
        this.boll += dto.boll;
    }
}
