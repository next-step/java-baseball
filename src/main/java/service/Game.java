package service;

import domain.PitchingResult;
import domain.ValidationResult;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();
    Pitching pitching = new Pitching();

    public void start() {
        boolean nextInning = true;
        while (nextInning) {
            play();
            nextInning = nextInning();
        }
        scanner.close();
    }

    public void play(){
        BaseballNumber baseballNumber = new BaseballNumber();
        int[] baseball = baseballNumber.getBaseballNumber();
        boolean inning = false;
        while(!inning){
            System.out.print("숫자를 입력해주세요 : ");
            String playerInput = scanner.nextLine();
            ValidationResult validationResult = validation.validationPitching(playerInput);
            if(!validationResult.isResult()){
                System.out.println(validationResult.getMessage());
                continue;
            }

            PitchingResult pitchingResult = pitching.getPitchingResult(validationResult.getPitches(),baseball);
            inning = getPitchData(pitchingResult);
        }
    }

    public boolean getPitchData(PitchingResult pitchingResult){
        if(pitchingResult.isResult()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if(pitchingResult.isNothing()){
            System.out.println("낫싱");
            return false;
        }

        String result = "";
        if(pitchingResult.getStrike()>0){
            result += pitchingResult.getStrike() +"스트라이크 ";
        }

        if(pitchingResult.getBall()>0){
            result += pitchingResult.getBall() +"볼 ";
        }
        System.out.println(result);
        return false;
    }

    public boolean nextInning(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String nextInning = scanner.nextLine();
        if(nextInning.equals("1")){
            return true;
        }
        return false;
    }
}
