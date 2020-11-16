import java.util.ArrayList;
import java.util.List;

public class GameRule {

    // 1 - 9 Answer Keyword
    private List<String> reservedNumberSet;
    private String gameAnswer;

    public void initAnswer() {
        setReservedNumberSet();
    }

    private void setReservedNumberSet() {
        reservedNumberSet = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            reservedNumberSet.add(String.format("%d", i));
        }
    }

    public List<String> getReservedNumberSet() {
        return reservedNumberSet;
    }
}
