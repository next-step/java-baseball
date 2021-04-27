import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class IntroMain {

    public static void main(String[] args){
        boolean gameExit = false, gameDoneFlag = false;
        Integer pitcherNumer = null;
        Integer batterNumer = null;
        Integer digitNumber = 3;
        PlayBaseballUtil playBaseballUtil = new PlayBaseballUtil();
        Scanner sc = new Scanner(System.in);

        System.out.println("[프리코스 숫자야구게임]");
        System.out.println("상대방(PC)와 사용자(본인)과 서로다른 수로");
        System.out.println("이루어진 3자리 수를 맞추는 게임 입니다");


        while (gameExit == false){
            String tempStr = null;
            pitcherNumer = playBaseballUtil.getRandomNumber(digitNumber);
            System.out.println("");

            do {
                try {
                    List<Integer> gameResultList = null;
                    String checkBatterNum = null;
                    System.out.println("번호 : " + pitcherNumer);
                    System.out.print("숫자를 입력해주세요 : ");

                    batterNumer = sc.nextInt();
                    checkBatterNum = batterNumer.toString();
                    gameResultList = null;

                    if (checkBatterNum.length() < digitNumber){
                        System.out.println(digitNumber + " 자리 숫자로 입력해주세요.");
                    } else {
                        gameResultList = playBaseballUtil.getBattingResult(batterNumer, pitcherNumer);
                        if (gameResultList.get(0) ==0 && gameResultList.get(1)==0){
                            System.out.print("낫싱");
                        } else {
                            if (gameResultList.get(0) !=0){
                                System.out.print(gameResultList.get(0) + " 스트라이트 ");
                            }
                            if (gameResultList.get(1) !=0){
                                System.out.print(gameResultList.get(1) + "볼");
                            }
                        }
                        System.out.println("");
                        if (digitNumber == gameResultList.get(0)){
                            Integer gamePlayPlag = null;

                            System.out.println("3개의 숫자를 모두맞히셨습니다! 게임종료");
                            System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요");

                            gamePlayPlag = sc.nextInt();
                            gameDoneFlag = true;

                            if (gamePlayPlag == 1){
                                gameExit = false;
                            } else if (gamePlayPlag==2) {
                                gameExit = true;
                            }
                        }
                    }
                } catch (InputMismatchException ime){
                    System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
                    sc = new Scanner(System.in);
                }
            } while (gameDoneFlag == false);
        }
    }
}
