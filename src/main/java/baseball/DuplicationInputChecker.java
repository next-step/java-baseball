package baseball;

import java.util.ArrayList;
import java.util.List;

public class DuplicationInputChecker {
    private List<Character> appearedChars;

    public DuplicationInputChecker(){
        this.appearedChars = new ArrayList<>();
    }

    public Boolean isDuplicated(char[] targetChars) {
        int duplicationCnt = 0;
        this.appearedChars.clear();

        for (char targetChar : targetChars) {
            duplicationCnt += this.alreadyAppeared(targetChar);

            this.appearedChars.add(targetChar);
        }

        return duplicationCnt != 0;
    }

    private int alreadyAppeared(char c){
        return this.appearedChars.indexOf(c) == -1 ? 0 : 1;
    }
}
