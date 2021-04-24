import baseball.NumberGenerator;

public class NumberGeneratorStub extends NumberGenerator {
    private String number;

    public NumberGeneratorStub(String number) {
        this.number = number;
    }

    @Override
    public String generate() {
        return this.number;
    }
}
