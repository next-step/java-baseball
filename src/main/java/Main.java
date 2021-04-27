import java.util.*;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> goalValue = generateGoalValue();
        System.out.println("goalValue = " + goalValue);
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

}
