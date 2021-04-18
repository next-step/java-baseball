public class BaseballGame {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        MakeRandomNumber randomNumber = new MakeRandomNumber();
        
        Integer input = userInput.setAndGetInputNumber();

        System.out.println("input = " + input);
    }
}
