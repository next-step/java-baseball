package mainservice;

import interfaces.Game;
import service.GameImplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        GameImplement game = new GameImplement();
        int inputNum = 0;
        while(inputNum !=2){
            //start Game
            game.play();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            inputNum = Integer.parseInt(br.readLine());
        }



    }
}
