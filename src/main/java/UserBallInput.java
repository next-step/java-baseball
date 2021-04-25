public class UserBallInput {
    private int maxLen;

    public UserBallInput(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public UserBallInput(int maxLen){
        this.maxLen = maxLen;
    }
}
