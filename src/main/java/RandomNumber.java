public class RandomNumber {

    private final int randomNumber;

    public RandomNumber(int number) {
        randomNumber = number;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    @Override
    public String toString() {
        return "RandomNumber{" +
                "randomNumber=" + randomNumber +
                '}';
    }
}
