package numbaseball;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        //3자리 난수 arrayList 생성
        ArrayList<Integer> arrPlayNum = Play.createNumber();
    }
}

