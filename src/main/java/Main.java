class ID{
    private int[] arr;
    public void genByRandom(){
    }
    public void genByTyping(){
    }
    public String compare(ID o){
    }
}

public class Main {

    public static void main(String[] args) {
        do{
            ID computerID = new ID();
            computerID.genByRandom();
            processToFindComputerID(computerID);
        }while(askForContinue());
    }

    public static void processToFindComputerID(ID computerID){
    }

    public static boolean askForContinue(){
    }
}
