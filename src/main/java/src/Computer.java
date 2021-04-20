import java.util.*;

public class Computer {
    private ArrayList computerNum = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9));
    private ArrayList computerResultNums = new ArrayList();
    public Computer() {
        this.ComputerNumReset();
    }
    public ArrayList getComputerNumList(){
        return this.computerResultNums;
    }
    private void ComputerNumReset() {
        this.computerResultNums.clear();
        Collections.shuffle(computerNum);
        this.computerResultNums.add(Integer.toString((Integer) this.computerNum.get(0)));
        this.computerResultNums.add(Integer.toString((Integer)this.computerNum.get(1)));
        this.computerResultNums.add(Integer.toString((Integer)this.computerNum.get(2)));
    }

}