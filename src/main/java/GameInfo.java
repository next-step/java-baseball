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

    public GameInfo(String number, boolean gameResumption){
        this.number = number;
        this.gameResumption = gameResumption;
    }

    @Override
    public boolean equals(Object obj){
        GameInfo gameInfo = (GameInfo)obj;
        return number.equals(gameInfo.getNumber()) && gameResumption == gameInfo.isGameResumption();
    }
}
