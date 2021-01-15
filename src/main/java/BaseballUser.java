import java.util.HashMap;
import java.util.HashSet;

public class BaseballUser {
    private HashMap<Integer, Integer> numbers;

    public void userThreeIntegerInput() {
        String input;
        numbers = new HashMap<>();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
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
            throw new Exception("3자리 숫자를 입력해주세요 !");
        }

        HashSet<Integer> duplicateChecker = new HashSet<>();
        for(char charNumber : numberString.toCharArray()){
            int number = charNumber - '0';
            if(1 > number || number > 9){
                throw new Exception("1 ~ 9로 이루어진 3개 숫자를 입력해주세요 !");
            }
            duplicateChecker.add(number);
        }

        if(duplicateChecker.size() != 3){
            throw new Exception("중복된 숫자가 있습니다. 다시 입력해주세요 !");
        }
    }

    public HashMap<Integer, Integer> getNumbers() {
        return numbers;
    }
}