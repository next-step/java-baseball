package baseball.bo;

import baseball.constant.AppConstant;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player {

    private String strikeNumber;

    public String getStrikeNumber() {
        return strikeNumber;
    }

    /**
     * User 숫자 입력 메소드
     *  - 검증규칙에 맞는 숫자를 입력할 때까지 루프실행
     */
    public void inputStrikeNumber() {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("숫자를 입력해 주세요.");
            strikeNumber = scan.nextLine();
        } while (!isValid(strikeNumber));
    }

    /**
     * 입력숫자 검증
     *  - STRIKE number 자리수 입력여부
     *  - 숫자 입력여부
     *  - 숫자 0 입력여부
     *  - 중복문자 입력여부
     * @param strikeNumber 플레이어가 입력한 입력숫자 데이터
     * @return 데이터 정합성 만족여부
     */
    private boolean isValid(String strikeNumber) {
        return isLengthCorrect(strikeNumber) && isFormatCorrect(strikeNumber) && !isContainsZero(strikeNumber) && !isContainsDuplicateNumber(strikeNumber);
    }

    private boolean isLengthCorrect(String strikeNumber) {
        if (strikeNumber==null || strikeNumber.length()!= AppConstant.STRIKE_NUMBER) {
            System.out.println(AppConstant.STRIKE_NUMBER + "자리의 숫자를 입력해 주세요.");
            return false;
        }
        return true;
    }

    private boolean isFormatCorrect(String strikeNumber) {
        try {
            Integer.parseInt(strikeNumber);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값을 입력하였습니다. 다시 입력해 주세요");
            return false;
        }
        return true;
    }

    private boolean isContainsZero(String strikeNumber) {
        if (strikeNumber.contains("0")) {
            System.out.println("각 자리의 숫자는 1~9 까지의 값을 입력할 수 있습니다.");
            return true;
        }
        return false;
    }

    private boolean isContainsDuplicateNumber(String strikeNumber) {
        Set<String> stringSet = new HashSet<>();
        for (char c : strikeNumber.toCharArray()) {
            stringSet.add(String.valueOf(c));
        }
        if (stringSet.size()<strikeNumber.length()) {
            System.out.println("중복된 숫자를 입력하였습니다. 다시 입력해 주세요");
            return true;
        }
        return false;
    }
}
