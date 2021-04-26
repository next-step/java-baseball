import java.util.*;


public class BaseBallGame {
    int[] generatedArray;
    int[] userArray;

    BaseBallGame() {
        generatedArray = new int[3];
        userArray = new int[3];
    }

    void gamePlay() {
        generateNumber(); // 숫자 생성
        do {
            getUserNumber();  // 숫자 입력
        } while (!checkGameResult()); // 결과 체크
    }

    boolean againGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = sc.next();
        if(input.equals("1")) {
            return true;
        }
        return false;
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
        //System.out.println("생성된 숫자 : "+Arrays.toString(generatedArray));
        return;
    }

    void getUserNumber() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("숫자를 입력해주세요 : ");
            String input = sc.next();
            String[] inputArray = input.split("");
            convertStringToNumber(inputArray);
        } while (isUserNumberDuplicate());
        return;
    }

    void convertStringToNumber(String[] inputArray) {
        for(int i = 0; i < userArray.length; i++) {
            userArray[i] = Integer.parseInt(inputArray[i]);
        }
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

    boolean checkGameResult() {
        int strike = checkStrikeNumber();
        int ball = checkBallNumber();
        System.out.println("strike : "+strike);
        System.out.println("ball : "+ball);
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }
        if(strike > 0) {
            System.out.print(String.format("%d 스트라이크 ",strike));
        }
        if(ball > 0) {
            System.out.println(String.format("%d 볼",ball));
        }
        return false;
    }

    int checkStrikeNumber() {
        int count = 0;
        if(generatedArray[0] == userArray[0]) {
            count++;
        }
        if(generatedArray[1] == userArray[1]) {
            count++;
        }
        if(generatedArray[2] == userArray[2]) {
            count++;
        }
        return count;
    }

    int checkBallNumber() {
        int count = 0;
        if(generatedArray[0] == userArray[1] || generatedArray[0] == userArray[2]) {
            count++;
        }
        if(generatedArray[1] == userArray[0] || generatedArray[1] == userArray[2]) {
            count++;
        }
        if(generatedArray[2] == userArray[0] || generatedArray[2] == userArray[1]) {
            count++;
        }
        return count;
    }

}
