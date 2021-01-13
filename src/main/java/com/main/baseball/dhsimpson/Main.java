package com.main.baseball.dhsimpson;

import java.util.Scanner;

public class Main {
    int[] computerNum;
    int[] playerNum;
    Scanner scan;
    // 기본 생성
    Main(){
        computerNum = new int[3];
        playerNum = new int[3];
        scan = new Scanner(System.in);
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
        //TODO : Scanner 관련 예외 발생 처(1,2 이외의 입력)
        int isFinish;
        while(true){
            System.out.println("숫자를 입력해 주세요 : ");
            setPlayerNum();
            compareNums(); // 이 안에서 gameMessage를 출력하자.
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isFinish = scan.nextInt();
            if(isFinish == 1){
                return true;
            }else if(isFinish == 2){
                return false;
            }
        }
    }
    // 게임 진행 시 메시지 보여주기
    void gameMessage(){

    }
    // Test
    public static void main(String args){

    }
}
