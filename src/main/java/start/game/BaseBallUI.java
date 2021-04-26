package start.game;

import java.util.Scanner;

public class BaseBallUI {
    private Scanner scanner;
    
    public BaseBallUI() {
        this.scanner = new Scanner( System.in );
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
