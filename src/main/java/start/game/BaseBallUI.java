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
    
}
