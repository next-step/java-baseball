package com.dnswkdl.app;

import com.dnswkdl.service.GamePlayService;
import com.dnswkdl.service.GamePlayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlay implements ImplGamePlay {
    private Scanner scanner;
    private GamePlayService service;

    private boolean isFinished;
    private List<Integer> answer;

    /* 기본 변수 정의 및 정답 세팅 */
    @Override
    public void init() {
        scanner = new Scanner(System.in);
        service = new GamePlayService();
        answer = service.getAnswer();
        isFinished = false;
    }

    /* 게임 시작 */
    @Override
    public void start() {
        while(!isFinished){
            play();
        }
    }
    /* 게임 시작 후 사용자 숫자 3가지 입력, 정답지 비교, 결과 도출 */
    private void play(){
        List<Integer> inputNumber = getInputNumber();
        int[] result = service.check(answer, inputNumber);
        checkResult(result[0], result[1]);
    }


    /* 게임 종료 후 replay 선택 */
    @Override
    public boolean replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replay = getInput();

        if(replay!=1 && replay!=2) {
            System.out.println("잘못 입력 하였습니다.");
            return replay();
        }

        if(replay==1) return true;
        return false;
    }


    /* 사용자 숫자 3가지 입력, 중복 없어야 함.*/
    private List<Integer> getInputNumber(){

        System.out.print("숫자를 입력해주세요 : ");
        int inputNumber = getInput();

        List<Integer> input = GamePlayUtils.toList(inputNumber);
        boolean isRightFormat = input.get(0).equals(0) || input.get(0)>=10 || input.get(0).equals(input.get(1)) || input.get(1).equals(input.get(2)) || input.get(2).equals(input.get(0));
        if(isRightFormat){
            System.out.println("잘못 입력 하였습니다. 1~9 중 서로다른 3개의 숫자를 입력해야합니다.");
            return getInputNumber();
        }
        return input;
    }

    private int getInput(){
        int result = 0;
        try{
            result = scanner.nextInt();
        }catch (Exception e){
            scanner.nextLine();
        }
        return result;
    }


    private void checkResult(int strike, int ball){
        /* 결과 도출 */
        if(strike==0 && ball==0){
            System.out.println("낫싱");
            return;
        }
        System.out.println((strike!=0?(strike+" 스트라이크 "):(""))+(ball!=0?(ball+" 볼 "):("")));

        if(strike==3){
            isFinished = true;
        }
    }

}
