package basball;

import basball.application.Baseball;

public class Main {
    public static void main(String [] args){
        System.out.println("=========start=========");
        Baseball baseballApp = new Baseball();
        baseballApp.startGame();
        System.out.println("==========end==========");
    }
}
