public class Main {

    public static void main(String[] args){
        try {
            GameStartMachine gameStartMachine = new GameStartMachine();
            gameStartMachine.startGame();
        }catch(Exception e){
            System.out.print("BaseBall precourse Error : ");
            e.printStackTrace();
        }
    }
}
