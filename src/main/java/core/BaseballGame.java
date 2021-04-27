package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballGame {
    
    private List<Integer> questions = new ArrayList<>(3);

    public void playGame() {
        makeQuestion();
       
    }

    public void makeQuestion(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);

        questions.add(list.get(0));
        questions.add(list.get(1));
        questions.add(list.get(2));
    }
    
}