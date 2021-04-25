package com.dnswkdl.app;

import com.dnswkdl.service.GamePlayService;

import java.util.Scanner;

public class GamePlay implements ImplGamePlay {
    private Scanner scanner;
    private GamePlayService service;

    private int answer;

    @Override
    public void init() {
        /* TODO
        *   1. 정답 생성
        *   2. 변수 선언 */
        scanner = new Scanner(System.in);
        service = new GamePlayService();
        answer = 123;
    }

    @Override
    public void start() {
        /* TODO
        *   1. 사용자 입력 ( 숫자 3개 ) (완료)
        *   2. 입력 숫자와 정답 비교 (완료)
        *   3. 결과 도출 (3 strike 종료, 이외에는 결과 print 재입력 */
        while(true){
            int inputNumber = getInputNumber();
            int[] result = service.check(answer, inputNumber);
            if(result[0]==3){
                return;
            }
        }
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
}
