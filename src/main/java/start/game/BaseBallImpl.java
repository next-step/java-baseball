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
        int quizNumber = getNonDuplicatedThreeDigitNumber( 1, 10 );
        int userNumber = ui.getNumber();
        int strikeCount = getStrikeCountFrom( quizNumber, userNumber );
    }
    
    protected int getStrikeCountFrom(int quizNumber, int userNumber) {
        String[] quizNumberDigts = String.valueOf(quizNumber).split("");
        String[] userNumberDigts = String.valueOf(userNumber).split("");
        int result = 0;
        for( int index = 0; index < userNumberDigts.length; index++ ) {
            result += numberCompare( userNumberDigts[index], quizNumberDigts[index] );
        }
        return result;
    }
    
    protected int numberCompare( String first, String second ) {
        return first.equals( second ) ? 1 : 0 ;
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
