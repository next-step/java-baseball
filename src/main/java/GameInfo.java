import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameInfo {

    private String ball;
    private String gameResult;
    private boolean gameResumption;

    public GameInfo() {
        ball = "";
        gameResult = "";
        gameResumption = false;
    }

    public GameInfo(String ball) {
        this.ball = ball;
    }
}
