package start.game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BaseBallImpl implements BaseBall {
    
    private BaseBallUI ui;
    
    public BaseBallImpl() {}
    
    public BaseBallImpl(BaseBallUI ui) {
        this.ui = ui;
    }

    @Override
    public void start() {
        int userNumber = ui.getNumber();
    }
    
    protected int getNonDuplicatedThreeDigitNumber( int min, int max ) {
        List<Integer> list = new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        int result = 0;
        for( int index = 0; index < 3; index++ ) {
            int number = getOneDigitNumber(1, max-index);
            result += list.get(number)*Math.pow(10, index);
            list.remove(number);
        }
        return result;
    } 
    
    protected int getOneDigitNumber( int min, int max ) {
        return (int)( ( Math.random() * ( max - min + 1) ) + min );
    } 
}
