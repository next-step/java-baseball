public class BaseballGame {

    private static String answer;

    static void generateRandomNumber() {
        int randomNumber = (int)(Math.random()*1000);
        String stringNumber = String.valueOf(randomNumber);
        answer = stringNumber;
    }

    public static void main(String[] args) {
        generateRandomNumber();
    }
}
