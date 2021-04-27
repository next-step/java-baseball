package core;
import java.util.List;

public class PlayResult {
    private int isStrike = 0;
    private int isBall = 0;

    public int getIsStrike() {
        return isStrike;
    }

    public int getIsBall() {
        return isBall;
    }

    public void countPlayResult(List<Integer> questions, int index, List<Integer> answer){
        if(questions.get(index).equals(answer.get(index))){
            this.isStrike++;
            return;
        }
        
        if(questions.contains(answer.get(index))){
            this.isBall++;
        }
    }

    public boolean isNothing() {
        return this.isStrike == 0 && this.isBall == 0;
    }

    public boolean isSolved() {
        return this.isStrike == 3;
    }

}
