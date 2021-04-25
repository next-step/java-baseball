package com.dnswkdl.app;

import com.dnswkdl.service.GamePlayService;

import java.util.Scanner;

public class GamePlay implements ImplGamePlay {
    private Scanner scanner;
    private GamePlayService service;

    @Override
    public void init() {
        /* TODO
        *   1. 정답 생성
        *   2. 변수 선언 */
        scanner = new Scanner(System.in);
        service = new GamePlayService();
    }

    @Override
    public void start() {
        /* TODO
        *   1. 사용자 입력 ( 숫자 3개 )
        *   2. 입력 숫자와 정답 비교
        *   3. 결과 도출 (3 strike 종료, 이외에는 결과 print 재입력 */
    }

    @Override
    public boolean replay() {
        return false;
    }
}
