import java.util.List;

public class BaseBallDTO extends DTO{

    private int countOfStrike;
    private int countOfBall;
    private List<String> enemyNumbers;
    private List<String> inputNumbers;
    private String inputNumber;

    public int getCountOfStrike() {
        return countOfStrike;
    }

    public void setCountOfStrike(int countOfStrike) {
        this.countOfStrike = countOfStrike;
    }

    public int getCountOfBall() {
        return countOfBall;
    }

    public void setCountOfBall(int countOfBall) {
        this.countOfBall = countOfBall;
    }

    public List<String> getEnemyNumbers() {
        return enemyNumbers;
    }

    public void setEnemyNumbers(List<String> enemyNumbers) {
        this.enemyNumbers = enemyNumbers;
    }

    public List<String> getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(List<String> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }
}
