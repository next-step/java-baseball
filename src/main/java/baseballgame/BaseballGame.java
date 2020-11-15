package baseballgame;

import baseballgame.contract.BaseballContract;
import lombok.Getter;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    Random r;
    Scanner sc;
    int strikeOutCount = 3;
    @Getter
    private String baseballNumber;

    BaseballGame() {
        r = new Random();
        sc = new Scanner(System.in);
    }

    // 게임에 필요한 3자리 숫자 초기화
    public void initGame() {
        int randomNumberSize = 3;
        baseballNumber = getRandomNumberString(randomNumberSize);
    }

    // 게임 시작
    public void startGame() {
        boolean outFlag = false;
        System.out.println(BaseballContract.GAME_START);
        while (!outFlag) {
            System.out.println(BaseballContract.WAIT_INPUT);
            String inputString = sc.nextLine();
            int strikeCount = getStrikeCount(inputString);
            int ballCount = getBallCount();
            outFlag = isStrikeOut(strikeCount);
        }
    }

    // 스트라이크 카운트 
    public int getStrikeCount(String userInput) {
        return 0;
    }

    // 볼 카운트
    public int getBallCount() {
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
