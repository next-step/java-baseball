import java.util.*;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> goalValues = generateGoalValue();

        while (true){
            int inputValue = in.nextInt();
            List<Integer> inputValues = getUserInputValue(inputValue);
            int ballCount = getBallCount(goalValues, inputValues);
            int strikeCount = getStrikeCount(goalValues, inputValues);

            if (strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                break;
            }

            if (ballCount == 0 && strikeCount == 0){
                System.out.println("낫싱");
                continue;
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

    private static int getBallCount(List<Integer> goalValues, List<Integer> inputValues){
        int ballCount = 0;
        for (int value : inputValues){
            if (goalValues.contains(value)){
                ballCount += 1;
            }
        }
        return ballCount;
    }

    private static int getStrikeCount(List<Integer> goalValues, List<Integer> inputValues) {
        int strike = 0;
        for (int i = 0; i < inputValues.size(); i++){
            int value = inputValues.get(i);
            if (value == goalValues.get(i)){
                strike += 1;
            }
        }
        return strike;
    }


    private static void printResult(int ballCount, int strikeCount){
        String result = "";
        if (strikeCount > 0){
            result += String.format("%d 스트라이크", strikeCount);
        }
        if (ballCount > 0){
            result += String.format("%d볼", ballCount);
        }
        System.out.println(result);
    }
}
