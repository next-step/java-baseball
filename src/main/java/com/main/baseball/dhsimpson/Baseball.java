package com.main.baseball.dhsimpson;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class Baseball {
    int[] computerNum;
    int[] playerNum;
    Scanner scan;
    // 기본 생성
    public Baseball(){
        computerNum = new int[3];
        playerNum = new int[3];
        scan = new Scanner(System.in);
    }
    // 게임 실행
    public void playGame(){
        boolean isFinish = true;
        while(isFinish){
            // 게임 시작할 때 컴퓨터 번호 랜덤 설정
            setComputerNum();
            isFinish = playOnce();
        }
    }
    // 컴퓨터가 숫자 지정하기. 한 번의 게임을 시작할 때 한 번만 실행한다.
    public void setComputerNum(){
        // 100 <= temp < 1000 의 난수 생성
        int temp = (int)(random()*100 + 100);
        for(int i=1; i<=2; i++){
            computerNum[3-i] = (int)(temp%pow(10,1)) ;
            temp = (int)(temp/pow(10,1));
        }
        computerNum[0] = temp;
    }
    // 플레이어가 숫자 지정하기. 맞출 때 까지 실행한다.
    public void setPlayerNum(){
        int temp = scan.nextInt();
        for(int i=1; i<=2; i++){
            playerNum[3-i] = (int)(temp%pow(10,1)) ;
            temp = (int)(temp/pow(10,1));
        }
        playerNum[0] = temp;
    }
    // 컴퓨터와 플레이어의 숫자 비교하기
    public boolean compareNums(){
        int strikes = 0;
        int balls = 0;
        boolean isCorrect = false;
        ArrayList<Integer> idxList = new ArrayList<Integer>();
        // 스트라이크 수 세기
        for(int i=0; i<3; i++){
            if(computerNum[i]==playerNum[i]){
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
    public int checkBall(int idx){
        int ballCount = 0;
        // computerNum의 각 자릿수를 전체 탐색
        for(int i=0; i<3; i++){
            // 같은 idx는 건너 뜀
            if(idx == i){
                continue;
            }
            // 다른 idx의 숫자가 같다면 ballCount를 증가
            else if(playerNum[idx]==computerNum[i]){
                ballCount++;
            }
        }
        return ballCount;
    }


    // 한 루틴의 게임 : 숫자 맞출 때 까지 게임 진행하기
    public boolean playOnce(){
        //TODO : Scanner 관련 예외 발생 처(1,2 이외의 입력) -> setPlayerNum에서만 발생할 듯?? 그 함수에 throw 붙여주자
        boolean playerWin = false;
        int isFinish;
        while(true){
            System.out.println("숫자를 입력해 주세요 : ");
            setPlayerNum();
            playerWin = compareNums(); // 이 안에서 gameMessage를 출력하자.
            // 숫자 3개 전부 맞췄을 때 루프 종료
            if(playerWin){
                break;
            }
        }
        // 1,2 이외의 숫자 입력이나 숫자 이외를 입력 시 예외 발생
        while(true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isFinish = scan.nextInt();
            if(isFinish == 1){
                return true;
            }else if(isFinish == 2){
                return false;
            }else{
                System.out.println("잘못 된 숫자를 입력했습니다.");
            }
        }
    }
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
}
