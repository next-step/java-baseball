package baseball.domain;

import java.util.ArrayList;

import static java.lang.Math.random;

public class Baseball {
    public static final int THREE_DIGIT = 100;
    public static final int INCREASE = 1;
    public static final int DONT_INCREASE = 0;
    public static final int NUMBER_LENGTH = 3;
    public static final int STRIKE_GAME_END_BOUND = 3;
    Numbers computerNumber;
    Numbers playerNumber;

    private Count playerStrikes;
    private Count playerBalls;

    public int getPlayerStrikes() {
        return playerStrikes.getCount();
    }

    public int getPlayerBalls() {
        return playerBalls.getCount();
    }

    public void printComputerNumbers(){
        System.out.print("컴퓨터 숫자 : ");
        for(Integer number : computerNumber.getNumbers()){
            System.out.print(number.toString());
        }
        System.out.println();
    }

    // 게임 초기화.
    public void initGame() {
        setComputerNumber();
    }

    // 컴퓨터가 숫자 지정하기. 한 번의 게임을 시작할 때 한 번만 실행한다.
    public void setComputerNumber(){
        // 100 <= ~ < 1000 의 난수 생성
        Integer numbers = (int)(random()* THREE_DIGIT + THREE_DIGIT);
        computerNumber = new Numbers(numbers.toString());
    }

    // 플레이어가 숫자 지정하기. 맞출 때 까지 실행한다.
    public void setPlayerNumber(String numbers){
        playerNumber = new Numbers(numbers);
    }
    // 컴퓨터와 플레이어의 숫자 비교하기
    public boolean compareNumbers(String numbers){
        setPlayerNumber(numbers);
        ArrayList<Integer> indexList = new ArrayList<>();
        playerStrikes = countStrike(indexList);
        playerBalls = countBall(indexList);
        // strike 수에 따라 게임 종료 조건 명시
        if (playerStrikes.getCount() == STRIKE_GAME_END_BOUND){
            return true;
        }
        return false;
    }

    private Count countStrike(ArrayList<Integer> indextList) {
        Count strikes = new Count();
        for(int i = 0; i< NUMBER_LENGTH; i++){
            strikes.increase(checkStrike(indextList, i));
        }
        return strikes;
    }

    private int checkStrike(ArrayList<Integer> indextList, int index) {
        if(computerNumber.getNumbers().get(index) == playerNumber.getNumbers().get(index)){
            return INCREASE;
        }
        // 숫자가 다르다면 해당 idx를 저장
         indextList.add(index);
        return DONT_INCREASE;
    }

    private Count countBall(ArrayList<Integer> indexList) {
        Count balls = new Count();
        for(int index : indexList){
            // ball이 존재하는 지 playerNum[idx]와 computerNum[0~2]를 비교
            balls.increase(checkBall(index));
        }
        return balls;
    }

    public int checkBall(int index){
        int ballCount = 0;
        // computerNum의 각 자릿수를 전체 탐색
        for(int i=0; i<NUMBER_LENGTH; i++){
            // 같은 idx는 건너 뜀
            ballCount += increaseBallCount(i, index);
        }
        return ballCount;
    }

    private int increaseBallCount(int i, int index) {
        if(i == index){
            return DONT_INCREASE;
        }
        // 다른 idx의 숫자가 같다면 ballCount를 증가
        if(playerNumber.getNumbers().get(i) == computerNumber.getNumbers().get(index)){
            return INCREASE;
        }
        return DONT_INCREASE;
    }

    //Output View
    // 게임 진행 시 메시지 보여주기 : compareNums 안에서



    // TDD를 위한 메서드들
    // 두 수를 비교해 3Strike 인지 여부 반환
//    public boolean compareNumbers(int[] playeNumber){
//        int strikes = 0; //TODO: Count로 래핑.
//        int balls = 0;
//        boolean isCorrect = false;
//        ArrayList<Integer> idxList = new ArrayList<>();
//
//        // 스트라이크 수 세기
//        for(int i=0; i<3; i++){
//            if(computerNum[i]==playeNumber[i]){
//                strikes++;
//            }else{
//                // 숫자가 다르다면 해당 idx를 저장
//                idxList.add(i);
//            }
//        }
//        // 볼 수 세기
//        for(int idx : idxList){
//            // ball이 존재하는 지 playerNum[idx]와 computerNum[0~2]를 비교
//            balls += checkBall(idx);
//        }
//
//
//
//        // 현재의 strike, ball 상태 프린트
//        //OutputView
//        gameMessage(strikes, balls);
//        // strike, ball 수에 따라 게임 종료 조건 명시
//        if (strikes==3){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    // strike 아닌 경우, 다른 위치에 ball인 숫자(위치는 다르지만 현재 idx의 숫자와 같은 숫자) 수 계산
//    public int checkBall(int[] pNum, int[] cNum, int idx){
//        int ballCount = 0;
//        // computerNum의 각 자릿수를 전체 탐색
//        for(int i=0; i<3; i++){
//            // 같은 idx는 건너 뜀
//            if(idx == i){
//                continue;
//            }
//            // 다른 idx의 숫자가 같다면 ballCount를 증가
//            else if(pNum[idx]==cNum[i]){
//                ballCount++;
//            }
//        }
//        return ballCount;
//    }

}
