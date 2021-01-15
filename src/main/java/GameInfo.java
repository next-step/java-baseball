import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameInfo {

    private String number;
    private boolean gameResumption;

    public GameInfo() {
        number = "";
        gameResumption = true;
    }

    public GameInfo(String number) {
        this.number = number;
    }
}
