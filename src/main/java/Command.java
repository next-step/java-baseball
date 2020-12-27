public enum Command {
    CONTINUE,
    END,
    UNDEFINED;

    public static Command getCommand(int x) throws IllegalArgumentException{
        if (x == 1) return CONTINUE;
        if (x == 2) return END;
        return UNDEFINED;
    }
}
