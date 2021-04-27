import util.BaseBallUtil;

import java.util.Arrays;

public class BaseBallMain
{

    // 메인메소드
    public static void main(String[] args){
        // 게임 시작,종료 판단
        boolean isContinue = true;
        // 컴퓨터 랜덤값
        BaseBallUtil baseBallUtil = new BaseBallUtil();
        int[] computerNumbers = baseBallUtil.generatorNumbers();
        System.out.println(Arrays.toString(computerNumbers));
//        baseBallUtil.playGame(computerNumbers);
//        isContinue = gameEndCheck();

    }


}
