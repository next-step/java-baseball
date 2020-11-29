
package service;

import domain.BaseballType;
import exception.BaseBallException;
import util.BaseBallUtil;

import java.util.*;

public class BaseBallUtilServiceImpl implements BaseBallUtilService{
    private static final int [] fixedNumber = {1,2,3,4,5,6,7,8,9};
    Scanner scan = new Scanner(System.in);
    private int [] newComputNumber = new int[3];


    //출력하기전 맵값 세팅.
    public Map<String,Integer> setBaseballMap(int strikeCnt, int ballCnt) {
        Map<String,Integer> resultMap = new HashMap<>();
        resultMap.put(BaseballType.STRIKE.name(),strikeCnt);
        resultMap.put(BaseballType.BALL.name(),ballCnt);

        return resultMap;
    }
    @Override
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


    @Override
    public int getStrikeCount(int[] computerNumber, int[] userNumber) {
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

    @Override
    public int[] userNumGenerator(String input) {
        int [] generator = new int[3];
        String [] strArr = input.split("");
        for(int i = 0; i < strArr.length; i++){
            generator[i] = Integer.parseInt(strArr[i]);
        }

        return generator;
    }

    @Override
    public int[] numGenerator() {
        int [] generator = new int[3];
        Iterator<Integer> iterator = getDeduplicate().iterator();
        int idx = 0;
        while(iterator.hasNext()){
            generator[idx] = iterator.next();
            idx++;
        }
        return generator;
    }

    @Override
    public Set<Integer> getDeduplicate() {
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

    @Override
    public void StartGame(Scanner scan,int [] computerNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scan.next();
        BaseBallException.throwsCheck(input);
        int [] userNumber = userNumGenerator(input);
        setBaseballMap(getBallCount(userNumber,computerNumber),getStrikeCount(userNumber,computerNumber));

    }

    @Override
        //결과 출력 처리.
    public void resultPrint(Map<String, Integer> map){
        if(map.get(BaseballType.STRIKE.name()) > 0 && map.get(BaseballType.BALL.name()) > 0){
            System.out.println(map.get(BaseballType.STRIKE.name()) + BaseballType.STRIKE.getType() + map.get(BaseballType.BALL.name()) + BaseballType.BALL.getType());
        }
        if(map.get(BaseballType.STRIKE.name()) > 0 && map.get(BaseballType.BALL.name()) == 0){
            System.out.println(map.get(BaseballType.STRIKE.name()) + BaseballType.STRIKE.getType());
        }
        if(map.get(BaseballType.STRIKE.name()) == 0 && map.get(BaseballType.BALL.name()) > 0){
            System.out.println(map.get(BaseballType.BALL.name()) + BaseballType.BALL.getType());
        }
        lastPrint(map.get(BaseballType.STRIKE.name()));
    }

    //게임 종료 마지막 출력
    public void lastPrint(int strike){
        int gameFlag = 1;
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작 하려면 1, 종료 하려면 2를 입력하세요.");
            gameFlag = scan.nextInt();
            isReGame(gameFlag);
        }
    }

    @Override
    public Map<String,Object> isReGame(int gameFlag) {
        Map<String,Object> map = new HashMap<>();
        if(gameFlag == 1){
            newComputNumber = numGenerator();
            map.put("computerNumber", newComputNumber);
            map.put("isRegame",true);
            return map;
        }
        map.put("isRegame",false);
        System.out.println("게임을 종료합니다.");
        scan.close();
        return map;
    }

}

