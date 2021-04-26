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
        boolean isFinished = false;
        while( !isFinished ) {
            isFinished = startOneGame( quizNumber );
        }
        boolean isReset = ui.getReset();
        reStart( isReset );
    }
    
    protected void reStart( boolean isReset ) {
        if( isReset ) {
            start();
        }
    }
    
    protected boolean startOneGame( int quizNumber ) {
        int userNumber = ui.getNumber();
        String[] quizNumberDigts = castNumberToStringArrays( quizNumber );
        String[] userNumberDigts = castNumberToStringArrays( userNumber );
        int strikeCount = getStrikeCountFrom( quizNumberDigts, userNumberDigts );
        int ballCount = getBallCountFrom( quizNumberDigts, userNumberDigts );

        return checkStrikeAndBall( strikeCount, ballCount );
    }
    
    protected boolean checkStrikeAndBall( int strikeCount, int ballCount ) {
        if( strikeCount == 3 ) {
            showBallAndStrikeInfo(strikeCount, ballCount);
            return true;
        }
        
        showNothingInfo(strikeCount, ballCount);
        showBallAndStrikeInfo(strikeCount, ballCount);
       
        return false;
    }
    
    protected void showNothingInfo( int strikeCount, int ballCount ) {
        if( strikeCount == 0 && ballCount == 0  ) {
            ui.nothing();
        }
    }
    
    protected void showBallAndStrikeInfo( int strikeCount, int ballCount ) {
        if( strikeCount != 0 || ballCount != 0  ) {
            ui.strikeAndBall(strikeCount, ballCount);
        }
    }
    
    protected String[] castNumberToStringArrays( int quizNumber ) {
        return String.valueOf(quizNumber).split("");
    }

    protected int getBallCountFrom( String[] quizNumberDigts, String[] userNumberDigts ) {
        int result = 0;
        for( int userIndex = 0; userIndex < userNumberDigts.length; userIndex++ ) {
            result += ballCountWithUserIndex( quizNumberDigts, userNumberDigts, userIndex );
        }
        return result;
    }
    
    protected int ballCountWithUserIndex( String[] quizNumberDigts, String[] userNumberDigts, int userIndex ) {
        int result = 0;
        for( int quizIndex = 0; quizIndex < 3 && result != 1; quizIndex++ ) {
            result = ballCountWithUserIndexAndQuizIndex( quizNumberDigts, userNumberDigts, userIndex, quizIndex );
        }
        return result;
    }
    
    protected int ballCountWithUserIndexAndQuizIndex( String[] quizNumberDigts, String[] userNumberDigts, int userIndex, int quizIndex ) {
        int result = 0;
        if( userIndex != quizIndex ) {
            result = numberCompare(userNumberDigts[userIndex], quizNumberDigts[quizIndex]);
        }
        return result;
    }

    protected int getStrikeCountFrom( String[] quizNumberDigts, String[] userNumberDigts ) {
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
