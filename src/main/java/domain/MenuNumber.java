package domain;

public class MenuNumber {
    String menu;

    public MenuNumber(String menu) {
        validateMenu(menu);
        this.menu = menu;
    }

    private void validateMenu(String menu) {
        if (!menu.equals("1") && !menu.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    public String getMenu() {
        return menu;
    }
}
