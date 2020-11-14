import domain.Check;
import domain.Com;
import service.BaseService;

import java.util.Scanner;

public class function {

    public static void main(String[] args) {
        while(true){
            Com com = new Com().invoke();
            System.out.println("Com : " + com.output());

            while(true) {
                Check check = new Check(0, 0, com.output(), BaseService.getUserNum()).invoke();
                int st = check.getSt();
                int ball = check.getBall();

                if(BaseService.resultCheck(st, ball) != true) break;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력 하세요.");
            String ch = scanner.next();

            if(BaseService.playChoice(ch)) break;
        }
        System.out.println("게임을 종료합니다.");
    }


}
