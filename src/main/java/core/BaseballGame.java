package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import util.InputNumberUtil;

public class BaseballGame {
    
    private List<Integer> questions = new ArrayList<>(3);
    private List<Integer> answer = new ArrayList<>(3);
    private Scanner scanner = new Scanner(System.in);
    private boolean isSolved = false;

    public void runGame() {
        makeQuestion();
        System.out.println(questions);
        while(!isSolved) {
            playGame();
        }
    }

    public void makeQuestion() {
        questions = new ArrayList<>(3);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);
        
        questions.addAll(list.subList(0, 3));
    }

    public void playGame() {
        System.out.println("숫자를 입력하세요 : ");
        String numberString = scanner.nextLine();

        if(!InputNumberUtil.checkInputNumber(numberString)) {
            return;
        }

        answer = InputNumberUtil.toIntegerList(numberString);
        playGameResult();
    }
    
    public void playGameResult() {
        PlayResult playResult = new PlayResult();
        for(int i = 0; i < 3; i++) {
            playResult.countPlayResult(questions, i, answer);
        }
        isSolved = playResult.isSolved();
        printGameResult(playResult);
    }

    public void printGameResult(PlayResult playResult) {
        if(playResult.isNothing()) {
            System.out.println("낫싱");
            return;
        } 
        
        if(playResult.isSolved()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restart();
            return;
        }

        if(playResult.getIsStrike() != 0 && playResult.getIsBall() != 0) {
            System.out.println(playResult.getIsStrike() + " 스트라이크 " + playResult.getIsBall() + " 볼");
        } else if(playResult.getIsStrike() != 0) {
            System.out.println(playResult.getIsStrike() + " 스트라이크");
        } else if(playResult.getIsBall() != 0) {
            System.out.println(playResult.getIsBall() + " 볼");
        }
    }

    public void restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        
        if (input.equals("1")) {
            isSolved = false;
            runGame();
        }
    }
}
