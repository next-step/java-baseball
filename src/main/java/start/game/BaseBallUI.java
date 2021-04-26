package start.game;

import java.util.Scanner;

public class BaseBallUI {
    private Scanner scanner;
    
    public BaseBallUI() {
        this.scanner = new Scanner( System.in );
    }
    
    public boolean getReset() {
        System.out.print( "다시 게임을 시작하시겠습니까? ( 0 - 다시시작, 1 - 프로그램 종료) : " );
        int resetInout = scanner.nextInt();
        
        return resetInout == 0;
    }
    
    public int getNumber() {
        System.out.print( "숫자를 입력해주세요 :" );
        return scanner.nextInt();
    }
    
    public void nothing() {
        System.out.println( "낫싱" );
    }
    
    public void strikeAndBall( int strike, int ball ) {
        System.out.println( strike + " 스트라이크 " + ball + " 볼" );
    }
}
