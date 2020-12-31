import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BaseballGame {
    private final int[] randomArr;

    public BaseballGame(){
        randomArr = generateRandomNumber();
    }

    public void start(){
        boolean isNotMatched = true;
        while(isNotMatched){
            System.out.print("숫자를 입력해주세요 : ");
            int[] inputArr = numberToArr(InputReader.getNumberInput());
            int strikeCnt = countStrike(inputArr);
            int duplicateCnt = countDuplicate(inputArr);
            isNotMatched = checkCondition(strikeCnt, duplicateCnt);
        }
    }


    private int[] generateRandomNumber(){
        Iterator<Integer> itr = generateSet().iterator();
        int []randomArr = new int[3];
        int i = 0;
        while(itr.hasNext()){
            randomArr[i++] = itr.next();
            System.out.print(randomArr[i-1]);
        }
        System.out.println();
        return randomArr;
    }

    private Set<Integer> generateSet(){
        Set<Integer> set = new HashSet<>();
        Random rand = new Random();
        boolean invalid = true;
        while(invalid){
            set.add(rand.nextInt(9));
            invalid = checkSetSize(set);
        }
        return set;
    }

    private boolean checkSetSize(Set<Integer> set) {
        if(set.size() != 3) return true;
        return false;
    }

    private int[] numberToArr(int input){
        int []inputArr = new int[3];
        int k = 100;
        for(int i = 0; i < inputArr.length; i++){
            inputArr[i] = input / k;
            input %= k;
            k /= 10;
        }
        return inputArr;
    }

    private int countStrike(int []inputArr){
        int strikeCnt = 0;
        if(randomArr[0] == inputArr[0]) strikeCnt++;
        if(randomArr[1] == inputArr[1]) strikeCnt++;
        if(randomArr[2] == inputArr[2]) strikeCnt++;
        return strikeCnt;
    }

    private int countDuplicate(int[] inputArr){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < randomArr.length; i++){
            set.add(randomArr[i]);
            set.add(inputArr[i]);
        }
        return randomArr.length * 2 - set.size();
    }

    private boolean checkCondition(int strikeCnt, int duplicateCnt){
        int ballCnt = duplicateCnt - strikeCnt;
        if(strikeCnt == 3){
            System.out.println(generateStrikeMsg(strikeCnt));
            return false;
        }
        System.out.println(
                generateStrikeMsg(strikeCnt) + generateBallMsg(ballCnt)
        );
        return true;
    }

    private String generateStrikeMsg(int strikeCnt){
        if(strikeCnt == 0) return "";
        return strikeCnt + " 스트라이크 ";
    }
    private String generateBallMsg(int ballCnt){
        if(ballCnt == 0) return "";
        return ballCnt + " 볼 ";
    }
}
