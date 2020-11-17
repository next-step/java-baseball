package me.rn00n.baseball;

import java.util.Scanner;

public class Baseball {

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
}
