package com.dnswkdl.app;

import com.dnswkdl.service.GamePlayService;

import java.util.Scanner;

public class GamePlay implements ImplGamePlay {
    private Scanner scanner;
    private GamePlayService service;

    private boolean isFinished;
    private int answer;

    @Override
    public void init() {
        /* TODO
        *   1. 정답 생성
        *   2. 변수 선언 */
        scanner = new Scanner(System.in);
        service = new GamePlayService();
        answer = 123;
        isFinished = false;
    }

    @Override
    public void start() {
        while(!isFinished){
            play();
        }
    }
    @Override
    public boolean replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replay = 0;
        try{
            replay = scanner.nextInt();
        }catch (Exception e){
            scanner.nextLine();
        }
        if(replay!=1 && replay!=2) {
            System.out.println("잘못 입력 하였습니다.");
            return replay();
        }

        if(replay==1) return true;
        return false;
    }


    private void play(){
        int inputNumber = getInputNumber();
        int[] result = service.check(answer, inputNumber);
        checkResult(result[0], result[1]);
    }
    private int getInputNumber(){
        int input_number = 0;

        System.out.print("숫자를 입력해주세요 : ");
        try{
            input_number = scanner.nextInt();
        }catch (Exception e){
            scanner.nextLine();
        }
        if(input_number<100 || input_number>1000){
            System.out.println("잘못 입력 하였습니다. 1~9 중 서로다른 3개의 숫자를 입력해야합니다.");
            return getInputNumber();
        }
        return input_number;
    }

    private void checkResult(int strike, int ball){
        if(strike==0 && ball==0){
            System.out.println("낫싱");
            return;
        }
        System.out.println((strike!=0?(strike+" 스트라이크 "):(""))+(ball!=0?(ball+" 볼 "):("")));

        if(strike==3){
            isFinished = true;
            return;
        }
    }

}
