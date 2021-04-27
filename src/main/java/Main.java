import java.util.*;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> goalValues = generateGoalValue();
        System.out.println(goalValues);

        while (true) {
            System.out.println("숫자를 입력해주세요 :");
            int inputValue = in.nextInt();
            List<Integer> inputValues = getUserInputValue(inputValue);
            Map<String, Integer> result = getResult(goalValues, inputValues);
            int strikeCount = result.get("strike");
            int ballCount = result.get("ball");

            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱");
                continue;
            }

            if (strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                break;
            }
            printResult(ballCount, strikeCount);
        }
    }

    private static List<Integer> generateGoalValue(){
        List<Integer> goalValueSet = new ArrayList<>();
        do {
            int randomValue = random.nextInt(9);
            if (!goalValueSet.contains(randomValue)) {
                goalValueSet.add(randomValue);
            }
        } while (goalValueSet.size() < 3);
        return goalValueSet;
    }

    private static List<Integer> getUserInputValue(int userInput){
        List<Integer> userInputList = new ArrayList<>();
        int modifyNumber = 100;
        do {
            int value = userInput / modifyNumber;
            userInput %= modifyNumber;
            modifyNumber /= 10;
            userInputList.add(value);
        } while (modifyNumber != 0);
        return userInputList;
    }

    private static Map<String, Integer> getResult(List<Integer> goalValues, List<Integer> inputValues) {
        Map<String, Integer> result = new HashMap<String, Integer>(){{ put("strike", 0); put("ball", 0);}};
        for (int i = 0; i < inputValues.size(); i++){
            if (inputValues.get(i).equals(goalValues.get(i))) {
                result.compute("strike", (k, v) -> v += 1);
                continue;
            }
            if (goalValues.contains(inputValues.get(i)))
                result.compute("ball", (k, v) -> v += 1);
        }
        return result;
    }

    private static void printResult(int ballCount, int strikeCount){
        String result = "";
        if (strikeCount > 0){
            result += String.format("%d 스트라이크 ", strikeCount);
        }
        if (ballCount > 0){
            result += String.format("%d볼", ballCount);
        }
        System.out.println(result);
    }
}
