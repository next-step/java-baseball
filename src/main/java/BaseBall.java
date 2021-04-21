public class BaseBall {

    private String input;

    public BaseBall(String input) {
        this.input = input;
    }

    public String play(String playerInput) {
        if (!input.contains(playerInput)) {
            return "4B";
        }

        return "";
    }
}
