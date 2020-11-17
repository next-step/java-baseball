package baseball;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 야구 게임 클래스
 */
public class BaseballGame {

    public final int NUMBER_SIZE = 3;   // 숫자 사이즈

    private BaseballGameHint hint;              // 야구게임 힌트
    private ArrayList<Integer> correctNumbers;  // 정답 숫자 리스트
    private ArrayList<Integer> inputNumbers;    // 입력 숫자 리스트

    // 1부터 9까지 서로 다른 3자리 임의의 수 생성 클래스
    private final BaseballNumberMaker numberMaker = new BaseballNumberMaker();

    /** Getter, Setter **/
    public BaseballGameHint getHint() {
        return hint;
    }
    public ArrayList<Integer> getCorrectNumbers() {
        return correctNumbers;
    }
    public void setCorrectNumbers(ArrayList<Integer> correctNumbers) {
        this.correctNumbers = correctNumbers;
    }
    public ArrayList<Integer> getInputNumbers() {
        return inputNumbers;
    }

    /**
     * 정답 숫자 리스트 설정
     */
    public void setCorrectNumbers() {
        this.correctNumbers = numberMaker.makeNonDuplicateRandomNumber();
    }

    /**
     * 입력 숫자 리스트 설정
     * @param inputNumberString 입력 문자열
     */
    public void setInputNumbers(String inputNumberString) {
        if (!BaseballInputValidator.validate(inputNumberString)) { start(); return; }
        int length = inputNumberString.length();
        ArrayList<Integer> inputNumbers = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            int number = Character.getNumericValue(inputNumberString.charAt(i));
            inputNumbers.add(number);
        }
        this.inputNumbers = inputNumbers;
    }

    /**
     * 야구 게임 시작
     */
    public void start() {
        System.out.print("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        setInputNumbers(scanner.next());
        calculateHint();
        if (isCorrect()) { gameOver(); return; }
        start();
    }

    /**
     * 야구 게임 힌트 계산하기
     */
    public void calculateHint() {
        this.hint = new BaseballGameHint(this.correctNumbers, this.inputNumbers);
        this.hint.create();
        this.hint.print();
    }

    /**
     * 정답 여부 확인
     * @return  정답일 경우 true, 정답이 아닐경우 false
     */
    private boolean isCorrect() {
        return this.hint.getStrike().getCount() == NUMBER_SIZE;
    }

    /**
     * 야구 게임 종료
     */
    private void gameOver() {
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 2) {
            return;
        }
        setCorrectNumbers();
        start();
    }

}