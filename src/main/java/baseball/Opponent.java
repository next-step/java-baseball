package baseball;

public class Opponent {

    private String value;

    public Opponent() {
        value = "";
    }

    public void selectValue() {
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < 3; i++) {
            Integer randomNumber = numberGenerator.getRandomNumber();
            this.value = this.value.concat(randomNumber.toString());
        }

    }

    public String getValue() {
        return value;
    }
}
