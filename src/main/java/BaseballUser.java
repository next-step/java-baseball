import java.util.HashMap;
import java.util.HashSet;

public class BaseballUser {
    private HashMap<Integer, Integer> numbers;

    public void userThreeIntegerInput() {
        String input;
        numbers = new HashMap<>();

        while (true) {
            System.out.print(SystemMessage.THREE_INTEGER_INPUT);
            input = GameManager.userInput.next();
            try{
                numberSeparator(input);
                break;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void numberSeparator(String numberString) throws Exception {
        isValidNumber(numberString);

        for(int i = 0; i < 3; ++i){
            int number = numberString.charAt(i) - '0';
            numbers.put(number, i);
        }
    }
    private void isValidNumber(String numberString) throws Exception {
        if (numberString.length() != 3){
            throw new Exception(SystemMessage.THREE_INTEGER_EXCEPTION);
        }

        HashSet<Integer> duplicateChecker = new HashSet<>();
        for(char charNumber : numberString.toCharArray()){
            int number = charNumber - '0';
            if(1 > number || number > 9){
                throw new Exception(SystemMessage.ONE_NINE_INTEGER_EXCEPTION);
            }
            duplicateChecker.add(number);
        }

        if(duplicateChecker.size() != 3){
            throw new Exception(SystemMessage.DUPLICATE_INTEGER_EXCEPTION);
        }
    }

    public HashMap<Integer, Integer> getNumbers() {
        return numbers;
    }
}