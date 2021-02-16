package domain;

public class MenuNumber {
    public static final String RESTART_NUMBER = "1";
    public static final String EXIT_NUMBER = "2";
    private final String menu;

    public MenuNumber(String menu) {
        validateMenu(menu);
        this.menu = menu;
    }

    private void validateMenu(String menu) {
        if (!menu.equals(RESTART_NUMBER) && !menu.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    public String getMenu() {
        return menu;
    }
}
