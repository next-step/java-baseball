package com.main.baseball.dhsimpson;

public class Main {
    int[] computerNum;
    int[] playerNum;
    // 기본 생성
    Main(){
        computerNum = new int[3];
        playerNum = new int[3];
    }
    // 게임 실행
    void playGame(){
        boolean isFinish = true;
        while(isFinish){
            // 게임 시작할 때 컴퓨터 번호 랜덤 설정
            setComputerNum();
            isFinish = playOnce();
        }
    }
    // 컴퓨터가 숫자 지정하기. 한 번의 게임을 시작할 때 한 번만 실행한다.
    void setComputerNum(){

    }
    // 플레이어가 숫자 지정하기. 맞출 때 까지 실행한다.
    void setPlayerNum(){

    }
    // 컴퓨터와 플레이어의 숫자 비교하기
    void compareNums(){

    }
    // 한 루틴의 게임 : 숫자 맞출 때 까지 게임 진행하기
    boolean playOnce(){
        return true;
    }
    // 게임 진행 시 메시지 보여주기
    void gameMessage(){

    }
    // Test
    public static void main(String args){

    }
}
