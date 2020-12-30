package common;

public enum GameMode {

    PLAY(1),
    END(2);

    public int number;

    private GameMode(int number){
        this.number = number;
    }

}
