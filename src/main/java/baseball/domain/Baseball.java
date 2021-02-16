package baseball.domain;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class Baseball {
    Numbers computerNumber; // TODO: 일급 컬렉션으로.래핑 해줌
    Numbers playerNumber;
    private boolean playerWin;

    public void printComputerNumbers(){
        System.out.print("컴퓨터 숫자 : ");
        for(Integer number : computerNumber.getNumbers()){
            System.out.print(number.toString());
        }
        System.out.println();
    }

    // 컴퓨터가 숫자 지정하기. 한 번의 게임을 시작할 때 한 번만 실행한다.
    public void setComputerNumber(){
        // 100 <= temp < 1000 의 난수 생성
        int numbers = (int)(random()*100 + 100);
        computerNumber = new Numbers(numbers);
    }
    // 플레이어가 숫자 지정하기. 맞출 때 까지 실행한다.
    public void setPlayerNum(int numbers){
        playerNumber = new Numbers(numbers);
    }
    // 컴퓨터와 플레이어의 숫자 비교하기
    public boolean compareNumbers(int numbers){
        setPlayerNum(numbers);
        int strikes = 0;
        int balls = 0;
        ArrayList<Integer> idxList = new ArrayList<>();
        // 스트라이크 수 세기
        for(int i=0; i<3; i++){
            if(computerNumber.getNumbers().get(i)== playerNumber.getNumbers().get(i)){
                strikes++;
            }else{
                // 숫자가 다르다면 해당 idx를 저장
                idxList.add(i);
            }
        }
        // 볼 수 세기
        for(int idx : idxList){
            // ball이 존재하는 지 playerNum[idx]와 computerNum[0~2]를 비교
            balls += checkBall(idx);
        }
        // 현재의 strike, ball 상태 프린트
        gameMessage(strikes, balls);
        // strike, ball 수에 따라 게임 종료 조건 명시
        if (strikes==3){
            return true;
        }
        else {
            return false;
        }
    }
    public int checkBall(int index){
        int ballCount = 0;
        // computerNum의 각 자릿수를 전체 탐색
        for(int i=0; i<3; i++){
            // 같은 idx는 건너 뜀
            if(index == i){
                continue;
            }
            // 다른 idx의 숫자가 같다면 ballCount를 증가
            else if(playerNumber.getNumbers().get(index)== computerNumber.getNumbers().get(index)){
                ballCount++;
            }
        }
        return ballCount;
    }

    //Output View
    // 게임 진행 시 메시지 보여주기 : compareNums 안에서
    void gameMessage(int strikes, int balls){

        if(balls == 0 && strikes == 0) {
            System.out.printf("낫싱");
        }
        else if(balls > 0) {
            System.out.printf("%d볼 ", balls);
        }
        else if(strikes > 0) {
            System.out.printf("%d스트라이크 ", strikes);
        }
        System.out.println();
    }

    public void initGame() {
        setComputerNumber(); // 컴퓨터 난수 생성.
        playerWin = false;
    }

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
