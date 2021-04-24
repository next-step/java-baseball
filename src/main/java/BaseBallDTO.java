import java.util.List;

public class BaseBallDTO {

    private String inputNumber;
    private String enemyNumber;
    private List<Integer> numberStorage;

    public String getEnemyNumber() {
        return enemyNumber;
    }

    public void setEnemyNumber(String enemyNumber) {
        this.enemyNumber = enemyNumber;
    }

    public List<Integer> getNumberStorage() {
        return numberStorage;
    }

    public void setNumberStorage(List<Integer> numberStorage) {
        this.numberStorage = numberStorage;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }
}
