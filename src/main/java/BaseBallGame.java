import java.util.*;


public class BaseBallGame {
    int[] generatedArray;
    int[] userArray;

    BaseBallGame() {
        generatedArray = new int[3];
        userArray = new int[3];
    }

    void generateNumber() {
        List<Integer> baseBallNum = new ArrayList<Integer>();
        for(int i = 1 ; i <= 9 ; i++) {
            baseBallNum.add(i);
        }
        Collections.shuffle(baseBallNum);
        for(int i = 0 ; i < 3 ; i++) {
            generatedArray[i] = baseBallNum.get(i);
        }

        return;
    }

    void getUserNumber() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input Number : ");
            String input = sc.next();
            String[] inputArray = input.split("");
            for(int i = 0; i < userArray.length; i++) {
                userArray[i] = Integer.parseInt(inputArray[i]);
            }
        } while (isUserNumberDuplicate());

        return;
    }

    boolean isUserNumberDuplicate() {
        if(
            userArray[0] == userArray[1]
         || userArray[0] == userArray[2]
         || userArray[2] == userArray[1]) {
            System.out.println("3개의 숫자는 서로 다른 수가 되어야 합니다. 다시 입력하세요.");
            return true;
        }

        return false;
    }


}
