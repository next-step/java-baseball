package com.techcamp;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 * com.techcamp
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
     *     숫자 야구 시작 전 초기화
     *     정답 clear, 진행여부값 초기화, 정답 설정
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
     *     정답(answer) 출력
     *     테스트를 위한 임시 메서드
     * </pre>
     * @author 김재범
     **/
    public String getAnswer() {
        return answer;
    }

    /**
     * <pre>
     *     정답(answer) 설정
     *     테스트를 위한 임시 메서드
     * </pre>
     * @param answer
     * @author 김재범
     **/
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * <pre>
     *     숫자야구 정답 3자리 숫자 생성
     *     0~9 숫자 3자리. 중복허용X
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
     *     숫자 야구 게임 시작 메서드
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
     *     숫자 야구 게임 진행
     *     숫자 야구 게임을 위해 입력갑 입력
     * </pre>
     * @author 김재범
     **/
    public void input() {
        input(null);
    }

    public void input(String in) {
        System.out.print("숫자를 입력해주세요 : ");
        input = in;
        if(in == null) {
            input = new Scanner(System.in).next();
        }
        validation();
    }

    /**
     * <pre>
     *      입력값 유효성 체크
     * </pre>
     * @author 김재범
     **/
    public void validation() {
        if(!input.chars().allMatch(Character::isDigit)) {
            System.out.println("숫자가 아닌값을 입력하셨습니다. 다시 입력해주십시요.");
            input();
        }
        if(input.trim().length() != 3) {
            System.out.println("입력한 값은 3자리 숫자여야 합니다. 다시 입력해주십시요.");
            input();
        }
    }

    /**
     * <pre>
     *     입력한 3자리 숫자에 대해 숫자야구 게임 검증
     *     자리까지 동일 - 스트라이크, 숫자만 동일 - 볼
     * </pre>
     * @author 김재범
     **/
    public void check() {
        int strike  = 0;
        int ball    = 0;
        if(answer.charAt(0) == input.charAt(0)) strike++;
        if(answer.charAt(0) != input.charAt(0) && answer.contains(String.valueOf(input.charAt(0)))) ball++;
        if(answer.charAt(1) == input.charAt(1)) strike++;
        if(answer.charAt(1) != input.charAt(1) && answer.contains(String.valueOf(input.charAt(1)))) ball++;
        if(answer.charAt(2) == input.charAt(2)) strike++;
        if(answer.charAt(2) != input.charAt(2) && answer.contains(String.valueOf(input.charAt(2)))) ball++;
        result(strike, ball);
    }

    /**
     * <pre>
     *     입력값 검증 결과에 따른 로그 출력
     *     ex> 1 스트라이크, 1 볼, 1스트라이크 2볼, 낫싱
     * </pre>
     * @author 김재범
     **/
    public void result(int strike, int ball) {
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isContinue = false;
            return;
        }
        System.out.println((strike == 0 && ball == 0) ? "낫싱":
                strike > 0 ? strike + " 스트라이크 ":
                        ball > 0 ? ball + " 볼":""
        );
    }

    /**
     * <pre>
     *     숫자야구 맞추기 성공 후 게임재시작 여부 확인
     *     "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요."  - 1:재시작, 2:종료
     * </pre>
     * @author 김재범
     **/
    public void restart() {
        //TODO 재시작 여부 문의 로직
    }
}
