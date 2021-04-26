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

    @Override
    public void init() {
        /* 기본 변수 정의 및 정답 세팅 */
        scanner = new Scanner(System.in);
        service = new GamePlayService();
        answer = service.getAnswer();
        isFinished = false;
    }

    @Override
    public void start() {
        /* 게임 시작 */
        while(!isFinished){
            play();
        }
    }
    @Override
    public boolean replay() {
        /* 게임 종료 후 replay 선택 */
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
        /* 게임 시작 후 사용자 숫자 3가지 입력, 정답지 비교, 결과 도출 */
        List<Integer> inputNumber = getInputNumber();
        int[] result = service.check(answer, inputNumber);
        checkResult(result[0], result[1]);
    }

    private List<Integer> getInputNumber(){
        /* 사용자 숫자 3가지 입력, 중복 없어야 함.*/
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

        List<Integer> input = GamePlayUtils.toList(input_number);
        if(input.get(0).equals(input.get(1)) || input.get(1).equals(input.get(2)) || input.get(2).equals(input.get(0))){
            return getInputNumber();
        }
        return input;
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
