package baseball;

public class Main {
    private Referee referee;
    private NumberGenerator numberGenerator;

    private Main() {//prevent Default Constructor

    }

    public Main(Referee referee, NumberGenerator numberGenerator) {
        this.referee = referee;
        this.numberGenerator = numberGenerator;

    }


    public void start() {
        numberGenerator.getNotDuplicatedEachHundredNumber();
    }
}
