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
        ID userID = new ID();
        do {
            userID.genByTyping();
        }while(!"same".equals(computerID.compare(userID)));
    }

    public static boolean askForContinue(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        return 2 != sc.nextInt();
    }
}
