import java.util.List;

public class GuessNumber {

    protected void guessNumber(BaseBallDTO dto){
        int index = 0 ;
        for(String str:dto.getInputNumbers()) {
            dto.setForLoopIndex(index++);
            ballCountCheck(dto);
        }
    }

    private int ballCountCheck(BaseBallDTO dto){
        int value = returnStrike(dto);
        if(value==0){
            value = returnBall(dto);
            return value;
        }
        return value;
    }

    private int returnStrike(BaseBallDTO dto){
        int value = 0;
        List enemyNumbers = dto.getEnemyNumbers();
        String myNumber = dto.getInputNumbers().get(dto.getForLoopIndex());
        if(enemyNumbers.get(dto.getForLoopIndex()).equals(myNumber)) {
            dto.setCountOfStrike(dto.getCountOfStrike()+1);
            return 1;
        }
        return value;
    }

    private int returnBall(BaseBallDTO dto){
        int value = 0;
        List enemyNumbers = dto.getEnemyNumbers();
        String myNumber = dto.getInputNumbers().get(dto.getForLoopIndex());
        if(enemyNumbers.contains(myNumber)) {
            dto.setCountOfBall(dto.getCountOfBall()+1);
            return 2;
        }
        return value;
    }

}