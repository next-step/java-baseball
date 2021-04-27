package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    
    private List<Integer> questions = new ArrayList<>(3);
    private List<Integer> answer = new ArrayList<>(3);
    private Scanner scanner = new Scanner(System.in);

    public void runGame() {
        makeQuestion();
        System.out.println(questions);
        playGame();
    }

    public void makeQuestion(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);

        questions.addAll(list.subList(0, 3));
    }
    
    public void playGame(){
        System.out.println("숫자를 입력하세요 : ");
        String numberString = scanner.nextLine();

        for(int i=0; i < numberString.length(); i++){
            answer.add(Integer.parseInt(numberString.substring(i, i+1)));
        }
        System.out.println(answer);
    }
}