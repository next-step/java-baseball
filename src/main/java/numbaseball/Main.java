package numbaseball;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        //3자리 난수 arrayList 생성
        List<Integer> PlayNumber = Play.createPlayNumber();
        Ui.startPlayGame();
        List<Integer> nInputNumber = Play.getInputNumber();
        System.out.println(PlayNumber);
        System.out.println(nInputNumber);


    }
}

