package baseball.bo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player {

    private String strikeNumber;

    public String getStrikeNumber() {
        return strikeNumber;
    }

    public void inputStrikeNumber() {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("숫자를 입력해 주세요.");
            this.strikeNumber = scan.nextLine();
        } while(!isValid(this.strikeNumber));
    }

    /**
     * 입력숫자 검증
     *  - 3자리 입력여부
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
        if(strikeNumber==null || strikeNumber.length()!=3) {
            System.out.println("3자리의 숫자를 입력해 주세요.");
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
        if(strikeNumber.contains("0")) {
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
        if(stringSet.size()<3) {
            System.out.println("중복된 숫자를 입력하였습니다. 다시 입력해 주세요");
            return false;
        }
        return true;
    }
}
