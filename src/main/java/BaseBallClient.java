import domain.BaseballType;
import exception.BaseBallException;
import service.BaseBallUtilService;
import service.BaseBallUtilServiceImpl;
import util.BaseBallUtil;

import java.util.*;

public class BaseBallClient {
    private static boolean isGame = true;
    private static int [] computerNumber = new int [3];
    private static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        BaseBallUtilService ballUtilService = new BaseBallUtilServiceImpl();
        computerNumber = ballUtilService.numGenerator();

        while(isGame){
            System.out.print("숫자를 입력해주세요 : ");
            String input = scan.next();
            BaseBallException.throwsCheck(input);
            int [] userNumber = ballUtilService.userNumGenerator(input);
            int strikeCnt = ballUtilService.getStrikeCount(computerNumber,userNumber);
            int ballCnt = ballUtilService.getBallCount(computerNumber,userNumber);
            Map<String,Integer> map = ballUtilService.setBaseballMap(strikeCnt,ballCnt);
            ballUtilService.resultPrint(map);
        }
    }

    //게임 재시작 여부 판단.
    public static void isReGame(int gameFlag){
        if(gameFlag == 1){
            BaseBallUtil newBaseBallUtil = new BaseBallUtil();
            computerNumber = newBaseBallUtil.numGenerator();
            return;
        }
        isGame = false;
        System.out.println("게임을 종료합니다.");
        scan.close();

    }
    //게임 종료 마지막 출력
    public static void lastPrint(int strike){
        int gameFlag = 1;
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작 하려면 1, 종료 하려면 2를 입력하세요.");
            gameFlag = scan.nextInt();
            isReGame(gameFlag);
        }

    }

    //결과 출력 처리.
    public static void resultPrint(Map<String,Integer> map){
        if(map.get(BaseballType.STRIKE.name()) > 0 && map.get(BaseballType.BALL.name()) > 0){
            System.out.println(map.get(BaseballType.STRIKE.name()) + BaseballType.STRIKE.getType() + map.get(BaseballType.BALL.name()) + BaseballType.BALL.getType());
        }
        if(map.get(BaseballType.STRIKE.name()) > 0 && map.get(BaseballType.BALL.name()) == 0){
            System.out.println(map.get(BaseballType.STRIKE.name()) + BaseballType.STRIKE.getType());
        }
        if(map.get(BaseballType.STRIKE.name()) == 0 && map.get(BaseballType.BALL.name()) > 0){
            System.out.println(map.get(BaseballType.BALL.name()) + BaseballType.BALL.getType());
        }
        lastPrint(map.get(BaseballType.STRIKE.name()));
    }


}
