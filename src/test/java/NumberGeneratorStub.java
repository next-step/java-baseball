import baseball.NumberGenerator;

public class NumberGeneratorStub extends NumberGenerator {
    private int generateCallCount;
    private String number;

    public NumberGeneratorStub(String number) {
        this.number = number;
        this.generateCallCount = 0;
    }

    @Override
    public String generate() {
        this.generateCallCount++;
        return this.number;
    }

    public int getGenerateCallCount() {
        return this.generateCallCount;
    }
}
