package pp.finalproject.model;

public class Operand {
    /**
     * Framework for types.
     * Allows for typechecking and cleaner codes in the parser.
     */
    private final Type type;

    protected Operand(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        REG,
        NUM,
        MEMADDR,
        TARGET,
        OPERATOR,
        BOOL
    }
}
