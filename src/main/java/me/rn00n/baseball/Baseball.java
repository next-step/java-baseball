package me.rn00n.baseball;

import me.rn00n.baseball.pitcher.Pitcher;

import java.util.Scanner;

public class Baseball {

    private Pitcher pitcher = null;

    public int NUMBER_LENGTH = 3;

    Scanner scanner = new Scanner(System.in);

    public Baseball() {
    }

    public Baseball(int numberLength) {
        this.NUMBER_LENGTH = numberLength;
    }

    /**
     * 숫자입력 후 검증
     * @return number
     */
    private int inputNumber() {
        int number = 0;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            number = scanner.nextInt();
        } while (validateInputNumber(number)); // 검증(중복체크)

        return number;
    }
    /** 숫자 검증 **/
    public boolean validateInputNumber(int number) {
        int equalsNumber = 0;
        String s_number = String.valueOf(number);
        if (s_number.length() != NUMBER_LENGTH) { // 자릿수 확인
            return true;
        }
        if (number == 0) { // 빈 입력 확인
            return true;
        }
        for (int i = 0; i < NUMBER_LENGTH-1; i++) { // 중복숫자 확인
            String tempNumber = s_number.substring(i+1); // 현재 인덱스를 제외한 자릿수 문자열 생성
            equalsNumber += containsNumber(s_number.charAt(i), tempNumber);
        }
        return equalsNumber > 0; // 중복이 있으면 false
    }
    /** 중복 숫자 검증 **/
    private int containsNumber(char c_number, String tempNumber) {
        String s_number = String.valueOf(c_number);
        if (tempNumber.contains(s_number)) {
            return 1; // 중복
        }
        return 0;
    }

    /**
     * 결과 확인, 힌트 출력
     * @param number
     * @return ResultStatus
     */
    public ResultStatus getResult(int number) {
        if (pitcher.getStrike(number) >= String.valueOf(number).length()) { // 모두 예측성공
            System.out.println("숫자를 모두 맞히셨습니다! 게임종료");
            return ResultStatus.WIN;
        }
        if (pitcher.isNothing(number)) { // 포볼(낫싱)
            System.out.println("낫싱");
            return ResultStatus.NOTHING;
        }
        hintForStrikeAndBall(pitcher.getStrike(number), pitcher.getBall(number)); // 힌트 출력
        return ResultStatus.STRIKE_BALL;
    }
    /** 스트라이크와 볼에 대한 힌트 출력 **/
    private void hintForStrikeAndBall(int strike, int ball) {
        if (strike > 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + " 볼 ");
        }
        System.out.println();
    }

    /* Getter, Setter (테스트 코드에서 사용) */
    public Pitcher getPitcher() {
        return pitcher;
    }

    public void setPitcher(Pitcher pitcher) {
        this.pitcher = pitcher;
    }
}
