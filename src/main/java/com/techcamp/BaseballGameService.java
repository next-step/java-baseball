package com;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * <pre>
 * com
 * ㄴ BaseballGameService.java
 * </pre>
 * @date : 2021-04-26 오후 5:03
 * @author : 김재범
 * @version : 1.0.0
 * @desc : 숫자야구 게임
 **/
@Component
public class BaseballGameService {
    private String answer;
    private boolean isContinue;
    private String input;

    /**
     * <pre>
     * 숫자 야구 시작 전 초기화
     * 정답 clear, 진행여부값 초기화, 정답 설정
     * </pre>
     * @author 김재범
     **/
    public void reset() {
        answer = "";
        isContinue = true;
        init();
    }

    /**
     * <pre>
     * 숫자야구 정답 3자리 숫자 생성
     * 0~9 숫자 3자리. 중복허용X
     * </pre>
     * @author 김재범
     **/
    public void init() {
        String r = String.valueOf(1 + (new Random()).nextInt(9));
        if(answer.contains(r)) init();
        if(answer.length() == 3) return;
        answer += r;
        init();
    }

    /**
     * <pre>
     * 숫자 야구 게임 시작 메서드
     * </pre>
     * @author 김재범
     **/
    void run() {
        reset();
        while(isContinue) {
            input();
            check();
            restart();
        }
    }

    /**
     * <pre>
     * 숫자 야구 게임 진행
     * 숫자 야구 게임을 위해 입력갑 입력 - 입력값 유효성 체크
     * </pre>
     * @author 김재범
     **/
    private void input() {
        //TODO 입력값을 입력 받고 유효성(숫자, 3자리) 검증
    }

    /**
     * <pre>
     * 입력한 3자리 숫자에 대해 숫자야구 게임 검증
     * 자리까지 동일 - 스트라이크, 숫자만 동일 - 볼
     * </pre>
     * @author 김재범
     **/
    private void check() {
        //TODO 입력한 3자리 숫자에 대해 숫자야구 게임 검증
    }

    /**
     * <pre>
     * 입력값 검증 결과에 따른 로그 출력
     * ex> 1 스트라이크, 1 볼, 1스트라이크 2볼, 낫싱
     * </pre>
     * @author 김재범
     **/
    private void result(int strike, int ball) {
        //TODO 입력값 검증 결과에 따른 로그 출력
    }

    /**
     * <pre>
     * 숫자야구 맞추기 성공 후 게임재시작 여부 확인
     * "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요."  - 1:재시작, 2:종료
     * </pre>
     * @author 김재범
     **/
    private void restart() {
        //TODO 재시작 여부 문의 로직
    }
}
