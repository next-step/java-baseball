public enum GameSetting {

    COUNT(9),
    LENGTH(3);
    int value;

    GameSetting(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
