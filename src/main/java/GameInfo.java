import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameInfo {

    private String number;
    private String gameResult;
    private boolean gameResumption;

    public GameInfo() {
        number = "";
        gameResult = "";
        gameResumption = false;
    }

    public GameInfo(String number) {
        this.number = number;
    }
}
