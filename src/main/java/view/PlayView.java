package view;

import java.util.Scanner;

public class PlayView {

    public boolean playResultView(int[] score){

        if(score[0] == 3){
            System.out.println(score[0] + "스트라이크");
            return true;
        }

        playScoreView(score[0], score[1]);

        return false;
    }

    public void playScoreView(int strikeCount, int ballCount){
        StringBuffer resultView = new StringBuffer();
        if(strikeCount != 0)
            resultView.append(strikeCount).append(" 스트라이크");
        if(ballCount != 0)
            resultView.append(ballCount).append(" 볼");
        if(strikeCount == 0 && ballCount == 0)
            resultView.append("포볼");

        System.out.println(resultView.toString());
    }

    public boolean restartGaemView(){

        System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        if(choice == 1)
            return true;

        return false;
    }

}
