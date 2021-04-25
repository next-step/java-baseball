package controller;

import view.PlayView;
import domain.BaseBallNumberInfo;
import util.RandomNumberUtil;

import java.util.List;

public class PlayGameController {

    UserController userController;
    BaseBallNumberInfo baseBallNumberInfo;
    GameController gameController;
    PlayView playView;

    public PlayGameController(){
        userController = new UserController();
        baseBallNumberInfo = new BaseBallNumberInfo();
        gameController = new GameController();
        playView = new PlayView();
    }

    public void initGame(){
        RandomNumberUtil.makeBaseBall(baseBallNumberInfo);
        testView(baseBallNumberInfo.getBaseBallRandomNumberList());
        playGame(baseBallNumberInfo.getBaseBallRandomNumberList());
    }

    public void playGame(List<Integer> baseBallNumberList){

        boolean correctChk = false;
        while(correctChk == false){
            userController.makeUserNumberInfo();
            correctChk = playView.playResultView(gameController.checkGameScore(baseBallNumberList,
                    userController.getUserNumberInfo().getUserInputNumberList()));
        }

        if(playView.restartGaemView()) {
            initGame();
        }
    }

    public static void testView(List<Integer> liatA){
        for(int i=0; i<3; i++){
            System.out.println(liatA.get(i));
        }
    }

}
