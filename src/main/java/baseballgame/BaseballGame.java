package baseballgame;

import baseballgame.contract.BaseballContract;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    Random r;
    Scanner sc;
    int strikeOutCount = 3;

    @Getter
    @Setter
    private String baseballNumber;

    BaseballGame() {
        r = new Random();
        sc = new Scanner(System.in);
    }

    // 게임 초기화
    public void initGame() {
        // 게임 숫자 3자리 초기화
        int randomNumberSize = 3;
        baseballNumber = getRandomNumberString(randomNumberSize);
        System.out.println(baseballNumber);
    }

    // 게임 시작
    public void startGame() {
        boolean gameover = false;
        System.out.println(BaseballContract.GAME_START);
        while (!gameover) {
            System.out.println(BaseballContract.WAIT_INPUT);
            String userInput = sc.nextLine();
            int strikeCount = getStrikeCount(baseballNumber, userInput);
            int ballCount = getBallCount(baseballNumber, userInput);
            gameover = isStrikeOut(strikeCount);
        }
        System.out.println(BaseballContract.GAME_END);
    }

    // 스트라이크 카운트 
    public int getStrikeCount(String gameNumber, String userInput) {
        int count = 0;
        char[] userInputArr = userInput.toCharArray();
        char[] baseballNumberChar = gameNumber.toCharArray();

        for (int i = 0; i < userInputArr.length; i++) {
            count += getSameWeight(userInputArr[i], baseballNumberChar[i]);
        }
        System.out.println(BaseballContract.STRIKE + ": " + count);
        return count;
    }

    // 같음 여부 체크 후 가중치 획득
    public int getSameWeight(char actual, char expect) {
        if (actual == expect) {
            return 1;
        }
        return 0;
    }

    // 볼 카운트
    public int getBallCount(String gameNumber, String userInput) {
        int count = 0;
        char[] userInputArr = userInput.toCharArray();
        char[] baseballNumberChar = gameNumber.toCharArray();

        for (int i = 0; i < userInputArr.length; i++) {
            count += getDiffWeight(userInputArr[i], baseballNumberChar[i]);
        }
        System.out.println(BaseballContract.BALL + ": " + count);
        return count;
    }

    // 다름 여부 체크 후 가중치 획득
    public int getDiffWeight(char actual, char expect) {
        if (actual != expect) {
            return 1;
        }
        return 0;
    }

    // 스트라이크 아웃 판단
    public boolean isStrikeOut(int strikeCount) {
        return strikeCount == strikeOutCount;
    }

    // 랜덤 숫자 문자열 생성
    public String getRandomNumberString(int size) {
        String numberString = "";

        for (int i = 0; i < size; i++) {
            int v = r.ints(0, 10)
                    .findFirst()
                    .orElse(0);
            numberString = numberString.concat(Integer.toString(v));
        }

        return numberString;
    }
}
