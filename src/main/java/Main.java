import java.util.*;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> goalValues = generateGoalValue();
        int inputValue = in.nextInt();
        List<Integer> inputValues = getUserInputValue(inputValue);
        int ballCount = getBallCount(goalValues, inputValues);
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
}
