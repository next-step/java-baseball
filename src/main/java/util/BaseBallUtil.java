package util;

import domain.BaseballType;

import java.util.*;

public class BaseBallUtil {
    private static final int [] fixedNumber = {1,2,3,4,5,6,7,8,9};

    //출력하기전 맵값 세팅.
    public  Map<String,Integer> setBaseballMap(int strikeCnt, int ballCnt) {
        Map<String,Integer> resultMap = new HashMap<>();
        resultMap.put(BaseballType.STRIKE.name(),strikeCnt);
        resultMap.put(BaseballType.BALL.name(),ballCnt);

        return resultMap;
    }

    //볼카운트 세어주는 메소드
    public int getBallCount(int[] computerNumber, int[] userNumber) {
        int ballCnt = 0;
        for(int i = 0; i < computerNumber.length; i++){
            for(int j = 0; j < userNumber.length; j++){
                if(i!=j && computerNumber[i] == userNumber[j]){
                    ballCnt++;
                    break;
                }
            }
        }
        return ballCnt;
    }
    //스트라이크 갯수 파악해주는 메서드
    public  int getStrikeCount(int [] computerNumber,int [] userNumber){
        int strikeCnt=0;
        for(int i = 0; i < computerNumber.length; i++){
            for(int j = 0; j < userNumber.length; j++){
                if(i==j && computerNumber[i] == userNumber[j]){
                    strikeCnt++;
                    break;
                }
            }
        }
        return strikeCnt;
    }
    //유저 숫자 비교하기 좋게 만들어주는것.
    public int[] userNumGenerator(String input) {
        int [] generator = new int[3];
        String [] strArr = input.split("");
        for(int i = 0; i < strArr.length; i++){
            generator[i] = Integer.parseInt(strArr[i]);
        }
        return generator;
    }

    //제외한 숫자를 다시 int형으로 반환해줌.
    public int[] numGenerator(){
        int [] generator = new int[3];
        Iterator<Integer> iterator = getDeduplicate().iterator();
        int idx = 0;
        while(iterator.hasNext()){
            generator[idx] = iterator.next();
            idx++;
        }
        return generator;
    }

    //set을 이용하여 중복숫자를 제외.
    public Set<Integer> getDeduplicate(){
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        while(set.size() < 3){
            int n = random.nextInt(9);
            set.add(fixedNumber[n]);
            if(set.size() == 3){
                break;
            }
        }
        return set;
    }


}
